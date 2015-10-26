package com.example.management.security;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.management.domain.User;

import lombok.Data;
/**
 * 管理者用ログインロール.
 * @author ueno
 */
@Data
public class AdminUserLoginDetails extends org.springframework.security.core.userdetails.User{
	private final User user;

	public AdminUserLoginDetails(User user){
		super(user.getStaffId(), user.getPassword(),AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
		this.user = user;
	}
}
