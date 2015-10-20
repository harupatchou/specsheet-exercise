package com.example.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.management.domain.Users;
import com.example.management.form.UserRegistForm;
import com.example.management.logic.UserLogic;
import com.example.management.service.UserRegistService;

/**
 * ユーザー登録関連コントローラー.
 * @author ueno
 */
@Controller
@RequestMapping(value = "userRegist")
public class UserRegistController {
	@Autowired
	private UserRegistService userRegistService;
	@Autowired
	private UserLogic userLogic;
	
	@ModelAttribute
	public UserRegistForm setUpUserRegistForm(){
		return new UserRegistForm();
	}
	
	/**
	 * ユーザー新規登録初期画面.
	 * @author ueno
	 * @return 登録画面
	 */
	@RequestMapping
	public String index(Model model){
		return "/user/userRegist";
	}
	
	/**
	 * 登録確認画面に遷移
	 * @return 確認画面
	 */
	@RequestMapping(value = "flowConfirmation")
	public String flowConfirmation(UserRegistForm form, BindingResult result, Model model){
		//エラーチェック
		if(result.hasErrors()){
			return index(model);
		}
		//user情報が存在する時エラーメッセージ表示
		Users user = userLogic.selectByStaffId(form.getStaffId());
		if(user != null){
			ObjectError error = new ObjectError("insertError", "すでに登録されているスタッフIDです");
			result.addError(error);
			model.addAttribute("userRegistForm", form);
			return index(model);
		}
		model.addAttribute("userRegistForm", form);
		return "/user/userRegistConfirmation";
	}
	
	/**
	 * ユーザー情報登録.
	 * flag　"はい"⇒登録、"いいえ"⇒登録画面に戻る
	 * @author ueno
	 * @param flag
	 * @return "はい"⇒登録完了画面  "いいえ"⇒登録画面
	 */
	@RequestMapping(value = "create")
	public String create(UserRegistForm form, String flag, Model model){
		if(flag.equals("はい")){
			userRegistService.insert(form);
			return "/user/userRegistFinished";
		}
		return "/user/userRegist";
	}
}
