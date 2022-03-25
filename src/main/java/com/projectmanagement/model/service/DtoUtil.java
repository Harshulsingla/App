/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * DtoUtil : Converts ProjectDto object to ProjectDao object and vise versa

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.service;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dto.ProjectDto;

public class DtoUtil {
	
	
 /**
  * Private Constructor as this class contains only static members.
  */
 private DtoUtil() {
		super();
	}

/**
  * Converts Project to Project Dto
  * @param project
  * @return ProjectDto
  */
 public static ProjectDto convertToProjectDto(Project project) {
		ProjectDto projectDto=new ProjectDto();
		projectDto.setId(project.getProjectId());
		projectDto.setProjectName(project.getProjectName());
		projectDto.setClientName(project.getClientName());
		projectDto.setStartDate(project.getStartDate());
		projectDto.setEndDate(project.getEndDate());
		projectDto.setStatus(project.getStatus());
		projectDto.setUsers(project.getUsers());
		return projectDto;
 }
 
 /**
  * Converts Project to Project Dto
  * @param projectDto
  * @return
  */
 public static Project convertToProject(ProjectDto projectDto) {
	    Project project=new Project();
	    project.setProjectId(projectDto.getId());
		project.setProjectName(projectDto.getProjectName());
		project.setClientName(projectDto.getClientName());
		project.setStartDate(projectDto.getStartDate());
		project.setEndDate(projectDto.getEndDate());
		project.setStatus(projectDto.getStatus());
		project.setUsers(projectDto.getUsers());
	    return project;
 }	
 
}
