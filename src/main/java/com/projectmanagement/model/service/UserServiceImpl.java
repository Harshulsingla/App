/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * UserServiceImpl : Class that implements the UserService Interface and have the definition of all business methods. 

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.dao.UserDao;
import com.projectmanagement.model.exception.ProjectUserNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	/**
	 * Constructor that autowires Dao object in Service Object
	 * @param projectDao
	 */
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * returns list of all users
	 */
	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}
	
	/**
	 * returns project having given Id
	 *@param userId
	 *@return User
	 *@throws ProjectUserNotFoundException
	 */ 
	@Override
	public User getUserById(Integer userId) {
		return userDao.findById(userId).orElseThrow(()-> new ProjectUserNotFoundException("User Not Found"));
	}
	
	/**
	 * returns list of project having name same as the given name
	 * @param userName
	 * @return User
	 * 
	 */
	@Override
	public User getUserByUsername(String userName) {
		return userDao.findByUserName(userName);
	}
	
	/**
	 * returns all the users that can be allocated to projects. 
	 * @return List<User>
	 */
	@Override
	public List<User> getAllocatableUser() {
		return userDao.findByProfile("ROLE_USER");
	}

}
