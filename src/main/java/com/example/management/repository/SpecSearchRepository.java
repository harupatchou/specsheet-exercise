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

import com.example.management.domain.Spec;
import com.example.management.form.SpecSearchForm;

@Repository
@Transactional
public class SpecSearchRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public static final RowMapper<Spec> SPEC_ROW_MAPPER = (rs, i) -> {
		String staffId = rs.getString("staff_id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		Integer ageId = rs.getInt("age_id");
		Integer sex = rs.getInt("sex");
		Integer stateFlag = rs.getInt("state_flag");
		Integer allExp = rs.getInt("all_exp");
		String relatedTech = rs.getString("related_tech");
		String appeal = rs.getString("appeal");
		String nearestStation = rs.getString("nearest_station");
		Integer serverNetworkExp = rs.getInt("server_network_exp");
		Integer developmentExp = rs.getInt("development_exp");
		Integer seExp = rs.getInt("se_exp");
		Integer pgOperatorExp = rs.getInt("pg_operator_exp");
		String comment = rs.getString("comment");
		Date updateDate = rs.getDate("update_date");
		String updateName = rs.getString("update_name");
		return new Spec(staffId, firstName, lastName, ageId, sex, stateFlag, allExp, relatedTech ,appeal, nearestStation, 
				serverNetworkExp, developmentExp, seExp, pgOperatorExp, comment, updateDate, updateName);
	};
	
	/**
	 * スペックシートデータ全件取得.
	 * @return スペックシートデータ
	 */
	public List<Spec> findAllSpec() {
		List<Spec> specList = jdbcTemplate.query("SELECT s.staff_id, s.age_id, u.sex, u.name, s.state_flag, "
				+ "s.all_exp,ld.name AS lang_name,  a.age_range, "
				+ "s.related_tech,s.appeal,s.nearest_station, s.server_network_exp, s.development_exp, "
				+ "s.se_exp,s.pg_operator_exp,s.comment, s.update_date, s.update_name FROM users u "
				+ "LEFT OUTER JOIN spec s ON s.staff_id=u.staff_id "
				+ "LEFT OUTER JOIN age a ON s.age_id=a.id "
				+ "LEFT OUTER JOIN language_exp le ON s.staff_id=le.staff_id "
				+ "LEFT OUTER JOIN language_define ld ON le.no=ld.id ORDER BY u.name", SPEC_ROW_MAPPER);
		return specList;
	}
	
	/**
	 * 条件に一致するユーザ情報を全て取得.
	 * @return
	 */
	public List<Spec> searchAll(SpecSearchForm form, StringBuilder string){
		SqlParameterSource param = new BeanPropertySqlParameterSource(form);
		List<Spec> specList = jdbcTemplate.query(
				"SELECT s.staff_id, s.age_id, s.sex, u.name, s.state_flag, s.all_exp,ld.name AS lang_name,  a.age_range,"
				+ "s.related_tech,s.appeal,s.nearest_station, s.server_network_exp, s.development_exp, s.se_exp,s.pg_operator_exp,"
				+ "s.comment, s.update_date FROM spec s "
				+ "LEFT OUTER JOIN users u ON s.staff_id=u.staff_id "
				+ "LEFT OUTER JOIN age a ON s.age_id=a.id "
				+ "LEFT OUTER JOIN language_exp le ON s.staff_id=le.staff_id "
				+ "LEFT OUTER JOIN language_define ld ON le.no=ld.id " 
				+ string.toString(),param, SPEC_ROW_MAPPER);
		return specList;
	}

}
