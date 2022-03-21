package com.projectmanagement.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="user_table")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String password;
	private String profile;
	
	@ManyToMany(mappedBy = "users")
	private List<Project> projects = new ArrayList<>();
	
	
	
	public User() {
		super();
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}



	public User(String userName, String profile, String password) {
		super();
		this.userName = userName;
		this.profile = profile;
		this.password = password;
	}

	
	
	
}
