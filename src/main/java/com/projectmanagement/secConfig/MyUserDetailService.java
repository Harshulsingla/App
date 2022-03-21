package com.projectmanagement.secConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectmanagement.model.dao.User;
import com.projectmanagement.model.service.UserService;

@Service
public class MyUserDetailService implements UserDetailsService {

	private  UserService userService;
	
	@Autowired
	public MyUserDetailService(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.getUserByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("user not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), AuthorityUtils.createAuthorityList(user.getProfile()));
	}
}
