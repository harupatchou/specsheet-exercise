package com.example.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class MenuController {
	/**
	 * 登録と編集を判別する.
	 * @param model 
	 * @author kurosawa
	 * @return 初期画面
	 */
	@RequestMapping(value = "/spepMenu")
	public String menuIndex(Model model){
		
		
		
		return "/user/menu";
	}
}
