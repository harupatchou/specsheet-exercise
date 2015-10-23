package com.example.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.management.domain.OsDefine;
import com.example.management.domain.Spec;
import com.example.management.domain.Users;
import com.example.management.form.SpecForm;
import com.example.management.logic.EnumLogic;
import com.example.management.logic.ProjectLogic;
import com.example.management.logic.SpecLogic;
import com.example.management.logic.UserLogic;

@Controller
@RequestMapping(value = "/spec")
public class SpecController {
	
	@Autowired
	private SpecLogic specLogic;
	@Autowired
	private UserLogic userLogic;
	@Autowired
	private ProjectLogic projectLogic;
	@Autowired
	private EnumLogic enumLogic;
	
	//IDから取得したSpec情報格納
	Spec spec = new Spec();
	//IDから取得したUser情報格納
	Users user = new Users();

	
	/**
	 * SpecEditForm初期化
	 * @return
	 */
	@ModelAttribute
	public SpecForm initForm() {
		SpecForm specForm = new SpecForm();
		return specForm;
	}
	
	
	/**
	 * 登録画面初期表示.
	 * @param model 
	 * @author kurosawa
	 * @return 初期画面
	 */
	@RequestMapping(value = "/registIndex")
	public String registIndex(Model model){
		
		//決め打ち
		String test = "AP-202-0716";
		selectByStaffId(test);
		//情報を画面に送信
		model.addAttribute("spec",spec);
		model.addAttribute("user",user);
		model.addAttribute("stateMap", enumLogic.getStateMap());
		model.addAttribute("ageMap", enumLogic.getAgeMap());
		
		return "spec/regist/specRegist";
	}
	
	
	/**
	 * 登録処理.
	 * @param model 
	 * @author kurosawa
	 * @return 登録画面
	 * @throws Exception 
	 */
	@RequestMapping(value = "/regist")
	public String regist(Model model,SpecForm specForm) throws Exception{

		//決め打ち
		String test = "AP-202-0716";
		
		insertProject(test,specForm);
		
		return "spec/regist/specRegistCheck";
	}
	
	
	/**
	 * 登録内容確認.
	 * @param model 
	 * @author kurosawa
	 * @return 登録内容確認
	 */
	@RequestMapping(value = "/check")
	public String resistCheck(Model model,SpecForm specForm){

		
		
		return "spec/regist/specRegistCheck";
	}
	
	
	/**
	 * 編集画面初期表示.
	 * @param model 
	 * @author kurosawa
	 * @return 初期画面
	 */
	@RequestMapping(value = "/edit")
	public String edit(Model model){

		//情報格納用
		Spec spec = new Spec();
		
		//決め打ち
		String test = "AP-202-0716";
		selectByStaffId(test);
		
		model.addAttribute("spec",spec);
		
		return "spec/edit/specEdit";
	}
	
	/**
	 * OS選択小窓表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/osWindow")
	public String osWindow(Model model,SpecForm specForm){
		List<OsDefine> osList = projectLogic.getOS();
		model.addAttribute("proNo",specForm.getProjectNo());
		model.addAttribute("osList",osList);
		return "spec/window/osSelect";
	}
	
	
	/**
	 * spec情報取得のためのメソッド
	 * @param res
	 * @author kurosawa
	 * @return
	 * @throws Exception
	 */
	private Boolean selectByStaffId(String staffId) {
		spec = new Spec();
		user = new Users();
		//データの取得
		spec = specLogic.selectByStaffId(staffId);
		user = userLogic.selectByStaffId(staffId);
		return true;
	}
	
	
	/**
	 * spec情報取得のためのメソッド
	 * @param res
	 * @author kurosawa
	 * @return
	 * @throws Exception
	 */
	private Boolean insertProject(String staffId,SpecForm specForm) throws Exception {
		projectLogic.insertProject(staffId,specForm);
		return true;
	}

}
