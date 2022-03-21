package com.projectmanagement.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name="project_table")
public class Project {
	
//	@Autowired
//	private UserDao userDao;
//	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	private String projectName;
	
	private Date startDate=null;
	private Date endDate=null;
	private String status;
	private String clientName;
	

	@ManyToMany
	@JoinTable(name="project_user", 
	joinColumns = @JoinColumn(name="pid_fk"),
	inverseJoinColumns =@JoinColumn(name="uid_fk"))
	private List<User> users = new ArrayList<User>();

	
	
	public Project() {
		super();
	}



	public Project(String projectName, Date startDate, Date endDate, String status, String clientName,
			List<User> users) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.clientName = clientName;
		this.users = users;
	}



	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", status=" + status + ", clientName=" + clientName + ", users=" + users
				+ "]";
	}
	
	

	

	
	
	
	
}
