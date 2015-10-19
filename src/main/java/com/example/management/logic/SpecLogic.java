package com.example.management.logic;


import org.springframework.stereotype.Component;

import com.example.management.domain.Spec;

@Component
public interface SpecLogic {
	
	//個人情報の取得
    public Spec selectByStaffId(String staffId);

}
