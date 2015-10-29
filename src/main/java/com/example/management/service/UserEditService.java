package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.form.UserEditForm;
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
	
	/**
	 * ユーザー情報更新.
	 * @author ueno
	 */
	public void update(UserEditForm form){
		userRepository.update(form);
	}
	
	/**
	 * パスワードの初期化処理.
	 * @author okamoto
	 * @param staffId
	 * @return 指定したスタッフIDが存在するならばtrue、なければfalseを返す
	 */
	public boolean passwordInitializationCompletion (String staffId) {
		boolean bool = userRepository.passwordInitializationCompletion(staffId);
		return bool;
	}
	
	/**
	 * 退職者登録処理.
	 * @author okamoto
	 * @param staffId
	 * @return 指定したスタッフIDが存在するならばtrue、なければfalseを返す 
	 */
	public boolean retiree (String staffId) {
		boolean bool = userRepository.retiree(staffId);
		return bool;
	}
	
}
