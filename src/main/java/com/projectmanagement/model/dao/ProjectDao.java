/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * ProjectDao : Interface to access the Project Table

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {
	/**
	 * retrives list of projects having name same as the given projectName
	 * @param projectName - Name of the project 
	 * @return List<Project> - List of the projects
	 */
	public List<Project> findByProjectNameContainingIgnoreCase(String projectName);
	
	/**
	 * retrives list of projects having client name same as the given
	 * @param clientName
	 * @return List<Project> - List of the projects
	 */
	public List<Project> findByClientNameContainingIgnoreCase(String clientName);
	
	
	/**
	 * retrives list of projects having status same as the given
	 * @param status
	 * @return
	 */
	public List<Project> findByStatusContainingIgnoreCase(String status);
}
