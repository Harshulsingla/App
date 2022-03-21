package com.projectmanagement.model.service;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dto.ProjectDto;

public class DtoUtil {
	
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
