package com.example.management.logicImpl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.management.domain.Spec;
import com.example.management.form.SpecForm;
import com.example.management.logic.SpecLogic;
import com.example.management.page.SpecEditSkillsSummaryChildPage;
import com.example.management.service.SpecService;

@Component
public class SpecLogicImpl implements SpecLogic{
	
	@Autowired
	private SpecService specService;

	//個人の情報の取得
	@Override
	public Spec selectByStaffId(String staffId) {
		Spec spec = specService.selectByStaffId(staffId);
		return spec;
	}
	
	//スペック情報の登録
	@Override
	public void insertSpec(SpecForm form) {
		specService.insertSpec(form);
	}
	
	//SpecEditSkillsSummaryChildPageのリスト要素で最大のサイズを取得
	@Override
	public Integer maxLength(SpecEditSkillsSummaryChildPage skillsSummary){
		//リスト要素の長さを取得してリストに格納
		List<Integer> maxNumber = new ArrayList<>();
		maxNumber.add(skillsSummary.getLangList().size());
		maxNumber.add(skillsSummary.getOsList().size());
		maxNumber.add(skillsSummary.getExpFlagList().size());
		maxNumber.add(skillsSummary.getMonthOfLangExpList().size());
		maxNumber.add(skillsSummary.getMonthOfOsExpList().size());
		//昇順に並び替え
		Collections.sort(maxNumber);
		//降順に並び替え
		Collections.reverse(maxNumber);
		//最大数値取得
		int maxListSize = maxNumber.get(maxNumber.get(0));
		return maxListSize;
	}
	

}
