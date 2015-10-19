package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.Users;
import com.example.management.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	protected UserRepository userRepository;

	/**
	 * user情報取得
	 * @return list
	 */
	public Users selectByStaffId(String staffId) {
		
		//個人の情報の取得
		Users user =  userRepository.findOne(staffId);
		
		return user;
	}
	
	
}
