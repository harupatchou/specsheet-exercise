package com.example.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.LanguageDefine;
import com.example.management.form.SpecSearchForm;
import com.example.management.logic.ArrayListLogic;
import com.example.management.logic.EnumLogic;
import com.example.management.page.SpecSearchResultPage;
import com.example.management.repository.LanguageDefineRepository;
import com.example.management.repository.SpecSearchRepository;

@Service
public class SpecSearchService {
	@Autowired
	private SpecSearchRepository specSearchRepository;
	@Autowired
	private LanguageDefineRepository languageDefineRepository;
	@Autowired
	private EnumLogic enumLogic;
	@Autowired
	private ArrayListLogic arrayListLogic;
	
	/**
	 * スペック情報全件取得
	 * @return
	 */
	public List<SpecSearchResultPage> findAll() {
		return generatePage(specSearchRepository.findAllSpec());
	}

	/**
	 * 複数の検索条件に応じたスペック情報を取得
	 * @param form
	 * @return　検索画面表示用Pageオブジェクト
	 */
	public List<SpecSearchResultPage> searchAll(SpecSearchForm form) {
		StringBuilder sb = new StringBuilder();
		//空文字をnullに変換
		if (form.getFirstName() == "") {
			form.setFirstName(null);
		}
		if (form.getLastName() == "") {
			form.setLastName(null);
		}
		if (form.getTech1() == "") {
			form.setTech1(null);
		}
		if (form.getTech2() == "") {
			form.setTech2(null);
		}
		if (form.getTech3() == "") {
			form.setTech3(null);
		}
		
		// 検索したい開発関連技術をリストに変換
		List<String> techSearchList = new ArrayList<>();
		if (form.getTech1() != null) {
			techSearchList.add(form.getTech1());
		}
		if (form.getTech2() != null) {
			techSearchList.add(form.getTech2());
		}
		if (form.getTech3() != null) {
			techSearchList.add(form.getTech3());
		}
		
		// specの要素が全てnullの時に全件検索
		if ((form.getFirstName() == null) && (form.getLastName() == null) && (form.getStateFlag() == null) && (form.getLang1() == null)
				 && (form.getLang2() == null) && (form.getLang3() == null)
				&&  (form.getTech1() == null) && (form.getTech2() == null) && (form.getTech3() == null)
				&& (form.getAllExp() == null) && (form.getId() == null)) {
			List<SpecSearchResultPage> searchSpecList = specSearchRepository.findAllSpec();
			return generatePage(searchSpecList);
		} else {
			sb.append(" WHERE 1=1 ");
			//名前がnullでない時SQL文追加
			if (form.getFirstName() != null) {
				sb.append("AND u.first_name ILIKE '%' || :firstName || '%' ");
			}
			if (form.getLastName() != null) {
				sb.append("AND u.last_name ILIKE '%' || :lastName || '%' ");
			}
			//状況がnullでない時SQL文追加
			if (form.getStateFlag() != null) {
				sb.append("AND s.state_flag=:stateFlag ");
			}
			////全体経験がnullでない時SQL文追加
			if (form.getAllExp() != null) {
				sb.append("AND s.all_exp >= :allExp ");
			}
			//年代がnullでない時SQL文追加
			if (form.getId() != null) {
				sb.append("AND s.age_id=:id ");
			}
			sb.append("ORDER BY u.first_name");

		}
		//一致するスペック情報取得
		List<SpecSearchResultPage> specList = specSearchRepository.searchAll(form, sb);
		
		//開発関連技術で絞る
		specList = searchByTech(techSearchList, specList);
		
		// 言語名取得
		if (form.getLang1() != null || form.getLang2() != null || form.getLang3() != null) {
			ArrayList<Integer> langIdList = new ArrayList<>();
			langIdList.add(form.getLang1());
			langIdList.add(form.getLang2());
			langIdList.add(form.getLang3());
			langIdList = arrayListLogic.hIntCompact(langIdList);
			ArrayList<String> langNameList = new ArrayList<>();
			List<LanguageDefine> langList = languageDefineRepository.findAll();
			for (LanguageDefine langDefine : langList) {
				for (Integer i : langIdList) {
					if (langDefine.getId().equals(i)) {
						langNameList.add(langDefine.getName());
					}
				}
			}

			// 検索する言語と一致したものを返す
			List<SpecSearchResultPage> returnSpec = new ArrayList<>();
			for (SpecSearchResultPage page : generatePage(specList)) {
				for (String lang : arrayListLogic.hStrCompact(page.getLangList())) {
					for (String langName : langNameList) {
						if (lang.equals(langName)) {
							returnSpec.add(page);
						}
					}
				}
			}
			return arrayListLogic.hSearchResultUnique((ArrayList<SpecSearchResultPage>)returnSpec);
		}
		return arrayListLogic.hSearchResultUnique((ArrayList<SpecSearchResultPage>)generatePage(specList));
	}

