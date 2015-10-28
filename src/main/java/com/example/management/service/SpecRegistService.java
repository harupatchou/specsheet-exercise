package com.example.management.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.form.SpecForm;
import com.example.management.form.SpecRegistLicenseForm;
import com.example.management.repository.SpecRegistRepository;
import com.example.management.repository.UserRepository;

/**
 * スペックシート登録を行うサービス.
 * @author okamoto
 *
 */
@Service
public class SpecRegistService {
	@Autowired
	SpecRegistRepository specRegistRepository;
	@Autowired
	UserRepository userRepository;
	
//	/**
//	 * スペックシート登録画面に初期表示するための情報を取得する.
//	 * @author okamoto
//	 * @return
//	 */
//	public Users test(String staffId){
//		Users user = userRepository.findOne(staffId);
//		return user;
//	}
	
	/**
	 * 経験内訳の登録
	 * @param form
	 */
	public void insertBreakdown(SpecForm form) {
		specRegistRepository.insertBreakdown(form);
	}
	
	/**
	 * スキル要約の登録
	 * @param form
	 */
	public void insertSkill(SpecForm form) {
		specRegistRepository.insertSkill(form);
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
	public void insertUsersLicenseByStaffId(SpecForm form,String staffId){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd");//指定の型にフォーマット
		ArrayList<String> strAcquireDateList = (ArrayList<String>) form.getStrAcquireDate();//(2015-05-05,2015-06-06,*****)
		ArrayList<String> lisenceNameList = (ArrayList<String>) form.getLisenceName();
		
		//空文字をリストから削除
		strAcquireDateList.removeAll(Collections.singleton("")); 
		lisenceNameList.removeAll(Collections.singleton(""));
		
		String lisenceName = null;
		String strAcquireDate;
		Date acquireDate = null;
		for(int i = 0 ; i < strAcquireDateList.size() ; i++){
			
			SpecRegistLicenseForm specRegistLicenseForm = new SpecRegistLicenseForm();
			
			try {
				lisenceName = lisenceNameList.get(i);
				
				strAcquireDate = strAcquireDateList.get(i);//n番目のDateをStringにいったんいれる
				acquireDate = sdf.parse(strAcquireDate);//Date型に変換する
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if( lisenceName != null || acquireDate != null ){
				System.out.println("lisenceNameまたはacquireDateがｎｕｌｌではなかった時の処理");
			specRegistLicenseForm.setStaffId(staffId);
			specRegistLicenseForm.setLisenceName(lisenceName);
			specRegistLicenseForm.setAcquireDate(acquireDate);
			
			specRegistRepository.insertUsersLicenseByStaffId(specRegistLicenseForm);
			}
		}
	}
	
}
