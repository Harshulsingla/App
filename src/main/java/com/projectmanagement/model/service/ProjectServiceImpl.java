package com.projectmanagement.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.ProjectDao;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.exception.ProjectNotFoundException;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectDao projectDao;
	
	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public List<Project> getAllProject() {
		return projectDao.findAll();
	}

	@Override
	public Project getProjectById(Integer projectId) {
		Project project=projectDao.findById(projectId).orElseThrow(()->new ProjectNotFoundException("No Project with this ID"));
//		System.out.println("i am in get project by id method");
//		System.out.println(project);
		return project;
	}

	@Override
	public Project addProject(Project project) {
		projectDao.save(project);
		return project;
	}

	@Override
	public Project deleteProject(Integer projectId) {
		Project projectToDelete=getProjectById(projectId);
		projectDao.delete(projectToDelete);
		return projectToDelete;
	}

	@Override
	public Project updateProjectDetails(Integer projectId, ProjectDto projectDto) {
		Project project = getProjectById(projectId);
		project.setProjectName(projectDto.getProjectName());
		project.setClientName(projectDto.getClientName());
		project.setStartDate(projectDto.getStartDate());
		project.setEndDate(projectDto.getEndDate());
		project.setStatus(projectDto.getStatus());	
		project.setUsers(projectDto.getUsers());
		projectDao.save(project);		
		return project; 
		
	}
	
	public List<User> addUser(Integer id, User user){
		Project project=getProjectById(id);
		List<User> users=project.getUsers();
		users.add(user);
		return users;
	}
	
	public List<User> removeUser(Integer id, User user){
		Project project=getProjectById(id);
		List<User> users=project.getUsers();
		users.remove(user);
		return users;
	}

	@Override
	public List<Project> getProjectByName(String projectName) {
		List<Project> projects=projectDao.findByProjectName(projectName);
		
		return projects;
	}
	
	
	
}