	// 開発関連技術
	/**
	 * 開発関連技術と一致した情報を取得.
	 * @author ueno
	 * @param techSearchList 検索条件
	 * @param specList スペック一覧
	 * @return 条件と一致したスペック一覧
	 */
	private List<SpecSearchResultPage> searchByTech(List<String> techSearchList, List<SpecSearchResultPage> specList) {
		if (techSearchList.size() == 0) {
			return specList;
		}
		List<SpecSearchResultPage> tempSpecList = new ArrayList<>();
		for (SpecSearchResultPage spec : specList) {
			if (spec.getUpdateDate() == null) {
				//スペックシート未登録の場合次のループへ
				continue;
			}
			// 開発関連技術をリストに変換
			ArrayList<String> techList = new ArrayList<>();
			String userTech = spec.getRelatedTech();
			String[] techs = userTech.split("\\,");
			for (String text : techs) {
				techList.add(text.toLowerCase());
			}
			for (String techName : techList) {
				for (String searchParam : techSearchList) {
					if (techName.toLowerCase().matches(".*" + searchParam.toLowerCase() + ".*")) {
						if (!tempSpecList.contains(spec)) {
							tempSpecList.add(spec);
						}
					}
				}
			}
		}
		return tempSpecList;
	}

	/**
	 * スペックページ取得.
	 * 
	 * @param specList
	 * @return スペックページ
	 */
	private List<SpecSearchResultPage> generatePage(List<SpecSearchResultPage> specList) {
		List<SpecSearchResultPage> userSpecList = new ArrayList<>();
		String tempId = null;
		for (SpecSearchResultPage spec : specList) {
			SpecSearchResultPage resultPage = new SpecSearchResultPage();
			if (!(spec.getStaffId() == null) && spec.getStaffId().equals(tempId)) {
				//スタッフIDが変わったタイミング以外はすっ飛ばす
				continue;
			}
			resultPage.setStaffId(spec.getStaffId());
			resultPage.setFirstName(spec.getFirstName());
			resultPage.setLastName(spec.getLastName());
			resultPage.setFullName(spec.getFirstName() + spec.getLastName());
			resultPage.setState(enumLogic.getStateMap().get(spec.getStateFlag()));
			resultPage.setRelatedTech(spec.getRelatedTech());
			//年月計算
			Integer y = spec.getAllExp() / 12;
			Integer m = spec.getAllExp() % 12;
			Integer[] ym = {y, m};
			resultPage.setAllExpArray(ym);
			resultPage.setLangList(generateLanguageList(specList, spec.getStaffId()));
			resultPage.setAgeRange(enumLogic.getAgeMap().get(spec.getAgeId()));
			resultPage.setUpdateDate(spec.getUpdateDate());
			userSpecList.add(resultPage);

			tempId = spec.getStaffId();
		}
		return userSpecList;
	}

	/**
	 * 対象スタッフIDの経験言語をリスト化する
	 * 
	 * @param specList
	 * @param staffId
	 * @return 経験言語リスト
	 */
	private ArrayList<String> generateLanguageList(List<SpecSearchResultPage> specList, String staffId) {
		ArrayList<String> languageList = new ArrayList<>();
		String tempId = null;
		for (SpecSearchResultPage spec : specList) {
			if (spec.getStaffId().equals(staffId)) {
				languageList.add(spec.getLangName());
				tempId = staffId;
				continue;
			}
			if ((tempId != null) && (tempId != spec.getStaffId())) {
				break;
			}
			continue;
		}

		return languageList;
	}

}
