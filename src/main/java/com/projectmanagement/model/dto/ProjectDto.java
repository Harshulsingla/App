/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * ProjectDto : DTO for Project

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.model.dto;

import java.sql.Date;
import java.util.List;

import com.projectmanagement.model.dao.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
	
	/**
	 * Fields
	 */
	private Integer id;
	private String projectName;
	private String clientName;
	private Date startDate;
	private Date endDate;
	private String status;
	private List<User> users;
	
}
