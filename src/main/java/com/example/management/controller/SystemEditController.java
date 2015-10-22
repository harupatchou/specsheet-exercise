package com.example.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.management.domain.LanguageDefine;
import com.example.management.domain.OsDefine;
import com.example.management.service.SystemEditService;

/**
 * システム編集を行うコントローラー.
 * @author takayuki.honma
 *
 */
@Controller
@Transactional
@RequestMapping(value = "/system")
public class SystemEditController {
	@Autowired
	private SystemEditService systemEditService;
	
	/**
	 * システム編集初期画面.
	 * @param model 
	 * @return 初期画面
	 */
	@RequestMapping
	public String index(Model model){
		List<LanguageDefine> languageList = systemEditService.findAllLanguage();
		model.addAttribute("languageList", languageList);
		
		List<OsDefine> osList = systemEditService.findAllOs();
		model.addAttribute("osList", osList);
		
		return "user/systemEdit";
	}
	
	/**
	 * メニュー画面へ遷移.
	 * @returnメニュー画面
	 */
	@RequestMapping(value="flow")
	public String flow(){
		return "user/menu";
	}
	
	/**
	 * 言語を登録.
	 * @param name 言語名
	 * @param model
	 * @return システム編集画面
	 */
	@RequestMapping(value = "editLanguage")
	public String editLanguage(String name, Model model){
		systemEditService.editLanguage(name);
		return "redirect:/system";
	}
	
	/**
	 * OSを登録.
	 * @param osName OS名
	 * @param model
	 * @return システム編集画面
	 */
	@RequestMapping(value = "editOs")
	public String editOs(String osName, Model model){
		systemEditService.editOs(osName);
		return "redirect:/system";
	}
}
