//package com.example.management.controller;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
///**
// * スペック関連Controller
// * @author takayuki.honma
// *
// */
//@Controller
//@RequestMapping(value="search")
//@SessionAttributes("userLogin")
//public class SpecSearchController {
//	@Autowired
//	private SpecSearchService specSearchService;
//	@Autowired
//	private LanguageDefineService languageDefineService;
//
//	
//	@ModelAttribute
//	public SpecSearchForm setUpForm(){
//		return new SpecSearchForm();
//	}
//	
//	/**
//	 * スペックシート検索初期画面.
//	 * @param model
//	 * @return 検索画面
//	 */
//	@RequestMapping
//	public String search(Model model){
//		List<LanguageDefine> languageList = languageDefineService.findAll();
//		model.addAttribute("languageList", languageList);
//		
//		stateList(model);
//		
//		ageList(model);
//		
//		return "specSearch";
//	}
//
//	/**
//	 * 条件に一致したユーザ情報を取得.
//	 * @param form
//	 * @param model
//	 * @return　一致したユーザ情報
//	 */
//	@RequestMapping(value="user")
//	public String serchUser(SpecSearchForm form,BindingResult result, Model model){
//		model.addAttribute("searchData",form);
//		List<SpecSearchChildPage> specList = specSearchService.findAll(form);
//		model.addAttribute("specList", specList);
//		return search(model);
//	}
//	
//	/**
//	 * 状態フラグリスト.
//	 * @param model
//	 */
//	public void stateList(Model model) {
//		Map<Integer, String> stateMap = new LinkedHashMap<Integer, String>();
//		stateMap.put(null, "---");
//		stateMap.put(StateEnum.WAITING.getKey(), StateEnum.WAITING.getValue());
//		stateMap.put(StateEnum.SITE.getKey(), StateEnum.SITE.getValue());
//		stateMap.put(StateEnum.RETIREMENT.getKey() , StateEnum.RETIREMENT.getValue());
//		model.addAttribute("stateMap", stateMap);
//	}
//	
//	/**
//	 * 年代を取得する.
//	 * 
//	 * @param model
//	 */
//	public void ageList(Model model) {
//		Map<Integer, String> ageMap = new LinkedHashMap<Integer, String>();
//		ageMap.put(null, "---");
//		ageMap.put(AgeEnum.EARLY_TWENTIES.getKey(), AgeEnum.EARLY_TWENTIES.getValue());
//		ageMap.put(AgeEnum.LATE_TWENTIES.getKey(), AgeEnum.LATE_TWENTIES.getValue());
//		ageMap.put(AgeEnum.EARLY_THIRTIES.getKey(), AgeEnum.EARLY_THIRTIES.getValue());
//		ageMap.put(AgeEnum.LATE_THIRTIES.getKey(), AgeEnum.LATE_THIRTIES.getValue());
//		ageMap.put(AgeEnum.EARLY_FORTIES.getKey(), AgeEnum.EARLY_FORTIES.getValue());
//		ageMap.put(AgeEnum.LATE_FORTIES.getKey(), AgeEnum.LATE_FORTIES.getValue());
//		ageMap.put(AgeEnum.EARLY_FIFTIES.getKey(), AgeEnum.EARLY_FIFTIES.getValue());
//		ageMap.put(AgeEnum.LATE_FIFTIES.getKey(), AgeEnum.LATE_FIFTIES.getValue());
//		model.addAttribute("ageMap", ageMap);
//	}
//}
