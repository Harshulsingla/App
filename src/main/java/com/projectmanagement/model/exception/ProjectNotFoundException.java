/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * ProjectNotFoundException : ProjectNotFoundException shows error message on Console if any project is not there in database

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.exception;

public class ProjectNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ProjectNotFoundException(String message) {
		super(message);
	}
}
