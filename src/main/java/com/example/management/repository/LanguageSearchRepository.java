package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.LanguageDefine;

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

}
