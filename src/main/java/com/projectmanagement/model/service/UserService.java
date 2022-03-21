package com.projectmanagement.model.service;

import java.util.List;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.dto.ProjectDto;

public interface UserService {
	public List<User> getAllUser();
	public User getUserById(Integer userId);
	public User getUserByUsername(String userName);
	public User addUser(User user);
	public User deleteUser(Integer userId);
	public List<Project> addProject(Integer userId, Project project);
	public List<Project> removeProject(Integer userId, Project project);
	public List<User> getAllocatableUser();
}
