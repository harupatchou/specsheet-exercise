package com.example.management.logicImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.management.domain.Users;
import com.example.management.logic.UserLogic;
import com.example.management.service.UserService;

@Component
public class UserLogicImpl implements UserLogic{
	
	@Autowired
	private UserService userService;

	//個人の情報の取得
	@Override
	public Users selectByStaffId(String staffId) {
		Users user = userService.selectByStaffId(staffId);
		return user;
	}
	
	 //スタッフID・パスワードが一致する個人情報取得
	@Override
    public Users selectByStaffIdAndPassword(String staffId, String password){
		Users user = userService.selectByStaffIdAndPassword(staffId, password);
		return user;
	}

}
