package com.example.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Transactional
@RequestMapping(value = "/test")
public class testController {
	
	/**
	 * システム編集初期画面.
	 * @param model 
	 * @return 初期画面
	 */
	@RequestMapping
	public String index(Model model){
		System.out.print("test");
		return "index";
	}
	
	

}
