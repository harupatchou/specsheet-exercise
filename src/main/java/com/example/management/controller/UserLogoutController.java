package com.example.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * ユーザがログアウトするControllerクラス.
 * @author ueno
 */
@Controller
@Transactional
@SessionAttributes("scopedTarget.user")
@RequestMapping("/userLogout")
public class UserLogoutController {
	/**
	 * ログイン情報の入ったセッションスコープを削除するメソッド.
	 * @author ueno
	 * @return ログイン画面
	 */
	@RequestMapping
	public String logout(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "redirect:/";
		}

}
