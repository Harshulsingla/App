/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * UserDao : Interface to access the User Table

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	/**
	 * returns the user having name same as the given name. 
	 * @param userName - name of the user
	 * @return User - Object of User class 
	 */
	public User findByUserName(String userName);
	
	/**
	 * retrives all the users having profile as passed in argument
	 * @param profile - User profile
	 * @return List<User> - List of Users 
	 */
	public List<User> findByProfile(String profile);
}
