package com.example.management.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.management.common.SkillPage;
import com.example.management.domain.LanguageExp;
import com.example.management.domain.User;
import com.example.management.logic.SpecDetailLogic;

/**
 * 言語経験レポジトリ
 * @author takayuki.honma
 *
 */
@Repository
public class LanguageExpRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	private static final ResultSetExtractor<SkillPage> LANGUAGE_EXP_EXTRACTOR = (rs) -> {
	
	ArrayList<String> langList = new ArrayList<>();
	ArrayList<Boolean> flagList = new ArrayList<>();
	String tempLang = null;
	ArrayList<Integer> monthOfLangList = new ArrayList<>();
	ArrayList<String> techList = new ArrayList<>();
	ArrayList<String> osList = new ArrayList<>();
	String tempOs = null;
	ArrayList<Integer> monthOfOsList = new ArrayList<>();
	ArrayList<String> processList = new ArrayList<>();
	String name = null;
	while (rs.next()) {
		name = rs.getString("u_name");
		String lang = rs.getString("language_name");
		if (lang == null){
			lang = "";
		}else if(!lang.equals(tempLang)) {
			tempLang = new String(lang);
			Integer langMonth = rs.getInt("l_month");
			monthOfLangList.add(langMonth);
			Integer expFlag = rs.getInt("exp_flag");
			if (expFlag.equals(0)) {
				flagList.add(false);
			} else {
				flagList.add(true);
			}
		}
		String tech = rs.getString("related_tech");
		String os = rs.getString("os_name");
		if (os == null){
			os ="";
		}else if(!os.equals(tempOs)) {
			tempOs = new String(os);
			Integer osMonth = rs.getInt("os_month");
			monthOfOsList.add(osMonth);
		}
		String process_name = rs.getString("process_name");
		if (lang != null) {
			langList.add(lang);
		}
		if (tech != null) {
			String[] techs = tech.split("\\,");
			for (String text : techs) {
				techList.add(text);
			}
		}
		if (os != null) {
			osList.add(os);
		}
		if (process_name != null) {
			processList.add(process_name);
		}
	};
//	if (langList.size() == 0) {
//		langList.add("　");
//	}
//	if (techList.size() == 0) {
//		techList.add("　");
//	}
//	if (osList.size() == 0) {
//		osList.add("　");
//	}
//	if (processList.size() == 0) {
//		processList.add("　");
//	}
	
	SkillPage page = new SkillPage(
			name,
			unique(langList), 
			monthOfLangList, 
			unique(hCompact(techList)), 
			unique(osList), 
			monthOfOsList, 
			unique(processList),
			flagList, 
			null, 
			null);
	int max = SpecDetailLogic.RawMaxSize(unique(hCompact(langList)), unique(hCompact(techList)), unique(hCompact(osList)), unique(hCompact(processList)));
	ArrayList<Integer> array = new ArrayList<>();
	for (int i = 0; i < max; ++i) {
		array.add(i);
	}
	page.setMaxSize(array);
	page.setAllContents(((SpecDetailLogic) page).allContents(unique(hCompact(langList)), unique(hCompact(techList)), unique(hCompact(osList)), 
			unique(hCompact(processList))));
	if (langList.size() == 0 && techList.size() == 0 && osList.size() == 0 && processList.size() == 0) {
		page.setAllContents(new ArrayList<String>());
	}
	return page;
};
	
	public static ArrayList<String> unique(ArrayList<String> arg0) {
		ArrayList<String> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			String x = arg0.get(i);
			if (!ret.contains(x)) {
				ret.add(x);
			}
		}
		return ret;
	}
	
	public static ArrayList<String> hCompact(ArrayList<String> arg0) {
		ArrayList<String> ret = new ArrayList<>();
		for (int i = 0; i < arg0.size(); i++) {
			if (arg0.get(i) != null && !arg0.get(i).equals("")) {
				String x = arg0.get(i);
				ret.add(x);
			}
		}
		return ret;
	}
	
	/**
	 * スキル要約欄に必要な要素をスタッフIDを使って検索
	 * @param user
	 * @return
	 */
	public SkillPage findByStaffId(User user) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", user.getStaffId());
		SkillPage page = jdbcTemplate.query(
				"SELECT us.name u_name, ld.name language_name, lang.month_of_exp l_month, s.related_tech related_tech, od.os_name os_name, "
				+ "os.month_of_exp os_month, pd.name process_name, lang.exp_flag exp_flag FROM spec s "
				+ "LEFT OUTER JOIN language_exp lang  ON lang.staff_id = s.staff_id "
				+ "LEFT OUTER JOIN language_define ld ON lang.language_id = ld.id "
				+ "LEFT OUTER JOIN os_exp os ON s.staff_id  = os.staff_id "
				+ "LEFT OUTER JOIN os_define od ON os.os_id = od.os_id "
				+ "LEFT OUTER JOIN project_process pp ON s.staff_id  = pp.staff_id "
				+ "LEFT OUTER JOIN users us ON s.staff_id = us.staff_id "
				+ "LEFT OUTER JOIN process_define pd ON pp.process_id = pd.id "
				+ "WHERE s.staff_id=:staffId ORDER BY lang.language_id",
				param, LANGUAGE_EXP_EXTRACTOR);
		if(page == null){
			return null;
		} else {
			return page;
		}
	}
	
	/**
	 * 対象ユーザの言語経験を削除する
	 * @param staffId
	 * @return 更新件数
	 * @author takumi.sato
	 */
	public Integer deleteByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId",staffId);
		return jdbcTemplate.
				update("DELETE FROM language_exp le "
						+ "WHERE le.staff_id=:staffId",param);
	}
	/**
	 * 言語経験を保存する
	 * @param languageExp
	 * @return
	 */
	public Integer save(LanguageExp languageExp){
		//保存データをマップへ詰め込む
		SqlParameterSource param = 
				new BeanPropertySqlParameterSource(languageExp);
		return jdbcTemplate.
				update("INSERT INTO language_exp VALUES(:staffId,:no,:languageId,:other,:expFlag,:monthOfExp)",param);
	}
	
	

}