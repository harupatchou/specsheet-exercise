package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.Spec;
import com.example.management.repository.SpecDetailRepository;

/**
 * スペックシート詳細表示をするサービス.
 * @author okamoto
 *
 */
@Service
public class SpecDetailService {
	@Autowired
	private SpecDetailRepository specDetailRepository; 
//	@Autowired
//	private LanguageExpRepository languageExpRepository;
//	
//	public SkillPage execute(Users user) {
//		return languageExpRepository.findByStaffId(user);
//	}
	
	/**
	 * スペックシート（スペックID)詳細取得.
	 * @param staffId　スタッフID
	 * @return　スペックシート（スペックID)詳細
	 */
	public Spec findByStaffId(String staffId) {
		return specDetailRepository.findByStaffId(staffId);
	}
	
//	/**
//	 * 全体経験取得.
//	 * 
//	 * @param staffId スタッフID
//	 * @return 全体経験
//	 */
//	public Division allExpResult(String staffId) {
//		Spec spec = specDetailRepository.findByStaffId(staffId);
//		Integer allExpQuotient = spec.getAllExp() / 12;
//		Integer allExpOver = spec.getAllExp() % 12;
//
//		Division division = new Division();
//		division.setQuotient(allExpQuotient);
//		division.setOver(allExpOver);
//		return division;
//	}
//
//	/**
//	 * サーバ・NW経験取得.
//	 * 
//	 * @param staffId
//	 *            スタッフID
//	 * @return サーバ・NW経験
//	 */
//	public Division serverNetworkExpResult(String staffId) {
//		Spec spec = specDetailRepository.findByStaffId(staffId);
//		Integer serverNetworkExpQuotient = spec.getServerNetworkExp() / 12;
//		Integer serverNetworkExpOver = spec.getServerNetworkExp() % 12;
//
//		Division division = new Division();
//		division.setQuotient(serverNetworkExpQuotient);
//		division.setOver(serverNetworkExpOver);
//		return division;
//	}
//
//	/**
//	 * システム開発経験取得.
//	 * 
//	 * @param staffId
//	 *            スタッフID
//	 * @return システム開発経験
//	 */
//	public Division developmentExpResult(String staffId) {
//		Spec spec = specDetailRepository.findByStaffId(staffId);
//		Integer developmentExpQuotient = spec.getDevelopmentExp() / 12;
//		Integer developmentExpOver = spec.getDevelopmentExp() % 12;
//
//		Division division = new Division();
//		division.setQuotient(developmentExpQuotient);
//		division.setOver(developmentExpOver);
//		return division;
//	}
//
//	/**
//	 * SE経験取得
//	 * 
//	 * @param staffId
//	 *            スタッフId
//	 * @return SE経験
//	 */
//	public Division seExpResult(String staffId) {
//		Spec spec = specDetailRepository.findByStaffId(staffId);
//		Integer seExpQuotient = spec.getSeExp() / 12;
//		Integer seExpOver = spec.getSeExp() % 12;
//
//		Division division = new Division();
//		division.setQuotient(seExpQuotient);
//		division.setOver(seExpOver);
//		return division;
//	}
//
//	/**
//	 * PG・作業員経験取得
//	 * 
//	 * @param staffId
//	 *            スタッフID
//	 * @return PG・作業員経験
//	 */
//	public Division pgOperatorExpResult(String staffId) {
//		Spec spec = specDetailRepository.findByStaffId(staffId);
//		Integer pgOperatorExpQuotient = spec.getPgOperatorExp() / 12;
//		Integer pgOperatorExpOver = spec.getPgOperatorExp() % 12;
//
//		Division division = new Division();
//		division.setQuotient(pgOperatorExpQuotient);
//		division.setOver(pgOperatorExpOver);
//		return division;
//	}
//
//	// public List<Spec> findByStaffId(String staffId){
//	// return specRepository.findByStaffId(staffId);
//	// }
//
//	/**
//	 * 最寄駅からアサイン先までの時間取得.
//	 * @param form
//	 * @return 時間
//	 */
//	public String getStationHour(StationTimeForm form) {
//		String stationTime = null;
//		try {
//			Document doc = Jsoup.connect(form.getUrl()).get();
//			Elements ele = doc.select(".small");
//			//eleの最初の要素を取得
//			Element hour = ele.first();
//			//hourをstring型に変換
//			String stationHour = hour.text();
//			//stationTimeの前後の()を削除
//			stationTime = stationHour.substring(1, stationHour.length() - 1);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return stationTime;
//	}
	
}
