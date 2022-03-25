/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * AppUserDetailService : Class that implements the UserDetailsService Interface, converts our user to other form which is 
 *                        understandable by Spring Security

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.service.UserService;

@Service
public class AppUserDetailService implements UserDetailsService {

	private  UserService userService;
	
	/**
	 * Constructor that Autowires object of userService 
	 * @param userService
	 */
	@Autowired
	public AppUserDetailService(UserService userService) {
		super();
		this.userService = userService;
	}
	
	/**
	 * converts our user to other form which is understandable by Spring Security
	 * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username){
		User user=userService.getUserByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("user not found");
		}
		return new org.springframework.security.core.userdetails
				   .User(user.getUserName(),user.getPassword(), AuthorityUtils
				   .createAuthorityList(user.getProfile()));
	}
}
