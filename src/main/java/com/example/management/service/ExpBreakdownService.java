package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.form.SpecForm;
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
				breakdown.setServerNetworkExpMonth(i.getMonthOfExp() - breakdown.getServerNetworkExpYear() * 12);
			} else if (i.getExpBreakdownId() == 2) {
				breakdown.setDevelopmentExpYear(i.getMonthOfExp() / 12);
				breakdown.setDevelopmentExpMonth(i.getMonthOfExp() - breakdown.getDevelopmentExpYear() * 12);
			} else if (i.getExpBreakdownId() == 3) {
				breakdown.setSeExpYear(i.getMonthOfExp() / 12);
				breakdown.setSeExpMonth(i.getMonthOfExp() - breakdown.getSeExpYear() * 12);
			} else {
				breakdown.setPgOperatorExpYear(i.getMonthOfExp() / 12);
				breakdown.setPgOperatorExpMonth(i.getMonthOfExp() - breakdown.getPgOperatorExpYear() * 12);
			}
		}
		return breakdown;
	}
	
	/**
	 * 経験内訳の登録
	 * @param form
	 */
	public void insertBreakdown(SpecForm form) {
		expBreakdownRepository.insertBreakdown(form);
	}

}
