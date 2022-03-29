/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * SearchController : Controller for the Search Project Operations

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.service.ProjectService;
import com.projectmanagement.model.service.UserService;

@Controller
public class SearchController {
	private ProjectService projectService;
	private UserService userService;
	
	/**
	 * Constructor that autowires project service and user service object
	 * @param projectService
	 * @param userService
	 */
	@Autowired
	public SearchController(ProjectService projectService, UserService userService) {
	    this.projectService = projectService;
	    this.userService=userService;
	}
	
	/**
	 * Get mapping for searchproject URL
	 * @param map
	 * @param searchitem
	 * @param principal
	 * @return home - takes to home page
	 */
	@GetMapping("searchproject")
	public String searchProjectGet(ModelMap map, @RequestParam(name="searchitem") String searchitem, Principal principal, HttpSession session) {
		User user=userService.getUserByUsername(principal.getName());
		List<Project> projectByName =projectService.getProjectByName(searchitem);
		List<Project> projectByClient =projectService.getProjectByClientName(searchitem);
		List<Project>project=new ArrayList<>();
		project.addAll(projectByName);
		project.addAll(projectByClient);
		if(project.isEmpty()) {
			session.setAttribute("error", "No Record Found with this Name");
			return "redirect:home?error=No Record Found with this Name";
		}
		else {
		map.addAttribute("project",project );
		map.addAttribute("user", user);
		return "home";
		}
	}
	
}
