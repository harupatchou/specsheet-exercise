package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.page.ExpBreakdownPage;
import com.example.management.repository.ExpBreakdownRepository;

@Service
public class ExpBreakdownService {
	@Autowired
	ExpBreakdownRepository expBreakdownRepository;
	
	/**
	 * 経験内訳1件取得(ExpBreakdownPage).
	 * @param staffId スタッフID
	 * @return 1件の経験内訳、ない場合はnullを返す
	 */
	public ExpBreakdownPage findExpBreakdownByStaffId(String staffId) {
		ExpBreakdownPage breakdown = new ExpBreakdownPage();
		breakdown.setStaffId(staffId);
		for (ExpBreakdownPage i : expBreakdownRepository.findExpBreakdownByStaffId(staffId)) {
			
		}
		return breakdown;
	}

}
