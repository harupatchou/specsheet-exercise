package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.ProcessDefine;

@Transactional
@Repository
public class ProcessSearchRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<ProcessDefine> PROCESS_ROW_MAPPER = (rs,i) -> {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		
		return new ProcessDefine(id, name);
	};
	
	/**
	 * 経験内訳1件取得(ExpBreakdownPage).
	 * @param staffId スタッフID
	 * @return 1件の経験内訳、ない場合は0を返す
	 */
	public Integer findIdByName(String processName) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("processName", processName);
//		try{
		ProcessDefine process = jdbcTemplate.queryForObject(
					"SELECT id, name FROM process_define WHERE name=:processName", param, 
					PROCESS_ROW_MAPPER);
		if (process == null) {
			return 1;
		}
			return process.getId();
//		}catch (DataAccessException e){
//			return null;
//		}
	}

}
