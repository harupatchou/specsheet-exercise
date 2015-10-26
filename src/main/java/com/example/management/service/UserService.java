package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.User;
import com.example.management.form.UserLoginForm;
import com.example.management.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	protected UserRepository userRepository;

	/**
	 * user情報取得
	 * @return list
	 */
	public User selectByStaffId(String staffId) {
		
		//個人の情報の取得
		User user =  userRepository.findOne(staffId);
		
		return user;
	}
	
	/**
	 * staffId・passwordと一致したユーザー情報取得.
	 * @author ueno
	 * @return ユーザー情報
	 */
	public User selectByStaffIdAndPassword(String staffId, String password){
		User user = userRepository.findByStaffIdAndPassword(staffId, password);
		return user;
	}
	
	
}
