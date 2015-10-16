package com.example.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional
@RequestMapping(value = "/edit")
public class SpecEditController {
	
	/**
	 * 編集画面初期表示.
	 * @param model 
	 * @return 初期画面
	 */
	@RequestMapping
	public String index(Model model){
		
		return "spec/edit/specEdit";
	}

}
