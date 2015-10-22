package com.example.management.logic;

import org.springframework.stereotype.Component;

import com.example.management.domain.Users;

@Component
public interface UserLogic {
	
	//個人情報の取得
    public Users selectByStaffId(String staffId);
    
    //スタッフID・パスワードが一致する個人情報取得
    public Users selectByStaffIdAndPassword(String staffId, String password);

}
