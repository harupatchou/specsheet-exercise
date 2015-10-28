package com.example.management.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.Spec;
import com.example.management.domain.User;
import com.example.management.logic.ArrayListLogic;
import com.example.management.page.SpecDetailDevelopmentExperiencePage;
import com.example.management.page.SpecDetailExpBreakdownPage;
import com.example.management.page.SpecDetailLicensePage;
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
	@Autowired
	private ArrayListLogic arrayListLogic;
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
	public Spec findSpecByStaffId(String staffId) {
		try{
			Spec spec = specDetailRepository.findSpecByStaffId(staffId);
			Integer AllExp = spec.getAllExp();

			Integer AllExpYear = (AllExp)/12;
			Integer AllExpMonth = (AllExp)%12;
			spec.setYear(AllExpYear);
			spec.setMonth(AllExpMonth);

			return spec;
		}catch(NullPointerException e){
			return null;
		}
	}
	
	/**
	 * スペックシート（スペックID)詳細取得.
	 * @param staffId　スタッフID
	 * @return　スペックシート（スペックID)詳細
	 */
	public User findUsersByStaffId(String staffId) {
		try{
			return specDetailRepository.findUsersByStaffId(staffId);
		}catch(NullPointerException e){
			return null;
		}
	}
	
	/**
	 * スペックシート(IT経験）詳細取得.
	 * @param staffId スタッフID
	 * @return　スペックシート(IT経験）詳細
	 */
	public SpecDetailExpBreakdownPage findExpBreakdownByStaffId(String staffId){
		SpecDetailExpBreakdownPage result = new SpecDetailExpBreakdownPage();
		List<SpecDetailExpBreakdownPage> find = specDetailRepository.findExpBreakdownByStaffId(staffId);
		Integer[] temp = {0, 0, 0, 0, 0};
		for (SpecDetailExpBreakdownPage page : find) {
			temp[page.getExpBreakdownId()] = page.getMonthOfExp();
			result = page;
		}
		Integer[] y = {0, 0, 0, 0, 0};
		Integer[] m = {0, 0, 0, 0, 0};
		for (int i = 0; i < temp.length; ++i) {
			y[i] = temp[i] / 12;
			m[i] = temp[i] % 12;
		}
		result.setYear(y);
		result.setMonth(m);
		
		return result;
	}
	
	/**
	 * スペックシート（資格）詳細取得.
	 * @param staffId スタッフID
	 * @return スペックシート（資格）詳細
	 */
	public List<SpecDetailLicensePage> findLicenseByStaffId(String staffId){
		List<SpecDetailLicensePage> specDetailExpBreakdownPageList = specDetailRepository.findLicenseByStaffId(staffId);
		//データ数が奇数のとき、表示をきれいにするため1件空のデータを入れる
		if(specDetailExpBreakdownPageList.size() % 2 != 0){
			specDetailExpBreakdownPageList.add(null);
		}
		return specDetailExpBreakdownPageList;
	}
	
	/**
	 * スペックシートスキル要約の言語取得.
	 * @param staffId スタッフID
	 * @return スキル要約の言語
	 */
	public List<String> findLanguageByStaffId(String staffId){
		List<String> specDetailLanguagePageList = specDetailRepository.findLanguageByStaffId(staffId);
		return specDetailLanguagePageList;
	}
	
	/**
	 * スペックシートスキル要約の環境(OS等)取得.
	 * @param staffId スタッフID
	 * @return スキル要約の環境(OS等)	
	 */
	public List<String> findOsByStaffId(String staffId){
		List<String> specDetailOsPageList = specDetailRepository.findOsByStaffId(staffId);
		return specDetailOsPageList;
	}
	
	/**
	 * スペックシートスキル要約の開発関連技術取得.
	 * @param staffId スタッフID
	 * @return　スキル要約の開発関連技術
	 */
	public List<String> findDevelopmentRelatedTechnologyByStaffId(String staffId){
		ArrayList<String> returnList = new ArrayList<>();
		List<String> specDetailDevelopmentRelatedTechnologyPageList = specDetailRepository.findDevelopmentRelatedTechnologyByStaffId(staffId);
		for (String str : specDetailDevelopmentRelatedTechnologyPageList) {
			String[] techList = str.split(",");
			for (String techs : techList) {
				String[] tech = techs.split("/");
				for (String t : tech) {
					returnList.add(t);
				}
			}
		}
		return arrayListLogic.hStrUnique(returnList);
	}
	
	/**
	 * スペックシートスキル要約の業務範囲(工程)取得.
	 * @param staffId スタッフID
	 * @return スキル要約の業務範囲(工程)
	 */
	public List<String> findProcessByStaffId(String staffId){
		List<String> specDetailProcessPageList = specDetailRepository.findProcessByStaffId(staffId);
		return specDetailProcessPageList;
	}
	
	

	/**
	 * スペックシートスキル要約の全ての情報取得.
	 * @param staffId スタッフID
	 * @return スキル要約の全ての情報
	 */
	public List<String> findSkillsSummaryByStaffId(String staffId){
		
		List<String> languageList = findLanguageByStaffId(staffId);
		List<String> osList = findOsByStaffId(staffId);
		List<String> developmentRelatedTechnologyList = findDevelopmentRelatedTechnologyByStaffId(staffId);
		List<String> processList = findProcessByStaffId(staffId);
		
		//それぞれの配列に格納されている、要素の数を取りだし、もっとも大きな配列を求める
		int ECLanguage = languageList.size();
		int ECOs = osList.size();
		int ECDevelopmentRelatedTechnology = developmentRelatedTechnologyList.size();
		int ECProcessList = processList.size();
		//比較
		int MaximumElementCount = Math.max(ECLanguage,ECOs);
		int MaximumElementCount2 = Math.max(ECDevelopmentRelatedTechnology,ECProcessList);
		int MaximumElementCount3= Math.max(MaximumElementCount,MaximumElementCount2);
		
		//表示のためにひとつの配列に2個ずつ格納、要素がなくなるまで繰り返し、空の場合は空文字（null？）を入れておく
		ArrayList<String> SkillsSummary = new ArrayList<>();
		
		//回す回数を求める＝MaximumElementCount3　2個づつ表示なので最大要素数÷2回になる
		int rotation = MaximumElementCount3 / 2;//回転数
		
		for(int i = 0 ; i <= rotation ; i++){
			//言語から2個入れる、空の場合は空文字を入れる
			for(int lang = 0 ; lang < 2 ; lang++){
				if(languageList.size() >= (lang + i*2 +1)){
					SkillsSummary.add(languageList.get(lang + i*2));
				}else{
					SkillsSummary.add("");
				}
			}
			//開発関連技術から2個入れる、空の場合は空文字を入れる
			for(int dev = 0 ; dev < 2 ; dev++){
				if(developmentRelatedTechnologyList.size() >= (dev + i*2 +1)){
					SkillsSummary.add(developmentRelatedTechnologyList.get(dev + i*2));
				}else{
					SkillsSummary.add("");
				}
			}
			//OSから2個入れる、空の場合は空文字を入れる
			for(int os = 0 ; os < 2 ; os++){
				if(osList.size() >= (os + i*2 +1)){
					SkillsSummary.add(osList.get(os + i*2));
				}else{
					SkillsSummary.add("");
				}
			}
			//業務工程から2個入れる、空の場合は空文字を入れる
			for(int pro = 0 ; pro < 2 ; pro++){
				if(processList.size() >= (pro + i*2 +1)){
					SkillsSummary.add(processList.get(pro + i*2));
				}else{
					SkillsSummary.add("");
				}
			}
		}
		return SkillsSummary;
	}
	
	
	//開発経験
	public List<SpecDetailDevelopmentExperiencePage> findDevelopmentExperienceByStaffId(String staffId){
		//送る為の空のリストを作る
		List<SpecDetailDevelopmentExperiencePage> developmentExperienceList = new ArrayList<>();
		List<SpecDetailDevelopmentExperiencePage> returnList = new ArrayList<>();
		
		//重複を削除
		ArrayList<SpecDetailDevelopmentExperiencePage> specDetailDevelopmentExperiencePageList = 
				(ArrayList<SpecDetailDevelopmentExperiencePage>) specDetailRepository.findDevelopmentExperienceByStaffId(staffId);
		
		developmentExperienceList = arrayListLogic.hSpecDetailDevelopmentExperiencePageUnique(specDetailDevelopmentExperiencePageList);
		
		//開発経験のOS・言語・その他・担当工程・担当役割のリストを作る（１対多だから
		ArrayList<String> osNameList = new ArrayList<>();
		ArrayList<String> languageNameList = new ArrayList<>();
		ArrayList<String> otherList = new ArrayList<>();
		ArrayList<String> processNameList = new ArrayList<>();
		ArrayList<String> roleList = new ArrayList<>();

		try{//スペックシートに情報がない場合、nullを返す
			int no = developmentExperienceList.get(0).getNo();

			int count = 0;
			int tempId = developmentExperienceList.get(0).getNo();

			for(SpecDetailDevelopmentExperiencePage i : developmentExperienceList){
				//プロジェクトNOとカウントが不一致のとき、リターンリストに入れて、カウントを加算
				tempId = i.getNo();
				System.out.print(count + "周目：");
				System.out.println(no != tempId);
				System.out.println(i);
				osNameList.add(i.getOsName());
				languageNameList.add(i.getLanguageName());
				otherList.add(i.getOther());
				processNameList.add(i.getProcessName());
				roleList.add(i.getRole());
				if((count < (developmentExperienceList.size() - 1) && !developmentExperienceList.get(count).getNo()
						.equals(developmentExperienceList.get(count + 1).getNo())) || 
						(count == (developmentExperienceList.size() - 1))) {
					i.setOsNameList(arrayListLogic.hStrUnique(osNameList));
					i.setLanguageNameList(arrayListLogic.hStrUnique(languageNameList));
					i.setOtherList(arrayListLogic.hStrUnique(otherList));
					i.setProcessNameList(arrayListLogic.hStrUnique(processNameList));
					i.setRoleList(arrayListLogic.hStrUnique(roleList));
					returnList.add(i);
					System.out.println("ADDする：" + i);
					osNameList.clear();
					languageNameList.clear();
					otherList.clear();
					processNameList.clear();
					roleList.clear();
				}
				no = i.getNo();
				count++;
			}

		}catch(IndexOutOfBoundsException e){
			return null;
		}

		//期間取りだす
		for(SpecDetailDevelopmentExperiencePage i : returnList){
			Date startDate = i.getStartDate();
			Date finishDate = i.getFinishDate();

			int ret = differenceMonth(finishDate,startDate);

			i.setPeriod(ret);
		}
		return returnList;
	}


	
	//ロジックに切り分けましょう
	/**
	 * 開始期間と終了期間の差分を算出.
	 * @param date1
	 * @param date2
	 * @return　開始期間と終了期間の差分
	 */
	public static int differenceMonth(Date date1, Date date2) {
	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(date1);
	    cal1.set(Calendar.DATE, 1);
	    Calendar cal2 = Calendar.getInstance(); 
	    cal2.setTime(date2);
	    cal2.set(Calendar.DATE, 1);
	    int count = 0;
	    if (cal1.before(cal2)) {
	        while (cal1.before(cal2)) {
	            cal1.add(Calendar.MONTH, 1);
	            count--;
	        }
	    } else {
	        count--;
	        while (!cal1.before(cal2)) {
	            cal1.add(Calendar.MONTH, -1);
	            count++;
	        }
	    }
	    return count;
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
