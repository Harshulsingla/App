package com.projectmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;

import com.projectmanagement.model.dao.Project;
import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.dao.UserDao;

@SpringBootApplication
public class ProjectManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
}
