/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * UserService : Interface that performs the business logic for user class.

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.service;

import java.util.List;

import com.projectmanagement.model.dao.User;

public interface UserService {
	public List<User> getAllUser();
	public User getUserById(Integer userId);
	public User getUserByUsername(String userName);
	public List<User> getAllocatableUser();
}
