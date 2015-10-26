package com.example.management.logic;


import org.springframework.stereotype.Component;

import com.example.management.domain.Spec;
import com.example.management.form.SpecForm;

@Component
public interface SpecLogic {
	
	//個人情報の取得
    public Spec selectByStaffId(String staffId);
    
    //スペック情報の登録
    public void insertSpec(SpecForm form);

}
