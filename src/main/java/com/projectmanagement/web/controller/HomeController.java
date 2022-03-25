/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * HomeController : Controller for the Home Page URL

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.service.ProjectService;
import com.projectmanagement.model.service.UserService;

@Controller
public class HomeController {
	
	private UserService userService;
	private ProjectService projectService;
	
	/**
	 * Constructor that autowires project service and user service object
	 * @param projectService
	 * @param userService
	 */
	@Autowired
	public HomeController(ProjectService projectService,UserService userService) {
		 this.projectService = projectService;
	     this.userService = userService;
	}
	
	/**
	 * Get mapping for home URL
	 * @param map
	 * @param principal
	 * @return home - jsp for home page
	 */
	@GetMapping("home")
	public String home(ModelMap map, Principal principal) {
		User user=userService.getUserByUsername(principal.getName());
		map.addAttribute("project", projectService.getAllProject());
		map.addAttribute("user", user);
		return "home";
	}
}
