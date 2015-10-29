package com.example.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.form.SpecSearchForm;
import com.example.management.page.SpecSearchResultPage;

@Repository
@Transactional
public class SpecSearchRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//findAllのWHERE句を除いたもの
	private static final String FIND_ALL_SQL = "SELECT u.staff_id, u.first_name, "
			+ "u.last_name, s.state_flag, s.all_exp, ld.name AS lang_name, "
			+ "s.age_id, a.age_range, s.related_tech, s.update_date "
			+ "FROM users u "
			+ "LEFT OUTER JOIN spec s ON s.staff_id=u.staff_id "
			+ "LEFT OUTER JOIN age a ON s.age_id=a.id "
			+ "LEFT OUTER JOIN language_exp le ON s.staff_id=le.staff_id "
			+ "LEFT OUTER JOIN language_define ld ON le.no=ld.id ";

	public static final RowMapper<SpecSearchResultPage> SPEC_ROW_MAPPER = (rs, i) -> {
		String staffId = rs.getString("staff_id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		Integer stateFlag = rs.getInt("state_flag");
		Integer allExp = rs.getInt("all_exp");
		String langName = rs.getString("lang_name");
		Integer ageId = rs.getInt("age_id");
		String ageRange = rs.getString("age_range");
		String relatedTech = rs.getString("related_tech");
		Date updateDate = rs.getDate("update_date");
		return new SpecSearchResultPage(staffId, firstName, lastName,"", stateFlag, "", allExp, null, 
				langName, null, ageId, ageRange, relatedTech, updateDate);

	};
	
	/**
	 * スペックシートデータ全件取得.
	 * @return スペックシートデータ
	 */
	public List<SpecSearchResultPage> findAllSpec() {
		List<SpecSearchResultPage> specList = jdbcTemplate.query(FIND_ALL_SQL + " ORDER BY u.first_name",
				SPEC_ROW_MAPPER);
		return specList;
	}
	
	/**
	 * 条件に一致するユーザ情報を全て取得.
	 * @return
	 */
	public List<SpecSearchResultPage> searchAll(SpecSearchForm form, StringBuilder string){
		SqlParameterSource param = new BeanPropertySqlParameterSource(form);
		List<SpecSearchResultPage> specList = jdbcTemplate.query(
				FIND_ALL_SQL + string.toString(), param, SPEC_ROW_MAPPER);
		return specList;
	}

}
