package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.form.SpecRegistLicenseForm;
import com.example.management.repository.SpecRegistRepository;

/**
 * スペックシート登録を行うサービス.
 * @author okamoto
 *
 */
@Service
public class SpecRegistService {

	@Autowired
	private SpecRegistRepository specRegistRepository;
	
	
	/**
	 * スペックシート登録（資格）
	 * @author okamoto
	 * @param form
	 */
	public void insertUsersLicenseByStaffId(SpecRegistLicenseForm form){
		specRegistRepository.insertUsersLicenseByStaffId(form);
	}
	
}
