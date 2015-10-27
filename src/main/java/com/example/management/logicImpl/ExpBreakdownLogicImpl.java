package com.example.management.logicImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.management.form.SpecForm;
import com.example.management.logic.ExpBreakdownLogic;
import com.example.management.page.ExpBreakdownPage;
import com.example.management.service.ExpBreakdownService;
import com.example.management.service.SpecRegistService;

@Component
public class ExpBreakdownLogicImpl implements ExpBreakdownLogic {
	
	@Autowired
	private ExpBreakdownService expBreakdownService;
	@Autowired
	private SpecRegistService specRegistService;

	//経験内訳の取得
	@Override
	public ExpBreakdownPage findExpBreakdownByStaffId(String staffId) {
		ExpBreakdownPage breakdown = expBreakdownService.findExpBreakdownByStaffId(staffId);
		return breakdown;
	}
	
	//経験内訳の登録
	@Override
	public void insertBreakdown(SpecForm form) {
		specRegistService.insertBreakdown(form);
	}

}
