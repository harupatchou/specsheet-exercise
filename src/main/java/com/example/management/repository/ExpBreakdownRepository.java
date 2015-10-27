package com.example.management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.form.SpecForm;
import com.example.management.page.ExpBreakdownPage;

@Transactional
@Repository
public class ExpBreakdownRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<ExpBreakdownPage> BREAKDOWN_ROW_MAPPER = (rs,i) -> {
		String staffId = rs.getString("staff_id");
		Integer expBreakdownId = rs.getInt("exp_breakdown_id");
		Integer monthOfExp = rs.getInt("month_of_exp");
		String name = rs.getString("name");
		
		return new ExpBreakdownPage(staffId, expBreakdownId, monthOfExp, name, null, null, null, null
				, null, null, null, null);
	};
	
	/**
	 * 経験内訳1件取得(ExpBreakdownPage).
	 * @param staffId スタッフID
	 * @return 1件の経験内訳、ない場合はnullを返す
	 */
	public List<ExpBreakdownPage> findExpBreakdownByStaffId(String staffId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
//		try{
			List<ExpBreakdownPage> expBreakdown = jdbcTemplate.query(
					"SELECT staff_id, month_of_exp, name, exp_breakdown_id FROM exp_breakdown e "
					+ "LEFT OUTER JOIN exp_breakdown_define ed ON e.exp_breakdown_id=ed.id "
					+ "WHERE e.staff_id=:staffId" ,
					param, 
					BREAKDOWN_ROW_MAPPER);
			return expBreakdown;
//		}catch (DataAccessException e){
//			return null;
//		}
	}
	
	/**
	 * 経験内訳の登録
	 * @param form
	 */
	public void insertBreakdown(SpecForm form) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(form);
		if (form.getServerNetworkExpMonth() != 0 || form.getServerNetworkExpYear() != 0) {
			form.setMonthOfExp(form.getServerNetworkExpMonth() + form.getServerNetworkExpYear() * 12);
			param = new BeanPropertySqlParameterSource(form);
			jdbcTemplate.update("INSERT INTO exp_breakdown VALUES (:staffId, '1', :monthOfExp)", param);
		}
		if (form.getDevelopmentExpMonth() != 0 || form.getDevelopmentExpYear() != 0) {
			form.setMonthOfExp(form.getDevelopmentExpMonth() + form.getDevelopmentExpYear() * 12);
			param = new BeanPropertySqlParameterSource(form);
			jdbcTemplate.update("INSERT INTO exp_breakdown VALUES (:staffId, '2', :monthOfExp)", param);
		}
		if (form.getSeExpMonth() != 0 || form.getSeExpYear() != 0) {
			form.setMonthOfExp(form.getSeExpMonth() + form.getSeExpYear() * 12);
			param = new BeanPropertySqlParameterSource(form);
			jdbcTemplate.update("INSERT INTO exp_breakdown VALUES (:staffId, '3', :monthOfExp)", param);
		}
		if (form.getPgOperatorExpMonth() != 0 || form.getPgOperatorExpYear() != 0) {
			form.setMonthOfExp(form.getPgOperatorExpMonth() + form.getPgOperatorExpYear() * 12);
			param = new BeanPropertySqlParameterSource(form);
			jdbcTemplate.update("INSERT INTO exp_breakdown VALUES (:staffId, '4', :monthOfExp)", param);
		}
	}
	

}
