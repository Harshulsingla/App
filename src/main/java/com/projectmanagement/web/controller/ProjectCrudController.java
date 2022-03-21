package com.projectmanagement.web.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.dto.ProjectDto;
import com.projectmanagement.model.service.DtoUtil;
import com.projectmanagement.model.service.ProjectService;
import com.projectmanagement.model.service.UserService;

@Controller
public class ProjectCrudController {
	
	private ProjectService projectService;
	
	private UserService userService;
	
	@Autowired
	public ProjectCrudController(ProjectService projectService,UserService userService ) {
		this.projectService = projectService;
		this.userService= userService;
	}
	
	//********************** ADD ************************************
	
	@GetMapping(path="addproject")
	public ModelAndView projectGet(ModelAndView mv) {
		mv.setViewName("project");
		mv.addObject("project", new Project());
		return mv;
	}
	
	@PostMapping(path="addproject")
	public String transferPost(@ModelAttribute Project project) {
	projectService.addProject(project);
	
	return "redirect:success";
}
	
	
	//********************** Update ************************************
	
	@GetMapping(path="updateProject/{id}")
	public String updateProjectGet(ModelMap map,@PathVariable int id){
	//mv.setViewName("updateProject");
	Project project=projectService.getProjectById(id);
	ProjectDto projectDto=DtoUtil.convertToProjectDto(project);
	
	map.addAttribute("projectDto", projectDto);
	map.addAttribute("userList", userService.getAllocatableUser());
	//mv.addObject("userList", userService.getAllUser());
	System.out.println("Iam InGet");
	System.out.println(projectDto.getUsers());
	System.out.println("Iam InGet2");
	return "updateProject";
	}

	@PostMapping(path="updateProject")
	public String updateProjectPost(@ModelAttribute ProjectDto projectDto){	
		System.out.println("Iam InPost");
		System.out.println(projectDto.getUsers());
	projectService.updateProjectDetails(projectDto.getId(),projectDto);
	return "redirect:success";
	}
		
	//********************** Delete ************************************
	
	@GetMapping(path="deleteProject/{id}")
	public String deleteProjectGet(@PathVariable int id) {
	projectService.deleteProject(id); 
	return "redirect:../home";
	}
	
	//********************** Add Users ************************************
	
//	@GetMapping(path="addUserInProject/{id}")
//	public String addUserInProjectGet(@PathVariable int id) {
//	List<User> user= userService.getUserByUsername("fooFirst");
//	//User user2 = userService.getUserByUsername("fooSecond");
//	projectService.addUser(id, user);
//	//projectService.addUser(id, user2);
//	return "redirect:../success";
//	}
	
	
	
	//********************** Success ************************************
	
	@GetMapping(path="success")
	public String transferGet() {
		return "success";
	}
	
}
