package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.OsDefine;

@Transactional
@Repository
public class OsSearchRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<OsDefine> OS_ROW_MAPPER = (rs,i) -> {
		Integer osId = rs.getInt("os_id");
		String osName = rs.getString("os_name");
		
		return new OsDefine(osId, osName);
	};
	
	/**
	 * 経験内訳1件取得(ExpBreakdownPage).
	 * @param staffId スタッフID
	 * @return 1件の経験内訳、ない場合はnullを返す
	 */
	public Integer findIdByName(String osName) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("osName", osName);
//		try{
		OsDefine expBreakdown = jdbcTemplate.queryForObject(
					"SELECT os_id, os_name FROM os_define WHERE os_name=:osName", param, 
					OS_ROW_MAPPER);
			return expBreakdown.getOsId();
//		}catch (DataAccessException e){
//			return null;
//		}
	}

}
