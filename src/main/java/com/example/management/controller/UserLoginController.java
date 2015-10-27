package com.example.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.management.domain.User;
import com.example.management.form.UserLoginForm;
import com.example.management.logic.UserLogic;
import com.example.management.security.AdminUserLoginDetails;
import com.example.management.security.UserLoginDetails;

/**
 * ログイン関連コントローラー.
 * @author ueno
 */
@Controller
@SessionAttributes("user")
@RequestMapping(value = "/")
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
		return "/user/login/login";
	}
	
	/**
	 * ログイン処理.
	 * @author ueno
	 * @return メニュー画面
	 */
//	@RequestMapping(value = "login")
//	public String Login(UserLoginForm form,BindingResult result,Model model){
//		//エラーチェック
//		if(result.hasErrors()){
//			return index();
//		}
//		//ユーザー情報取得
//		User user = userLogic.selectByStaffIdAndPassword(form.getStaffId(), form.getPassword());
//		//null時(不一致)にエラーメッセージ
//		if(user == null){
//			ObjectError error = new ObjectError("loginError", "メールアドレスまたはパスワードが違います。");
//			result.addError(error);
//			return index();
//		}
//		model.addAttribute("user",user);
//		return "redirect/user/menu";
//	}
	
	/**
	 * メニュー画面へ遷移
	 * @author ueno
	 * @return メニュー画面
	 */
	@RequestMapping(value = "flowMenu")
	public String flowMenu(@AuthenticationPrincipal UserLoginDetails userDetails, @AuthenticationPrincipal AdminUserLoginDetails adminDetails, Model model){
		User user;
		//一般ユーザー
		if(userDetails != null ){
			user = userDetails.getUser();
			model.addAttribute("user", user);
		}
		//管理者
		if(adminDetails != null){
			user = adminDetails.getUser();
			model.addAttribute("user", user);
		}
		return "/user/menu";
	}
	
	/**
	 * ログイン失敗時処理.
	 * @return ueno
	 */
	@RequestMapping(value = "flowError")
	public String flowError(Model model){
		model.addAttribute("loginError", "メールアドレスまたはパスワードが違います。");
		return "/user/login/login";
	}
	
	/**
	 * 権限がない場合エラーページに遷移
	 * @author ueno
	 * @return エラーページ
	 */
	@RequestMapping(value="flowErrorPage")
	public String flowErrorPage(){
		return "/user/login/error";
	}
}
