package com.example.management.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.management.domain.Spec;
import com.example.management.domain.User;
import com.example.management.form.SpecForm;
import com.example.management.logic.UserLogic;
import com.example.management.repository.SpecRegistRepository;
import com.example.management.repository.SpecRepository;
import com.example.management.security.AdminUserLoginDetails;
import com.example.management.security.UserLoginDetails;

@Service
public class SpecService {
	
	@Autowired
	private SpecRepository specRepository;
	@Autowired
	private SpecRegistRepository specRegistRepository;
	@Autowired
	private UserLogic userLogic;
	
	/**
	 * spec情報取得
	 * @return list
	 */
	public Spec selectByStaffId(String staffId) {
		
		//個人の情報の取得
		Spec spec =  specRepository.findOne(staffId);
		
		return spec;
	}
	
	/**
	 * spec情報登録
	 * @param form　スペック情報登録フォーム
	 */
	public void insertSpec(SpecForm form, 
			@AuthenticationPrincipal UserLoginDetails user, 
			@AuthenticationPrincipal AdminUserLoginDetails admin) {
		form.setAllExp(form.getAllExpYear() * 12 + form.getAllExpMonth());
		form.setUpdateDate(new Date());
		if (user != null) {
			User u = userLogic.selectByStaffId(user.getUsername());
			form.setUpdateName(u.getFirstName() + u.getLastName());
		} else {
			User u = userLogic.selectByStaffId(admin.getUsername());
			form.setUpdateName(u.getFirstName() + u.getLastName());
		}
		//スペック情報の登録
		specRegistRepository.insertSpec(form);
		
	}

}
