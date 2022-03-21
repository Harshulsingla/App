package com.projectmanagement.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	public User findByUserName(String userName);
	public List<User> findByProfile(String profile);
}
