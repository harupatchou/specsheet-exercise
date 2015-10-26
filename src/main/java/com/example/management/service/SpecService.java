package com.example.management.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.Spec;
import com.example.management.form.SpecForm;
import com.example.management.repository.SpecRegistRepository;
import com.example.management.repository.SpecRepository;

@Service
public class SpecService {
	
	@Autowired
	private SpecRepository specRepository;
	@Autowired
	private SpecRegistRepository specRegistRepository;
	
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
	public void insertSpec(SpecForm form) {
		form.setAllExp(form.getAllExpYear() * 12 + form.getAllExpMonth());
		form.setUpdateDate(new Date());
		form.setUpdateName("黒ちゃん");
		//スペック情報の登録
		specRegistRepository.insertSpec(form);
		
	}

}
