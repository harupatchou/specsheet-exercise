package com.example.management.logicImpl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import com.example.management.domain.Spec;
import com.example.management.form.SpecForm;
import com.example.management.logic.SpecLogic;
import com.example.management.page.SpecEditSkillsSummaryChildPage;
import com.example.management.page.SpecRegistConfirmChildPage;
import com.example.management.repository.LanguageSearchRepository;
import com.example.management.repository.OsSearchRepository;
import com.example.management.security.AdminUserLoginDetails;
import com.example.management.security.UserLoginDetails;
import com.example.management.service.SpecService;

@Component
public class SpecLogicImpl implements SpecLogic{
	
	@Autowired
	private SpecService specService;
	@Autowired
	private LanguageSearchRepository languageSearchRepository;
	@Autowired
	private OsSearchRepository osSearchRepository;

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
	
	//SpecEditSkillsSummaryChildPageのリスト要素で最大のサイズを取得
	@Override
	public Integer maxLength(SpecEditSkillsSummaryChildPage skillsSummary){
		//リスト要素の長さを取得してリストに格納
		List<Integer> maxNumber = new ArrayList<>();
		maxNumber.add(skillsSummary.getLangList().size());
		maxNumber.add(skillsSummary.getOsList().size());
		maxNumber.add(skillsSummary.getExpFlagList().size());
		maxNumber.add(skillsSummary.getMonthOfLangExpList().size());
		maxNumber.add(skillsSummary.getMonthOfOsExpList().size());
		//昇順に並び替え
		Collections.sort(maxNumber);
		//降順に並び替え
		Collections.reverse(maxNumber);
		//最大数値取得
		int maxListSize = maxNumber.get(0);
		return maxListSize;
	}
	
    //SpecRegistConfirmChildPageの要素から最長のリストの長さを取得
	@Override
    public Integer maxRegistLength(SpecRegistConfirmChildPage registConfirm){
		//リスト要素の長さを取得してリストに格納
    	List<Integer> maxNumber = new ArrayList<>();
    	maxNumber.add(registConfirm.getLangList().size());
    	maxNumber.add(registConfirm.getOsList().size());
    	maxNumber.add(registConfirm.getRelatedTech().size());
		//昇順に並び替え
		Collections.sort(maxNumber);
		//降順に並び替え
		Collections.reverse(maxNumber);
		//最大数値取得
		int maxListSize = maxNumber.get(0);
		return maxListSize;
    }
	
    //スペックシート登録確認画面用スキル要約欄表示要素
	@Override
    public List<String> setRegistConfirmSkillsSummary(SpecForm form){
		//経験言語を,区切りでリストに格納
		List<String> completeLangList = new ArrayList<>();
		String tempLang = form.getSkillLangList();
		String[] langList = tempLang.split("\\,");
		for (String lang : langList) {
			//言語名取得
			String langName = languageSearchRepository.findbyId(Integer.parseInt(lang));
			completeLangList.add(langName);
		}
		
		//経験OSを,区切りでリストに格納
		List<String> completeOsList = new ArrayList<>();
		String tempOs = form.getSkillOsList();
		String[] osList = tempOs.split("\\,");
		for (String os : osList) {
			//OS名取得
			String osName = osSearchRepository.findbyId(Integer.parseInt(os));
			completeOsList.add(osName);
		}
		
		//開発関連技術を,区切りでリストに格納
		List<String> completeTechList = new ArrayList<>();
		String tempTech = form.getRelatedTech();
		String[] techList = tempTech.split("\\,");
		for(String tech : techList){
			completeTechList.add(tech);
		}
		
		//工程を,区切りでリストに格納
		List<String> completeProcessList = new ArrayList<>();
		String tempProcess = form.getProcess();
		String[] processList = tempProcess.split("\\,");
		for(String process : processList){
			completeProcessList.add(process);
		}
		
		//言語・OS・開発関連技術リストをSpecRegistConfirmChildPageに格納
		SpecRegistConfirmChildPage registConfirmChildPage = new SpecRegistConfirmChildPage();
		registConfirmChildPage.setLangList(completeLangList);
		registConfirmChildPage.setOsList(completeOsList);
		registConfirmChildPage.setRelatedTech(completeTechList);
		registConfirmChildPage.setProcessList(completeProcessList);
		
		//SpecRegistConfirmChildPageのリスト要素内の中で最大の長さを取得
		int elementMaxLength = maxRegistLength(registConfirmChildPage);
		
		//スキル要約欄表示要素リスト格納用
		List<String> SkillsSummary = new ArrayList<>();
		for(int i = 0; i < elementMaxLength; i += 2){
			
			//言語を2個ずつ格納
			for(int lang = i;lang < i + 2;lang++){
				
				if(registConfirmChildPage.getLangList().size() > lang){
					SkillsSummary.add(registConfirmChildPage.getLangList().get(lang));
				}else{
					SkillsSummary.add(null);
				}
//				if(lang == elementMaxLength-1){
//					break;
//				}
			}
			//開発関連技術を2個ずつ格納
			for(int tech = i;tech < i + 2;tech++){
				if(registConfirmChildPage.getRelatedTech().size() > tech){
					SkillsSummary.add(registConfirmChildPage.getRelatedTech().get(tech));
				}else{
					SkillsSummary.add(null);
				}
//				if(tech == elementMaxLength-1){
//					break;
//				}
			}
			//OSを２個ずつ格納
			for(int os = i;os < i + 2;os++){
				if(registConfirmChildPage.getOsList().size() > os){
					SkillsSummary.add(registConfirmChildPage.getOsList().get(os));
				}else{
					SkillsSummary.add(null);
				}
//				if(os == elementMaxLength-1){
//					break;
//				}
			}
			//工程を２個ずつ格納
			for(int process = i;process < i + 2;process++){
				if(registConfirmChildPage.getProcessList().size() > process){
					SkillsSummary.add(registConfirmChildPage.getProcessList().get(process));
				}else{
					SkillsSummary.add(null);					
				}
//				if(process == elementMaxLength-1){
//					break;
//				}
			}
		}
		return SkillsSummary;
	}
}
