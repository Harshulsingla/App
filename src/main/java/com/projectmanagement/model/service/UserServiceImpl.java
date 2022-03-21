package com.projectmanagement.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.dao.UserDao;
import com.projectmanagement.model.exception.ProjectUserNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		User user = userDao.findById(userId).orElseThrow(()-> new ProjectUserNotFoundException("User Not Found"));
		return user;
	}
	
	@Override
	public User getUserByUsername(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public User addUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public User deleteUser(Integer userId) {
		User userToDelete=userDao.getById(userId);
		userDao.delete(userToDelete);
		return userToDelete;
	}

	@Override
	public List<Project> addProject(Integer userId, Project project) {
		User user =getUserById(userId);
		List<Project>projects=user.getProjects();
		projects.add(project);
		return projects;
	}

	@Override
	public List<Project> removeProject(Integer userId, Project project) {
		User user =getUserById(userId);
		List<Project>projects=user.getProjects();
		projects.remove(project);
		return projects;
	}

	@Override
	public List<User> getAllocatableUser() {
		List<User> allocatableUsers= userDao.findByProfile("ROLE_USER");
		return allocatableUsers;
	}

	

	
	
	
	
}
