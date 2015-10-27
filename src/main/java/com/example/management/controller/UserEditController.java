package com.example.management.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.management.domain.User;
import com.example.management.form.UserEditForm;
import com.example.management.logic.UserLogic;
import com.example.management.service.UserEditService;

/**
 * ユーザー情報編集関連コントローラー.
 * @author ueno
 */
@Controller
@SessionAttributes("user")
@RequestMapping(value = "userEdit")
public class UserEditController {
	@Autowired
	private UserEditService userEditService;
	@Autowired
	private UserLogic userLogic;
	
	@ModelAttribute
	public UserEditForm setUpUserEditForm(){
		return new UserEditForm();
	}
	
	/**
	 * ユーザー編集初期画面
	 * @author ueno
	 * @return 編集初期画面
	 */
	@RequestMapping
	public String index(String staffId, UserEditForm form, Model model){
		//staffIdがnull値の時フォームをモデルに格納(パスワード不一致時の処理)
		if(staffId == null){
			model.addAttribute("userData", form);
			return "/user/edit/userEdit";
		}
			//staffId値のユーザー情報をモデルに格納
			User user = userLogic.selectByStaffId(staffId);
			//user情報をフォームにコピー
			BeanUtils.copyProperties(user, form);
			//staffIdを分割してstaffIdパーツに格納
			UserEditForm userData = userLogic.setStaffId(form);
			model.addAttribute("userData", userData);
		return "/user/edit/userEdit";
	}
	
	/**
	 * 編集確認画面へ遷移.
	 * @author ueno
	 * @return 確認画面
	 */
	@RequestMapping(value = "flowConfirm")
	public String flowConfirm(UserEditForm form, BindingResult result, Model model){
		//パスワードチェック
		if(form.getPassword() != null){
			User tempUser = userLogic.selectByStaffIdAndPassword(form.getTempStaffId(), form.getPassword());
			//不一致でエラーメッセージ表示
			if(tempUser == null){
				ObjectError error = new ObjectError("passwordError", "現在のパスワードが間違っています");
				result.addError(error);
				return index(null, form, model); 
			}
		}
		//新パスワードチェック
		if(!form.getNewPassword().equals(form.getConfirmPassword())){
			ObjectError error = new ObjectError("newPasswordError", "新しいパスワードと確認パスワードが一致しません");
			result.addError(error);
			model.addAttribute("userData", form);
			return index(null, form, model); 
		}
	
		//編集前データ
		User tempUserData = userLogic.selectByStaffId(form.getTempStaffId());
		model.addAttribute("userData", tempUserData);
		//編集後データ
		form.setStaffId(form.getStaffIdFirst() + "-" + form.getStaffIdSecond() + "-" + form.getStaffIdThird());
		model.addAttribute("userEditForm",form);
		return "/user/edit/userEditConfirm";
	}
	
	/**
	 * 完了画面へ遷移.
	 * @author ueno
	 * @return 完了画面
	 */
	@RequestMapping(value = "update")
	public String update(UserEditForm form, String flag, Model model){
		//flag "変更" ⇒ ユーザー情報更新
		if(flag.equals("変更")){
			//スタッフIDパーツを結合後update
			form.setStaffId(form.getStaffIdFirst() + "-" + form.getStaffIdSecond() + "-" + form.getStaffIdThird());
			userEditService.update(form);
			return "/user/edit/userEditFinished";
		}
		//flag "修正する" ⇒ 編集画面へ
		return index(null, form, model);
	}
}
