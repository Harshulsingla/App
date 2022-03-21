package com.projectmanagement.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.service.ProjectService;
import com.projectmanagement.model.service.UserService;

@Controller
public class UserCrud {
	
private UserService userService;

private ProjectService projectService;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserCrud(UserService userService, ProjectService projectService) {
		this.userService = userService;
		this.projectService = projectService;
	}
	
	
	
	//********************************** Add User *****************************
	
    @GetMapping(path="addUser")
    public String userGet(ModelAndView mv) {
//    	User user=new User("fooFirst", "ROLE_ADMIN", bCryptPasswordEncoder.encode("first"));
//    	User user2=new User("fooSecond", "ROLE_ADMIN", bCryptPasswordEncoder.encode("second"));
//    	User user3=new User("fooThird", "ROLE_USER", bCryptPasswordEncoder.encode("third"));
//    	User user4=new User("fooFourth", "ROLE_USER", bCryptPasswordEncoder.encode("forth"));
    	User user5=new User("fooFifth", "ROLE_USER", bCryptPasswordEncoder.encode("fifth"));
    	User user6=new User("fooSixth", "ROLE_USER", bCryptPasswordEncoder.encode("sixth"));
    	//userService.addUser(user);
    	//userService.addUser(user2);
    	//userService.addUser(user3);
    	//userService.addUser(user4);
    	userService.addUser(user5);
    	userService.addUser(user6);
    	return "redirect:success";
    
    }  
//********************************** Add Project *****************************
	

	@GetMapping(path="addProjectInUser/{id}")
	public String addUserInProjectGet(@PathVariable int id) {
	//Project project = projectService.getProjectById(2);
	//Project project2 = projectService.getProjectById(3);
	//userService.addProject(id, project);
	//userService.addProject(id, project2);
	return "redirect:../home";
	}
    
	
	
	
}
