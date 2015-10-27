package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.form.SpecForm;
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
	SpecRegistRepository specRegistRepository;
	
	/**
	 * 経験内訳の登録
	 * @param form
	 */
	public void insertBreakdown(SpecForm form) {
		specRegistRepository.insertBreakdown(form);
	}
	
	/**
	 * プロジェクトOSの登録
	 * @param form
	 */
	public void insertProjectOs(SpecForm form) {
		specRegistRepository.insertProjectOs(form);
	}
	
	/**
	 * プロジェクト言語の登録
	 * @param form
	 */
	public void insertProjectLanguage(SpecForm form) {
		specRegistRepository.insertProjectLanguage(form);
	}
	
	/**
	 * プロジェクト工程の登録
	 * @param form
	 */
	public void insertProjectProcess(SpecForm form) {
		specRegistRepository.insertProjectProcess(form);
	}
	

	
	
	/**
	 * スペックシート登録（資格）
	 * @author okamoto
	 * @param form
	 */
	public void insertUsersLicenseByStaffId(SpecRegistLicenseForm form){
		specRegistRepository.insertUsersLicenseByStaffId(form);
	}
	
}
