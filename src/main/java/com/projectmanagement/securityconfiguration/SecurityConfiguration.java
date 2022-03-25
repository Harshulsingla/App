/**

 * Project Name : Project Management Application 

 * @company YMSLI

 * @author  Harshul Singla

 * @date    March 16,2022

 * Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.

 * 

 * Description

 * ----------------------------------------------------------------------------------- 

 * SecurityConfiguration : Class that extends WebSecurityConfigurerAdapter, authenticates and authorises the user to go on specific URL

 * -----------------------------------------------------------------------------------

 */
package com.projectmanagement.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static final String ADMIN="ADMIN";
	
	/**
	 * tells spring security, how to verify the user.
	 */
	@Autowired
	private UserDetailsService userDetailService; 
	
	/**
	 * authenticates the user that weather they could log into the application or not
	 * @param AuthenticationManagerBuilder
	 * @throws Exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/**
	 * authorises the user that weather they could go to a specific url or not, handles the logout  
	 * @param HttpSecurity
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/home").hasAnyRole(ADMIN, "USER")
		.antMatchers("/addproject").hasAnyRole(ADMIN)
		.antMatchers("/deleteProject/*").hasAnyRole(ADMIN)
		.antMatchers("/updateProject/*").hasAnyRole(ADMIN)
		.and().formLogin()
		.loginPage("/login").loginProcessingUrl("/applogin")
		.usernameParameter("cName").passwordParameter("cPass")
		.defaultSuccessUrl("/home")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		.and().sessionManagement().maximumSessions(1);
		
		http
		.logout(logout -> logout
		.logoutUrl("/logout")
		.permitAll()
		.addLogoutHandler(new SecurityContextLogoutHandler())
		);
	}
	
	/**
	 * helps in encrypting user's password before storing in Database
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
