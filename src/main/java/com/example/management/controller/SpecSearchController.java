
package com.example.management.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.management.domain.LanguageDefine;
import com.example.management.domain.Spec;
import com.example.management.logic.EnumLogic;
import com.example.management.service.LanguageDefineService;
import com.example.management.service.SpecSearchService;

/**
 * スペック関連Controller
 * @author takayuki.honma
 *
 */
@Controller
@Transactional
@RequestMapping(value="search")
public class SpecSearchController {
	@Autowired
	private SpecSearchService userSearchService;
	@Autowired
	private LanguageDefineService languageDefineService;

	
//	@ModelAttribute
//	public SpecSearchForm setUpForm(){
//		return new SpecSearchForm();
//	}
	
	/**
	 * スペックシート検索初期画面.
	 * @param model
	 * @return 検索画面
	 */
	@RequestMapping("/")
	public String search(Model model){
		ArrayList<LanguageDefine> languageList = (ArrayList<LanguageDefine>)languageDefineService.findAll();
		model.addAttribute("languageList", languageList);
		model.addAttribute("stateMap", EnumLogic.getState());
		model.addAttribute("ageMap", EnumLogic.getAge());
		ArrayList<Spec> specList = (ArrayList<Spec>)userSearchService.findAll();
		model.addAttribute("specList", specList);
		
		return "spec/searchTest";
	}

}	

