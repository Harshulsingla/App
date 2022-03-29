/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * ProjectServiceImpl : Class that implements the ProjectService Interface and have the definition of all business methods. 

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.ProjectDao;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.exception.ProjectNotFoundException;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectDao projectDao;
	
	/**
	 * Constructor that autowires Dao object in Service Object
	 * @param projectDao
	 */
	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	/**
	 * returns list of all projects
	 */
	@Override
	public List<Project> getAllProject() {
		return projectDao.findAll();
	}
	
	/**
	 * returns project having given Id
	 *@param projectId
	 *@return Project
	 */ 
	@Override
	public Project getProjectById(Integer projectId){
		
		return projectDao.findById(projectId).orElseThrow(()->new ProjectNotFoundException("No Project with this ID"));
	}
	
	/**
	 * add project to our database
	 * @param project
	 * @return Project
	 */
	@Override
	public Project addProject(Project project) {
		projectDao.save(project);
		return project;
	}
	
	/**
	 * delete project from our database
	 * @param projectId
	 * @return Project
	 * 
	 */
	@Override
	public Project deleteProject(Integer projectId) {
		Project projectToDelete=getProjectById(projectId);
		projectDao.delete(projectToDelete);
		return projectToDelete;
	}
	
	/**
	 * update project in our database
	 * @param projectDto
	 * @return Project
	 * 
	 */
	@Override
	public Project updateProjectDetails(ProjectDto projectDto) {
		Project project=DtoUtil.convertToProject(projectDto);
		projectDao.save(project);		
		return project; 	
	}
	

	/**
	 * returns list of project having name same as the given name
	 * @param projectName
	 * @return List<Project>
	 * 
	 */
	@Override
	public List<Project> getProjectByName(String projectName) {
		return projectDao.findByProjectNameContainingIgnoreCase(projectName);
	}
	
	/**
	 * returns list of project having status same as the given 
	 * @param status
	 * @return List<Project>
	 * 
	 */
	@Override
	public List<Project> getProjectByStatus(String status) {
		return projectDao.findByStatusContainingIgnoreCase(status);
	}
	
	/**
	 * returns list of project having client name same as the given 
	 * @param clientName
	 * @return List<Project>
	 * 
	 */
	@Override
	public List<Project> getProjectByClientName(String clientName) {
		return projectDao.findByClientNameContainingIgnoreCase(clientName);
	}
	
	
	
}
