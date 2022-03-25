/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * ProjectCrudController : Controller for the Project CRUD Operations

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.service.DtoUtil;
import com.projectmanagement.model.service.ProjectService;
import com.projectmanagement.model.service.UserService;

@Controller
public class ProjectCrudController {

	private ProjectService projectService;

	private UserService userService;
	
	/**
	 * Constructor that autowires project service and user service object
	 * @param projectService
	 * @param userService
	 */
	@Autowired
	public ProjectCrudController(ProjectService projectService, UserService userService) {
		this.projectService = projectService;
		this.userService = userService;
	}

	
	/**
	 * Get mapping for viewProject URL
	 * @param map
	 * @param id
	 * @return viewProject - jsp for viewing project details
	 * 
	 */
	@GetMapping(path = "viewProject/{id}")
	public String viewProjectGet(ModelMap map, @PathVariable int id) {
		Project project = projectService.getProjectById(id);
		map.addAttribute("project", project);
		return "viewProject";
	}


	/**
	 * Get mapping for addproject URL
	 * @param mv
	 * @return mv - have list of allocatable users and takes to createProject jsp page 
	 */
	@GetMapping(path = "addproject")
	public ModelAndView projectGet(ModelAndView mv) {
		mv.setViewName("createProject");
		mv.addObject("project", new ProjectDto());
		mv.addObject("userList", userService.getAllocatableUser());
		return mv;
	}
	
	/**
	 * post mapping for addProject URL
	 * @param project
	 * @param session
	 * @return home - jsp page for home and sets our alert message in session scope
	 */
	@PostMapping(path = "addproject")
	public String transferPost(@ModelAttribute ProjectDto projectDto, HttpSession session) {
		Project project=DtoUtil.convertToProject(projectDto);
		projectService.addProject(project);
		session.setAttribute("success", project.getProjectName()+" Created");
		return "redirect:home?success="+project.getProjectName()+" Created";
	}

	
	/**
	 * get mapping for updateProject URL
	 * @param map
	 * @param id
	 * @return accessForbidden - in case when user is not authorised
	 * @return updateProject - takes to update project page
	 */
	@GetMapping(path = "updateProject/{id}")
	public String updateProjectGet(ModelMap map, @PathVariable int id) {
		Project project = projectService.getProjectById(id);
		if (project.getStatus().matches("Completed")) {
			return "accessForbidden";
		} 
		else {
			ProjectDto projectDto = DtoUtil.convertToProjectDto(project);
			map.addAttribute("projectDto", projectDto);
			map.addAttribute("userList", userService.getAllocatableUser());
			return "updateProject";
		}
	}
	
	/**
	 * post mapping for updateProject URL
	 * @param projectDto
	 * @param session
	 * @return home - jsp page for home and sets our alert message in session scope
	 */
	@PostMapping(path = "updateProject")
	public String updateProjectPost(@ModelAttribute ProjectDto projectDto, HttpSession session) {
		projectService.updateProjectDetails(projectDto);
		session.setAttribute("success", projectDto.getProjectName()+" Updated");
		return "redirect:home?success="+projectDto.getProjectName()+" Updated";
	}

	
	/**
	 * Get mapping for deleteProject URL
	 * @param id
	 * @param session
	 * @return accessForbidden - in case when user is not authorised
	 * @return home - jsp for home page
	 */
	@GetMapping(path = "deleteProject/{id}")
	public String deleteProjectGet(@PathVariable int id, HttpSession session) {
		Project project = projectService.getProjectById(id);
		if (project.getStatus().matches("In Progress") || project.getStatus().matches("Completed")) {
			return "accessForbidden";
		}
		session.setAttribute("error",project.getProjectName()+" Deleted");
		projectService.deleteProject(id);
		return "redirect:../home?error="+project.getProjectName()+" Deleted";
	}

}
