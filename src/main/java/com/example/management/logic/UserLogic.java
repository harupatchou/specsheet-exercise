package com.example.management.logic;

import org.springframework.stereotype.Component;

import com.example.management.domain.Users;

@Component
public interface UserLogic {
	
	//個人情報の取得
    public Users selectByStaffId(String staffId);

}
