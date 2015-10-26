package com.example.management.service;

import java.util.List;

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
		List<ExpBreakdownPage> list = expBreakdownRepository.findExpBreakdownByStaffId(staffId);
		ExpBreakdownPage breakdown = new ExpBreakdownPage();
		breakdown.setStaffId(staffId);
		for (ExpBreakdownPage i : list) {
			if (i.getExpBreakdownId() == 1) {
				breakdown.setServerNetworkExpYear(i.getMonthOfExp() / 12);
				breakdown.setServerNetworkExpMonth(i.getMonthOfExp());
			} else if (i.getExpBreakdownId() == 2) {
				breakdown.setDevelopmentExpYear(i.getMonthOfExp() / 12);
				breakdown.setDevelopmentExpMonth(i.getMonthOfExp());
			} else if (i.getExpBreakdownId() == 3) {
				breakdown.setSeExpYear(i.getMonthOfExp() / 12);
				breakdown.setSeExpMonth(i.getMonthOfExp());
			} else {
				breakdown.setPgOperatorExpYear(i.getMonthOfExp() / 12);
				breakdown.setPgOperatorExpMonth(i.getMonthOfExp());
			}
		}
		return breakdown;
	}

}
