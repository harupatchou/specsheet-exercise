package com.example.management.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.management.domain.Users;

import lombok.Data;
@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User{
	private final Users user;
	
	public LoginUserDetails(Users user){
		super(user.getName(),user.getPassword(),AuthorityUtils.createAuthorityList("USER"));
		this.user = user;
	}

}
