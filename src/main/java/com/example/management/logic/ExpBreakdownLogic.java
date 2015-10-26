package com.example.management.logic;

import org.springframework.stereotype.Component;

import com.example.management.form.SpecForm;
import com.example.management.page.ExpBreakdownPage;

@Component
public interface ExpBreakdownLogic {
	
	//経験内訳の取得
	public ExpBreakdownPage findExpBreakdownByStaffId(String staffId);
	//経験内訳の登録
	public void insertBreakdown(SpecForm form);

}
