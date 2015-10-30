package com.example.management.logic;


import java.util.List;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import com.example.management.domain.Spec;
import com.example.management.form.SpecForm;
import com.example.management.page.SpecEditSkillsSummaryChildPage;
import com.example.management.page.SpecRegistConfirmChildPage;
import com.example.management.security.AdminUserLoginDetails;
import com.example.management.security.UserLoginDetails;

@Component
public interface SpecLogic {
	
	//個人情報の取得
    public Spec selectByStaffId(String staffId);
    
    //スペック情報の登録
    public void insertSpec(SpecForm form, 
			@AuthenticationPrincipal UserLoginDetails user, 
			@AuthenticationPrincipal AdminUserLoginDetails admin);
    
    //SpecEditSkillsSummaryPageの要素から最長のリストの長さを取得
    public Integer maxLength(SpecEditSkillsSummaryChildPage skillsSummary);
    
    //SpecRegistConfirmChildPageの要素から最長のリストの長さを取得
    public Integer maxRegistLength(SpecRegistConfirmChildPage registConfirm);
    
    //スペックシート登録確認画面用スキル要約欄表示要素
    public List<String> setRegistConfirmSkillsSummary(SpecForm form);

}
