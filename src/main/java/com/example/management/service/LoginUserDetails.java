package com.example.management.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.management.domain.User;

import lombok.Data;
@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User{
	private final User user;
	
	public LoginUserDetails(User user){
		super(user.getName(),user.getPassword(),AuthorityUtils.createAuthorityList("USER"));
		this.user = user;
	}

}
