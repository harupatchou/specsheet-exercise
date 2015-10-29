package com.example.management.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.LanguageExp;
import com.example.management.domain.OsExp;
import com.example.management.form.SpecForm;
import com.example.management.form.SpecRegistLicenseForm;
import com.example.management.logic.SpecLogic;
import com.example.management.page.SpecDetailLicensePage;
import com.example.management.page.SpecEditSkillsSummaryChildPage;
import com.example.management.page.SpecEditSkillsSummaryPage;
import com.example.management.repository.LanguageSearchRepository;
import com.example.management.repository.OsSearchRepository;
import com.example.management.repository.SpecDetailRepository;
import com.example.management.repository.SpecRegistRepository;
import com.example.management.repository.SpecRepository;

/**
 * スペックシート登録・編集を行うサービス.
 * @author okamoto
 *
 */
@Service
public class SpecRegistService {
	@Autowired
	private SpecLogic specLogic;
	@Autowired
	private SpecRegistRepository specRegistRepository;
	@Autowired
	private SpecDetailRepository specDetailRepository;
	@Autowired
	private LanguageSearchRepository languageSearchRepository;
	@Autowired
	private OsSearchRepository osSearchRepository;
	@Autowired
	private SpecRepository specRepository;
	
	
	/**
	 * 所有している資格情報を取得.
	 * @param staffId
	 * @author okamoto
	 * @return 所有している資格情報
	 */
	public List<SpecDetailLicensePage> licensefindByStaffId(String staffId){
		List<SpecDetailLicensePage> page = specRegistRepository.licensefindByStaffId(staffId);
		return page;
	}
	
	
	/**
	 * スペックシート編集画面初期表示用.
	 * スキル要約欄要素取得.
	 * @author ueno
	 * @return スキル要約欄要素
	 */
	public List<SpecEditSkillsSummaryPage> setSkillsSummary(String staffId){
		SpecEditSkillsSummaryChildPage skillsSummaryChild = new SpecEditSkillsSummaryChildPage();
		//開発関連技術
		skillsSummaryChild.setRelatedTech(specRepository.findOne(staffId).getRelatedTech());
		//言語経験
		skillsSummaryChild.setLangList(specDetailRepository.findLanguageByStaffId(staffId));
		
		//OS経験
		skillsSummaryChild.setOsList(specDetailRepository.findOsByStaffId(staffId));
		
		//実務フラグ・言語実務経験月数
		List<LanguageExp> langExp = languageSearchRepository.findByStaffId(staffId);
		List<Integer> expFlagList = new ArrayList<>();
		List<Integer> monthOfLangExpList = new ArrayList<>();
		for(LanguageExp lang : langExp){
			expFlagList.add(lang.getExpFlag());
			monthOfLangExpList.add(lang.getMonthOfExp());
		}
		skillsSummaryChild.setExpFlagList(expFlagList);
		skillsSummaryChild.setMonthOfLangExpList(monthOfLangExpList);
		
		//OS経験月数
		List<OsExp> osExp = osSearchRepository.findByStaffId(staffId);
		List<Integer> monthOfOsExpList = new ArrayList<>();
		for(OsExp os : osExp){
			monthOfOsExpList.add(os.getMonthOfExp());
		}
		skillsSummaryChild.setMonthOfOsExpList(monthOfOsExpList);
		
		//SpecEditSkillsSummaryChildPageのリスト要素内の中で最大の長さを取得
		int elementMaxLength = specLogic.maxLength(skillsSummaryChild);
		
		//スキル要約欄表示要素リスト格納用
		List<SpecEditSkillsSummaryPage> skillsSummary = new ArrayList<>(); 
		for(int i = 0; i < elementMaxLength; i++){
			SpecEditSkillsSummaryPage summaryPage = new SpecEditSkillsSummaryPage();
			if(i == 0){
				summaryPage.setRelatedTech(skillsSummaryChild.getRelatedTech());
			}
			summaryPage.setLanguage(skillsSummaryChild.getLangList().get(i));
			summaryPage.setOs(skillsSummaryChild.getOsList().get(i));
			summaryPage.setExpFlag(skillsSummaryChild.getExpFlagList().get(i));
			summaryPage.setMonthOfLangExp(skillsSummaryChild.getMonthOfLangExpList().get(i));
			summaryPage.setMonthOfOsExp(skillsSummaryChild.getMonthOfOsExpList().get(i));
			skillsSummary.add(summaryPage);
		}
		return skillsSummary;
	}
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
		specRegistRepository.insertLanguage(form);
		specRegistRepository.insertOs(form);
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'/'MM'/'dd");//指定の型にフォーマット
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
