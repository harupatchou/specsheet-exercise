package com.example.management.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.management.domain.LanguageDefine;
import com.example.management.domain.OsDefine;
import com.example.management.domain.ProcessDefine;
import com.example.management.domain.Project;
import com.example.management.domain.Spec;
import com.example.management.domain.User;
import com.example.management.form.SpecForm;
import com.example.management.logic.EnumLogic;
import com.example.management.logic.ExpBreakdownLogic;
import com.example.management.logic.ProjectLogic;
import com.example.management.logic.SpecLogic;
import com.example.management.logic.UserLogic;
import com.example.management.page.SpecDetailLicensePage;
import com.example.management.security.AdminUserLoginDetails;
import com.example.management.security.UserLoginDetails;
import com.example.management.service.SpecRegistService;

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
	@Autowired
	private ExpBreakdownLogic expBreakdownLogic;
	@Autowired
	private SpecRegistService specRegistService;
	
	//IDから取得したSpec情報格納
	Spec spec = new Spec();
	//IDから取得したUser情報格納
	User user = new User();
	//IDから取得したProject情報格納
	List<Project> projectList = new ArrayList<Project>();
	//編集初期表示用osList
	List<String> osEditList = new ArrayList<String>();
	//編集初期表示用langList
	List<String> langEditList = new ArrayList<String>();
	//編集初期表示用processList
	List<String> processEditList = new ArrayList<String>();

	
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
	@RequestMapping(value = "/index")
	public String Index(String staffId,Model model){
		spec = new Spec();
		spec = specLogic.selectByStaffId(staffId);
		
		
		
		//表示のための資格情報を取得　okamoto--------------------
		List<SpecDetailLicensePage> specDetailLicenseList = licensefindByStaffId(staffId);
		model.addAttribute("specDetailLicenseList",specDetailLicenseList);
		//--------------------
		
		//言語一覧を取得してMAPに格納
		setLangMap(model);
		//OS一覧を取得してMAPに格納
		setOsMap(model);
		
		/** specデータ無時⇒スペックシート登録へ  */
		if(spec == null){
			selectByStaffId(staffId);
			//情報を画面に送信
			model.addAttribute("spec",spec);
			model.addAttribute("user",user);
			model.addAttribute("stateMap", enumLogic.getStateMap());
			model.addAttribute("ageMap", enumLogic.getAgeMap());
			model.addAttribute("breakdown", expBreakdownLogic.findExpBreakdownByStaffId(staffId));
			
			
			
			return "spec/regist/specRegist";
			
		}else{
		/** specデータ無時⇒スペックシート編集画面へ */
			
			selectByStaffId(staffId);
			//所持している言語、OS、開発環境を取得
			selectByWindow(staffId);
			
			//情報を画面に送信
			
			System.out.println(spec);
			
			model.addAttribute("spec",spec);
			model.addAttribute("user",user);
			model.addAttribute("stateMap", enumLogic.getStateMap());
			model.addAttribute("ageMap", enumLogic.getAgeMap());
			model.addAttribute("breakdown", expBreakdownLogic.findExpBreakdownByStaffId(staffId));
			//所持しているprojectを取得
			model.addAttribute("projectList",projectList);
			//所持しているプロジェクトごとのOSを取得
			model.addAttribute("osEditList",osEditList);
			//所持しているプロジェクトごとのOSを取得
			model.addAttribute("langEditList",langEditList);
			//所持しているプロジェクトごとのOSを取得
			model.addAttribute("processEditList",processEditList);
			
			return "spec/edit/specEdit";
			
		}
	}


	/**
	 * 言語一覧をMAPに格納
	 * @author ueno
	 */
	private void setLangMap(Model model) {
		Map<Integer, String> langMap = new LinkedHashMap<Integer, String>();
		langMap.put(0, "----");
		List<LanguageDefine> langList = projectLogic.getLang();
		for(LanguageDefine lang : langList){
			langMap.put(lang.getId(), lang.getName());
		}
		model.addAttribute("langMap",langMap);
	}

	
	/**
	 * OS一覧をMAPに格納
	 * @author ueno
	 */
	private void setOsMap(Model model) {
		Map<Integer, String> osMap = new LinkedHashMap<Integer, String>();
		osMap.put(0, "----");
		List<OsDefine> osList = projectLogic.getOS();
		for(OsDefine os :osList){
			osMap.put(os.getOsId(), os.getOsName());
		}
		model.addAttribute("osMap",osMap);
	}
	
	
	/**
	 * 登録処理.
	 * @param model 
	 * @author kurosawa
	 * @return 登録画面
	 * @throws Exception 
	 */
	@RequestMapping(value = "/regist")
	public String regist(Model model,SpecForm specForm, 
			@AuthenticationPrincipal UserLoginDetails user, 
			@AuthenticationPrincipal AdminUserLoginDetails admin) throws Exception{
		insertExecute(specForm, user, admin);
		
//		insertUsersLicenseByStaffId(specForm);

		
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
	 * OS選択小窓表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/osWindow")
	public String osWindow(Model model,String btnNo){
		List<OsDefine> osList = projectLogic.getOS();
		model.addAttribute("btnNo",btnNo);
		model.addAttribute("osList",osList);
		return "spec/window/osSelect";
	}
	
	/**
	 * 言語選択小窓表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/langWindow")
	public String langWindow(Model model,String btnNo){
		List<LanguageDefine> langList = projectLogic.getLang();
		model.addAttribute("btnNo",btnNo);
		model.addAttribute("langList",langList);
		return "spec/window/langSelect";
	}
	
	
	/**
	 * 開発工程選択小窓表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/processWindow")
	public String processWindow(Model model,String btnNo){
		List<ProcessDefine> processList = projectLogic.getProcess();
		model.addAttribute("btnNo",btnNo);
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
		
		user = new User();
		projectList = new ArrayList<Project>();
		
		//データの取得
		user = userLogic.selectByStaffId(staffId);
		projectList = projectLogic.selectByStaffId(staffId);
		
		return true;
		
	}
	
	/**
	 * 編集初期表示情報取得のためのメソッド
	 * @param res
	 * @author kurosawa
	 * @return
	 * @throws Exception
	 */
	private Boolean selectByWindow(String staffId) {
		//編集初期表示用osList
		osEditList = new ArrayList<String>();
		//編集初期表示用langList
		langEditList = new ArrayList<String>();
		//編集初期表示用processList
		processEditList = new ArrayList<String>();
		
		//データの取得
		osEditList = projectLogic.selectOs(staffId);
		langEditList = projectLogic.selectLang(staffId);
		processEditList = projectLogic.selectProcess(staffId);
		
		return true;
		
	}
	
	
	
	/**
	 * project情報の登録処理
	 * @param res
	 * @author honma
	 * @return
	 * @throws Exception
	 */
	private Boolean insertExecute(SpecForm form, 
			@AuthenticationPrincipal UserLoginDetails user, 
			@AuthenticationPrincipal AdminUserLoginDetails admin) throws Exception {
		specLogic.insertSpec(form, user, admin);
		specRegistService.insertBreakdown(form);
		specRegistService.insertSkill(form);
		specRegistService.insertProjectOs(form);
		specRegistService.insertProjectLanguage(form);
		specRegistService.insertProjectProcess(form);
		projectLogic.insertProject(form.getStaffId() ,form);
		specRegistService.insertUsersLicenseByStaffId(form, form.getStaffId());
		return true;
	}
	
	
	/**
	 * 所有している資格情報を取得.
	 * @param staffId
	 * @author okamoto
	 * @return 所有している資格情報
	 */
	public List<SpecDetailLicensePage> licensefindByStaffId(String staffId){
		List<SpecDetailLicensePage> SpecDetailLicenseList = specRegistService.licensefindByStaffId(staffId);
		return SpecDetailLicenseList;
	}
	
}
