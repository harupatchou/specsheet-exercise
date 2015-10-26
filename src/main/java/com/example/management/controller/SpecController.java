package com.example.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.management.domain.LanguageDefine;
import com.example.management.domain.OsDefine;
import com.example.management.domain.ProcessDefine;
import com.example.management.domain.Spec;
import com.example.management.domain.Users;
import com.example.management.form.SpecForm;
import com.example.management.logic.EnumLogic;
import com.example.management.logic.ProjectLogic;
import com.example.management.logic.SpecLogic;
import com.example.management.logic.UserLogic;

@Controller
@Transactional
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
		
		insertExecute(test,specForm);
		
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
	public String osWindow(Model model,String projectNo,SpecForm s){
		List<OsDefine> osList = projectLogic.getOS();
		model.addAttribute("proNo",projectNo);
		model.addAttribute("osList",osList);
		return "spec/window/osSelect";
	}
	
	/**
	 * 言語選択小窓表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/langWindow")
	public String langWindow(Model model,String projectNo){
		List<LanguageDefine> langList = projectLogic.getLang();
		model.addAttribute("proNo",projectNo);
		model.addAttribute("langList",langList);
		return "spec/window/langSelect";
	}
	
	
	/**
	 * 開発工程選択小窓表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/processWindow")
	public String processWindow(Model model,String projectNo){
		List<ProcessDefine> processList = projectLogic.getProcess();
		model.addAttribute("proNo",projectNo);
		model.addAttribute("processList",processList);
		return "spec/window/processSelect";
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
	private Boolean insertExecute(String staffId,SpecForm form) throws Exception {
		specLogic.insertSpec(form);
		projectLogic.insertProject(staffId,form);
		return true;
	}

}
