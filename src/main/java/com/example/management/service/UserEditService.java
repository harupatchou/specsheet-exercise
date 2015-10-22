package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.form.UserRegistForm;
import com.example.management.repository.UserRepository;

/**
 * ユーザー新規登録サービスクラス.
 * @author ueno
 */
@Service
public class UserEditService {
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * ユーザー新規登録.
	 * スタッフIDと一致するものがなければ登録、該当ユーザーがいればnullを返す
	 * @author ueno
	 * @return
	 */
	public void insert(UserRegistForm form){
		//ユーザー情報登録
		userRepository.insert(form);
	}
}
