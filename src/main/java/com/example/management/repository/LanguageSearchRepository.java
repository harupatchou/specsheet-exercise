package com.example.management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.LanguageDefine;
import com.example.management.domain.LanguageExp;

@Transactional
@Repository
public class LanguageSearchRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<LanguageDefine> LANGUAGE_ROW_MAPPER = (rs,i) -> {
		Integer langId = rs.getInt("id");
		String langName = rs.getString("name");
		
		return new LanguageDefine(langId, langName);
	};
	
	public static final RowMapper<LanguageExp> LANGUAGEEXP_ROW_MAPPER = (rs,i) -> {
		String staffId = rs.getString("staff_id");
		Integer no = rs.getInt("no");
		Integer languageId = rs.getInt("language_id");
		String other = rs.getString("other");
		Integer expFlag = rs.getInt("exp_flag");
		Integer monthOfExp = rs.getInt("month_of_exp");
		
		return new LanguageExp(staffId,no,languageId,other,expFlag,monthOfExp);
	};
	
	/**
	 * 経験内訳1件取得(ExpBreakdownPage).
	 * @param staffId スタッフID
	 * @return 1件の経験内訳、ない場合はnullを返す
	 */
	public Integer findIdByName(String osName) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("osName", osName);
//		try{
		LanguageDefine lang = jdbcTemplate.queryForObject(
					"SELECT id, name FROM language_define WHERE name=:osName", param, 
					LANGUAGE_ROW_MAPPER);
			return lang.getId();
//		} catch (DataAccessException e) {
//			return null;
//		}
	}
	
	/**
	 * 経験言語情報取得.
	 * @author ueno
	 * @return 経験言語情報
	 */
	public List<LanguageExp> findByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		List<LanguageExp> languageExpList =jdbcTemplate.query("SELECT * FROM language_exp WHERE staff_id=:staffId", param, LANGUAGEEXP_ROW_MAPPER);
		return languageExpList;
	}
	


}
