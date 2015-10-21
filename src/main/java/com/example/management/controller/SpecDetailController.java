package com.example.management.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.management.common.AgeEnum;
import com.example.management.domain.Spec;
import com.example.management.service.SpecDetailService;

@Controller
@Transactional
@RequestMapping(value = "/detail")
@SessionAttributes("userLogin")
public class SpecDetailController {
	@Autowired
	private SpecDetailService specDetailService;
	
	/**
	 * 詳細画面を表示する.
	 * @return 詳細画面
	 */
	@RequestMapping
	public String detail(//@Param("searchStaffId")String searchStaffId,
			//@ModelAttribute("userLogin")LoginUserDetails loginUser,
//			@ModelAttribute("staffId")String staffId,//追加
			Model model){
		
		//決め打ち
		String searchStaffId = "AP-000-0000";
		
		model.addAttribute("staffId",searchStaffId);
		findByStaffId(searchStaffId,model);
		
		return "spec/specDetail";
	}
	
	/**
	 * スペックシート(スタッフID）詳細情報を取得.
	 * @param staffId スタッフID
	 * @param model 
	 * @return  スペックシート（スタッフID）詳細情報
	 */
	@RequestMapping(value = "findByStaffId"/*, method = RequestMethod.POST*/)
	public String findByStaffId(String staffId,Model model){
		//1件のスペックシート情報が返ってくる
		Spec spec = specDetailService.findByStaffId(staffId);
		
		//↑がnullだった場合、エラー文を入れてフォワード
		if(spec == null) {
			model.addAttribute("errorMessage","検索されたスタッフIDは見つかりません");
			return "forward:/spec/specedit";
		}
		
		model.addAttribute("spec",spec);

		ageList(model, spec);
//		sexList(model, spec);
//		model.addAttribute("allExpDivision", specDetailService.allExpResult(staffId));
//		model.addAttribute("serverNetworkExpDivision", specDetailService.serverNetworkExpResult(staffId));
//		model.addAttribute("developmentExpDivision", specDetailService.developmentExpResult(staffId));
//		model.addAttribute("seExpDivision", specDetailService.seExpResult(staffId));
//		model.addAttribute("pgOperatorExpDivision", specDetailService.pgOperatorExpResult(staffId));

		//ログイン結合後まで保持
//		Users user = new Users(staffId, "性別", "姓", "名", "姓(ﾌﾘｶﾞﾅ)", "名(ﾌﾘｶﾞﾅ)", 2, "boost2000");
		
//		model.addAttribute("page", specDetailService.execute(user));
		
		//資格情報の取得
//		model.addAttribute("sLicenseList", getLicenses(staffId));
		//開発情報の取得
//		List<ProjectDevelopDto> dtoList = projectService.getProjectDevelopDtoList(staffId);
//		model.addAttribute("sDevelopDtoList", dtoList);
		
		return "specDetail";
	}
	
	

	/**
	 * 性別リストを取得.
	 * @param model
	 * @param spec
	 */
//	private void sexList(Model model, Spec spec) {
//		Map<String, String> sexMap = new LinkedHashMap<String, String>();
//		sexMap.put(sexEnum.MAN.getKey(), sexEnum.MAN.getValue());
//		sexMap.put(sexEnum.WOMAN.getKey(), sexEnum.WOMAN.getValue());
//		
//		model.addAttribute("sex", sexMap.get(spec.getSex()));
//	}

	/**
	 * 年代リストを取得する.
	 * @param model
	 * @param spec 
	 */
	public void ageList(Model model, Spec spec) {
		Map<Integer, String> ageMap = new LinkedHashMap<Integer, String>();
		ageMap.put(AgeEnum.EARLY_TWENTIES.getKey(), AgeEnum.EARLY_TWENTIES.getValue());
		ageMap.put(AgeEnum.LATE_TWENTIES.getKey(), AgeEnum.LATE_TWENTIES.getValue());
		ageMap.put(AgeEnum.EARLY_THIRTIES.getKey(), AgeEnum.EARLY_THIRTIES.getValue());
		ageMap.put(AgeEnum.LATE_THIRTIES.getKey(), AgeEnum.LATE_THIRTIES.getValue());
		ageMap.put(AgeEnum.EARLY_FORTIES.getKey(), AgeEnum.EARLY_FORTIES.getValue());
		ageMap.put(AgeEnum.LATE_FORTIES.getKey(), AgeEnum.LATE_FORTIES.getValue());
		ageMap.put(AgeEnum.EARLY_FIFTIES.getKey(), AgeEnum.EARLY_FIFTIES.getValue());
		ageMap.put(AgeEnum.LATE_FIFTIES.getKey(), AgeEnum.LATE_FIFTIES.getValue());
		
		model.addAttribute("age", ageMap.get(spec.getAgeId()));
	}
	
	/**
	 * 最寄駅からアサイン先までの時間検索.
	 * @param form
	 * @param staffId
	 * @param loginUser
	 * @param model
	 * @return 詳細初期画面へ
	 *//*
	@RequestMapping(value = "searchTime")
	public String searchStation(StationTimeForm form,@RequestParam String staffId,
			//@ModelAttribute("userLogin") LoginUserDetails loginUser,Model model){
		//検索日の取得
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DATE));
		if(month.length() < 2){
			month += "0" + month;
		}
		if(day.length() < 2){
			day += "0" + day;
		}

		form.setUrl("http://transit.yahoo.co.jp/search/result?flatlon=&from=" +form.getNearStation() + "&tlatlon=&to=" + form.getArrivalStation() + 
				"&via=&via=&via=&y=" + year +"&m=" + month + "&d=" + day + "&hh=08&m2=0&m1=0&type=1&ticket=ic&al=1&shin=1&ex=1&hb=1&lb=1&sr=1&s=0&expkind=1&ws=2&kw=" + form.getArrivalStation());
		String stationHour = specDetailService.getStationHour(form);
		model.addAttribute("stationHour", stationHour);
		model.addAttribute("arrivalStation", form.getArrivalStation());
		return detail(staffId,loginUser,model);
	}*/

/*	*//**
	 * ユーザの保持資格を取得する
	 * 
	 * @author takumi.sato
	 * @param staffId
	 * @return
	 *//*
	public List<UsersLicense> getLicenses(String staffId) {
		List<UsersLicense> result = usersLicenseService.findByStaffId(staffId);
		// 3の倍数個にした方が表示が楽になるので追加する。
		while (result != null && result.size() % 3 > 0) {
			result.add(new UsersLicense());
		}
		return result;
	}*/
	
}
