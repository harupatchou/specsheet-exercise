package com.example.management.security;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.management.domain.User;

import lombok.Data;
/**
 * 一般ユーザー用ログインロール.
 * @author ueno
 */
@Data
public class UserLoginDetails extends org.springframework.security.core.userdetails.User{
	private final User user;
	
	public UserLoginDetails(User user){
		super(user.getStaffId(),user.getPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}

}
