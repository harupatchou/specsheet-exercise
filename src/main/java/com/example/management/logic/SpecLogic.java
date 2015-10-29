package com.example.management.logic;


import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import com.example.management.domain.Spec;
import com.example.management.form.SpecForm;
import com.example.management.security.AdminUserLoginDetails;
import com.example.management.security.UserLoginDetails;
import com.example.management.page.SpecEditSkillsSummaryChildPage;

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

}
