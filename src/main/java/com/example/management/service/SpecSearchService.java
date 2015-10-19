package com.example.management.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.common.AgeEnum;
import com.example.management.common.StateEnum;
import com.example.management.domain.LanguageDefine;
import com.example.management.domain.Spec;
import com.example.management.form.SpecSearchForm;
import com.example.management.page.SpecSearchResultPage;
import com.example.management.repository.LanguageDefineRepository;
import com.example.management.repository.SpecSearchRepository;

@Service
public class SpecSearchService {
	@Autowired
	private SpecSearchRepository specSearchRepository;
	
	@Autowired
	private LanguageDefineRepository languageDefineRepository;
	
	/**
	 * スペック情報全件取得
	 * @return
	 */
	public List<Spec> findAll() {
		return specSearchRepository.findAllSpec();
	}

//	public List<SpecSearchResultPage> searchAll(SpecSearchForm form) {
//		StringBuilder sb = new StringBuilder();
//		//空文字をnullに変換
//		if (form.getName() == "") {
//			form.setName(null);
//		}
//		if (form.getTech1() == "") {
//			form.setTech1(null);
//		}
//		if (form.getTech2() == "") {
//			form.setTech2(null);
//		}
//		if (form.getTech3() == "") {
//			form.setTech3(null);
//		}
//		
//		// 検索したい開発関連技術をリストに変換
//		List<String> techSearchList = new ArrayList<>();
//		if (form.getTech1() != null) {
//			techSearchList.add(form.getTech1());
//		}
//		if (form.getTech2() != null) {
//			techSearchList.add(form.getTech2());
//		}
//		if (form.getTech3() != null) {
//			techSearchList.add(form.getTech3());
//		}
//		
//		// specの要素が全てnullの時に全件検索
//		if ((form.getName() == null) && (form.getStateFlag() == null) && (form.getLang1() == null)
//				 && (form.getLang2() == null) && (form.getLang3() == null)
//				&&  (form.getTech1() == null) && (form.getTech2() == null) && (form.getTech3() == null)
//				&& (form.getAllExp() == null) && (form.getId() == null)) {
//			List<Spec> searchSpecList = specSearchRepository.findAll();
//			return getPage(searchSpecList);
//		} else {
//			sb.append(" WHERE 1=1 ");
//			//名前がnullでない時SQL文追加
//			if (form.getName() != null) {
//				sb.append("AND u.name ILIKE '%' || :name || '%' ");
//			}
//			//状況がnullでない時SQL文追加
//			if (form.getStateFlag() != null) {
//				sb.append("AND s.state_flag=:stateFlag ");
//			}
//			////全体経験がnullでない時SQL文追加
//			if (form.getAllExp() != null) {
//				sb.append("AND s.all_exp >= :allExp ");
//			}
//			//年代がnullでない時SQL文追加
//			if (form.getId() != null) {
//				sb.append("AND s.age_id=:id ");
//			}
//			sb.append("ORDER BY u.name");
//
//		}
//		//一致するスペック情報取得
//		List<SpecSearch> specList = specSearchRepository.searchAll(form, sb);
//		
//		//開発関連技術で絞る
//		specList = searchTech(techSearchList, specList);
//		
//		// 言語名取得
//		if (form.getLang1() != null || form.getLang2() != null || form.getLang3() != null) {
//			ArrayList<Integer> langIdList = new ArrayList<>();
//			langIdList.add(form.getLang1());
//			langIdList.add(form.getLang2());
//			langIdList.add(form.getLang3());
//			langIdList = ArrayListLogic.hIntCompact(langIdList);
//			ArrayList<String> langNameList = new ArrayList<>();
//			List<LanguageDefine> langList = languageDefineRepository.findAll();
//			for (LanguageDefine langDefine : langList) {
//				for (Integer i : langIdList) {
//					if (langDefine.getId().equals(i)) {
//						langNameList.add(langDefine.getName());
//					}
//				}
//			}
//
//			// 検索する言語と一致したものを返す
//			List<SpecSearchChildPage> returnSpec = new ArrayList<>();
//			for (SpecSearchChildPage spec : getPage(specList)) {
//				for (String lang : spec.getLanguage()) {
//					for (String langName : langNameList) {
//						if (lang.equals(langName)) {
//							returnSpec.add(spec);
//						}
//					}
//				}
//			}
//			return ArrayListLogic.hUnique((ArrayList<SpecSearchChildPage>)returnSpec);
//		}
//		return ArrayListLogic.hUnique((ArrayList<SpecSearchChildPage>)getPage(specList));
//	}
//
//	// 開発関連技術
//	/**
//	 * 開発関連技術と一致した情報を取得.
//	 * @author ueno
//	 * @param techSearchList 検索条件
//	 * @param specList スペック一覧
//	 * @return 条件と一致したスペック一覧
//	 */
//	public List<SpecSearch> searchTech(List<String> techSearchList, List<SpecSearch> specList) {
//		if (techSearchList.size() == 0) {
//			return specList;
//		}
//		List<SpecSearch> tempSpecList = new ArrayList<>();
//		for (SpecSearch spec : specList) {
//			// 開発関連技術をリストに変換
//			ArrayList<String> techList = new ArrayList<>();
//			String userTech = spec.getRelatedTech();
//			String[] techs = userTech.split("\\,");
//			for (String text : techs) {
//				techList.add(text.toLowerCase());
//			}
//			for (String techName : techList) {
//				for (String searchParam : techSearchList) {
//					if (techName.toLowerCase().matches(".*" + searchParam.toLowerCase() + ".*")) {
//						if (!tempSpecList.contains(spec)) {
//							tempSpecList.add(spec);
//						}
//					}
//				}
//			}
//		}
//		return tempSpecList;
//	}
//
//	/**
//	 * スペックページ取得.
//	 * 
//	 * @param specList
//	 * @return スペックページ
//	 */
//	public List<SpecSearchChildPage> getPage(List<SpecSearch> specList) {
//		List<SpecSearchChildPage> userSpecList = new ArrayList<>();
//		String tempName = null;
//		for (SpecSearch spec : specList) {
//			SpecSearchChildPage childPage = new SpecSearchChildPage();
//			if (!(spec.getName() == null) && spec.getName().equals(tempName)) {
//
//				continue;
//			}
//			childPage.setStaffId(spec.getStaffId());
//			childPage.setName(spec.getName());
//			childPage.setStateFlag(getState(spec.getStateFlag()));
//			childPage.setTechList(spec.getRelatedTech());
//			childPage.setDivision(allExpResult(spec.getAllExp()));
//
//			childPage.setLanguage(getLanguageList(specList, spec.getName()));
//			childPage.setAge(getAge(spec.getId()));
//			childPage.setDate(spec.getUpdateDate());
//			userSpecList.add(childPage);
//
//			tempName = spec.getName();
//		}
//		return userSpecList;
//	}
//
//	/**
//	 * 言語取得
//	 * 
//	 * @param specList
//	 * @param name
//	 * @return 言語
//	 */
//	public List<String> getLanguageList(List<SpecSearch> specList, String name) {
//		List<String> languageList = new ArrayList<>();
//		String tempName = null;
//		for (SpecSearch spec : specList) {
//			if (spec.getName().equals(name)) {
//				languageList.add(spec.getLanguage());
//				tempName = name;
//				continue;
//			}
//			if ((tempName != null) && (tempName != spec.getName())) {
//				break;
//			}
//			continue;
//		}
//
//		return languageList;
//	}
//
//	/**
//	 * IT全体経験を取得.
//	 * 
//	 * @param allExp
//	 * @return
//	 */
//	public Division allExpResult(Integer allExp) {
//		Integer allExpQuotient = allExp / 12;
//		Integer allExpOver = allExp % 12;
//
//		Division division = new Division();
//		division.setQuotient(allExpQuotient);
//		division.setOver(allExpOver);
//		return division;
//	}

}
