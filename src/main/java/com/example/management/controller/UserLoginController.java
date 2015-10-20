package com.example.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.management.domain.Users;
import com.example.management.form.UserLoginForm;
import com.example.management.logic.UserLogic;

/**
 * ログイン関連コントローラー.
 * @author ueno
 */
@Controller
@SessionAttributes("user")
@RequestMapping(value = "userLogin")
public class UserLoginController {
	@Autowired
	private UserLogic userLogic;

	@ModelAttribute
	public UserLoginForm setUpLoginUserForm(){
		return new UserLoginForm();
	}
	
	/**
	 * ログイン画面表示
	 * @author ueno
	 * @return ログイン画面
	 */
	@RequestMapping
	public String index(){
		return "/user/login";
	}
	
	/**
	 * ログイン処理.
	 * @author ueno
	 * @return メニュー画面
	 */
	@RequestMapping(value = "login")
	public String Login(UserLoginForm form,BindingResult result,Model model){
		//エラーチェック
		if(result.hasErrors()){
			return index();
		}
		//ユーザー情報取得
		Users user = userLogic.selectByStaffIdAndPassword(form);
		//null時(不一致)にエラーメッセージ
		if(user == null){
			ObjectError error = new ObjectError("loginError", "メールアドレスまたはパスワードが違います。");
			result.addError(error);
			return index();
		}
		model.addAttribute("user",user);
		return "/user/menu";
	}
	
	/**
	 * メニュー画面へ遷移
	 * @author ueno
	 * @return メニュー画面
	 */
	@RequestMapping(value = "flowMenu")
	public String flowMenu(){
		return "/user/menu";
	}
}
