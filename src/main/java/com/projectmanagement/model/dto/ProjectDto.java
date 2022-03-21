package com.projectmanagement.model.dto;

import java.util.Date;
import java.util.List;

import com.projectmanagement.model.dao.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
	private Integer id;
	private String projectName;
	private String clientName;
	private Date startDate=null;
	private Date endDate=null;
	private String status;
	private List<User> users;
	
}
