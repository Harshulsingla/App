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
	
	@Autowired
	public HomeController(ProjectService projectService,UserService userService) {
		 this.projectService = projectService;
	    this.userService = userService;
	}
	
	
	
	
	@GetMapping("home")
	public String home(ModelMap map, Principal principal) {
	System.out.println("Mei yha aa gyaa ");
	User user=userService.getUserByUsername(principal.getName());
	map.addAttribute("project", projectService.getAllProject());
	map.addAttribute("user", user);
	return "home";
	}

}
