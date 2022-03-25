/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * LoginController : Controller for the Login Page URL

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	/**
	 * Get mapping for Login URL
	 * @return login - jsp page for login
	 */
	@GetMapping(path="login")
	public String appLogin() {
		return "login";
	}
	
	/**
	 * Get mapping for Log Out URL
	 * @return login - jsp page for Login
	 */
	@GetMapping("/logout")
	public String logout()
	{
	return "login";
	}
	
	/**
	 * 
	 * @param principal
	 * @param mv
	 * @return accessForbidden - jsp page for accessForbidden error
	 */
	@GetMapping(path="accessdenied")
	public ModelAndView accessdenied(Principal principal, ModelAndView mv) {
		mv.addObject("username", principal.getName());
		mv.setViewName("accessForbidden");
		return mv;
	}
}
