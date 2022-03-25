package com.projectmanagement.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.service.ProjectService;

@Controller
public class searchController {
	private ProjectService projectService;

	@Autowired
	public searchController(ProjectService projectService) {
	    this.projectService = projectService;
	}
	
	
	@GetMapping("searchproject")
	public ModelAndView searchProjectGet(ModelAndView modelview, @RequestParam(name="projectname") String projectname) {
		modelview.addObject("resultProjects", projectService.getProjectByName(projectname));
		modelview.setViewName("searchProject");
		System.out.println(projectService.getProjectByName(projectname));
		return modelview;
	}
	

	
}
