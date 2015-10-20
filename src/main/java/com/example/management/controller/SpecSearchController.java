
package com.example.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.management.domain.LanguageDefine;
import com.example.management.form.SpecSearchForm;
import com.example.management.logic.EnumLogic;
import com.example.management.page.SpecSearchResultPage;
import com.example.management.service.LanguageDefineService;
import com.example.management.service.SpecSearchService;

/**
 * スペック関連Controller
 * @author takayuki.honma
 *
 */
@Controller
@Transactional
@RequestMapping(value="/search")
public class SpecSearchController {
	@Autowired
	private SpecSearchService specSearchService;
	@Autowired
	private LanguageDefineService languageDefineService;
	@Autowired
	private EnumLogic enumLogic;

	
	@ModelAttribute
	public SpecSearchForm setUpForm(){
		return new SpecSearchForm();
	}
	
	/**
	 * スペックシート検索初期画面.
	 * @param model
	 * @return 検索画面
	 */
	@RequestMapping("/")
	public String search(Model model){
		ArrayList<LanguageDefine> languageList = (ArrayList<LanguageDefine>)languageDefineService.findAll();
		model.addAttribute("languageList", languageList);
		model.addAttribute("stateMap", enumLogic.getStateMap());
		model.addAttribute("ageMap", enumLogic.getAgeMap());
		
		return "spec/search/search";
	}
	
	/**
	 * 条件に一致したユーザ情報を取得.
	 * @param form
	 * @param model
	 * @return　一致したユーザ情報
	 */
	@RequestMapping("/searchSpec")
	public String serchUser(SpecSearchForm form,BindingResult result, Model model){
		model.addAttribute("searchData", form);
		List<SpecSearchResultPage> specList = specSearchService.searchAll(form);
		model.addAttribute("specList", specList);
		return search(model);
	}

}	

