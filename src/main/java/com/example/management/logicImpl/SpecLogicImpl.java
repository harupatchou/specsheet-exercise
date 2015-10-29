package com.example.management.logicImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import com.example.management.domain.Spec;
import com.example.management.form.SpecForm;
import com.example.management.logic.SpecLogic;
import com.example.management.security.AdminUserLoginDetails;
import com.example.management.security.UserLoginDetails;
import com.example.management.service.SpecService;

@Component
public class SpecLogicImpl implements SpecLogic{
	
	@Autowired
	private SpecService specService;

	//個人の情報の取得
	@Override
	public Spec selectByStaffId(String staffId) {
		Spec spec = specService.selectByStaffId(staffId);
		return spec;
	}
	
	//スペック情報の登録
	@Override
	public void insertSpec(SpecForm form, 
			@AuthenticationPrincipal UserLoginDetails user, 
			@AuthenticationPrincipal AdminUserLoginDetails admin) {
		specService.insertSpec(form, user, admin);
	}
	

}
