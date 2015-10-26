package com.example.management.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.Spec;
import com.example.management.page.ExpBreakdownPage;

@Transactional
@Repository
public class ExpBreakdownRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<ExpBreakdownPage> BREAKDOWN_ROW_MAPPER = (rs,i) -> {
		String staffId = rs.getString("staff_id");
		Integer monthOfExp = rs.getInt("month_of_exp");
		String name = rs.getString("name");
		
		return new ExpBreakdownPage(staffId, null, monthOfExp, name);
	};
	
	/**
	 * スペックシートデータ1件取得(Spec).
	 * @param staffId スタッフID
	 * @return 1件のスペックシートデータ、ない場合はnullを返す
	 */
	public ExpBreakdownPage findExpBreakdownByStaffId(String staffId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		try{
			ExpBreakdownPage expBreakdown = jdbcTemplate.queryForObject(
					"SELECT staff_id, month_of_exp, name FROM exp_breakdown e "
					+ "LEFT OUTER JOIN exp_breakdown_define ed ON e.exp_breakdown_id=ed.id "
					+ "WHERE e.staff_id=:staffId" ,
					param, 
					BREAKDOWN_ROW_MAPPER);
			return expBreakdown;
		}catch (DataAccessException e){
			return null;
		}
	}
	

}
