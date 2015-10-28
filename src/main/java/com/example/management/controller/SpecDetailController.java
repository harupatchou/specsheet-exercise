package com.example.management.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.management.common.AgeEnum;
import com.example.management.common.sexEnum;
import com.example.management.domain.Spec;
import com.example.management.domain.User;
import com.example.management.page.SpecDetailDevelopmentExperiencePage;
import com.example.management.page.SpecDetailExpBreakdownPage;
import com.example.management.page.SpecDetailLicensePage;
import com.example.management.service.SpecDetailService;

/**
 * スペックシート詳細画面関連クラス.
 * @author okamoto
 */
@Controller
@Transactional
@RequestMapping(value = "/detail")
@SessionAttributes("userLogin")
public class SpecDetailController {
	@Autowired
	private SpecDetailService specDetailService;
	
	/**
	 * 詳細画面を表示する.
	 * スペックシート(スタッフID）詳細情報を取得.
	 * @return  スペックシート（スタッフID）詳細情報
	 */
	@RequestMapping
	public String detail(String staffId,Model model){
		//1件のSpec型、スペックシート情報が返ってくる
		Spec spec = specDetailService.findSpecByStaffId(staffId);
		
		//1件のUsers型、スペックシート情報が返ってくる
		User users = specDetailService.findUsersByStaffId(staffId);
		
		//↑がnullだった場合、エラー文を入れてフォワード
		if(spec == null || users == null) {
			model.addAttribute("errorMessage","検索されたスタッフIDは見つかりません");
			return "/spec/detail/specDetailError";
		}
		model.addAttribute("spec",spec);
		model.addAttribute("users",users);

		ageList(model, spec);//年齢取得
		sexList(model, users);//性別取得
		
		//IT経験取得
		SpecDetailExpBreakdownPage specDetailExpBreakdownPage = specDetailService.findExpBreakdownByStaffId(staffId);
		model.addAttribute("specDetailExpBreakdownPage",specDetailExpBreakdownPage);
		
		//資格情報取得
		List<SpecDetailLicensePage> specDetailLicensePageList = specDetailService.findLicenseByStaffId(staffId);
		model.addAttribute("specDetailLicensePageList",specDetailLicensePageList);
		
		//スキル要約欄の言語・開発関連技術・OS・業務工程の情報取得
		List<String> skillsSummary = specDetailService.findSkillsSummaryByStaffId(staffId);
		model.addAttribute("skillsSummary",skillsSummary);
		
		//開発経験欄の情報を取得
		List<SpecDetailDevelopmentExperiencePage> developmentExperience = specDetailService.findDevelopmentExperienceByStaffId(staffId);
		model.addAttribute("developmentExperience",developmentExperience);

		return "/spec/detail/specDetail";
	}
	
	

	/**
	 * 性別リストを取得.
	 * @param model
	 * @param spec
	 */
	private void sexList(Model model, User users) {
		Map<String, String> sexMap = new LinkedHashMap<String, String>();
		sexMap.put(sexEnum.MAN.getKey(), sexEnum.MAN.getValue());
		sexMap.put(sexEnum.WOMAN.getKey(), sexEnum.WOMAN.getValue());
		
		model.addAttribute("sex", sexMap.get(users.getSex()));
	}

	/**
	 * 年代リストを取得する.
	 * @param model
	 * @param spec 
	 */
	public void ageList(Model model, Spec spec) {
		Map<Integer, String> ageMap = new LinkedHashMap<Integer, String>();
		ageMap.put(AgeEnum.EARLY_TWENTIES.getKey(), AgeEnum.EARLY_TWENTIES.getValue());
		ageMap.put(AgeEnum.LATE_TWENTIES.getKey(), AgeEnum.LATE_TWENTIES.getValue());
		ageMap.put(AgeEnum.EARLY_THIRTIES.getKey(), AgeEnum.EARLY_THIRTIES.getValue());
		ageMap.put(AgeEnum.LATE_THIRTIES.getKey(), AgeEnum.LATE_THIRTIES.getValue());
		ageMap.put(AgeEnum.EARLY_FORTIES.getKey(), AgeEnum.EARLY_FORTIES.getValue());
		ageMap.put(AgeEnum.LATE_FORTIES.getKey(), AgeEnum.LATE_FORTIES.getValue());
		ageMap.put(AgeEnum.EARLY_FIFTIES.getKey(), AgeEnum.EARLY_FIFTIES.getValue());
		ageMap.put(AgeEnum.LATE_FIFTIES.getKey(), AgeEnum.LATE_FIFTIES.getValue());
		
		model.addAttribute("age", ageMap.get(spec.getAgeId()));
	}
	
}
