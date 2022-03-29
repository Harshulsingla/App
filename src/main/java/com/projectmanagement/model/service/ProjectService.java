/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * ProjectService : Interface that performs the business logic for project class.

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.service;

import java.util.List;
import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dto.ProjectDto;

public interface ProjectService {
	public List<Project> getAllProject();
	public Project getProjectById(Integer projectId);
	public List<Project> getProjectByName(String projectName);
	public List<Project> getProjectByClientName(String clientName);
	public Project addProject(Project project);
	public Project updateProjectDetails(ProjectDto projectDto);
	public Project deleteProject(Integer projectId);
	public List<Project> getProjectByStatus(String status);
}