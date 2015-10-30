package com.example.management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.OsDefine;
import com.example.management.domain.OsExp;

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
	
	public static final RowMapper<OsExp> OSEXP_ROW_MAPPER = (rs, i) -> {
		String staffId = rs.getString("staff_id");
		Integer no = rs.getInt("no");
		Integer osId = rs.getInt("os_id");
		String other = rs.getString("other");
		Integer monthOfExp = rs.getInt("month_of_exp");
		return new OsExp(staffId,no,osId,other,monthOfExp);
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
	
	/**
	 * 経験OS情報取得.
	 * @author ueno
	 * @return 経験OS情報
	 */
	public List<OsExp> findByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		List<OsExp> osExpList = jdbcTemplate.query("SELECT * FROM os_exp WHERE staff_id=:staffId", param, OSEXP_ROW_MAPPER);
		return osExpList; 
	}
	
	/**
	 * IDからOS名を取得.
	 * @author ueno
	 * @return OS名
	 */
	public String findbyId(Integer osId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("osId", osId);
		try{
			OsDefine osName = jdbcTemplate.queryForObject("SELECT * FROM os_define WHERE os_id=:osId", param, OS_ROW_MAPPER);
			return osName.getOsName();
		}catch(DataAccessException e){
			return null;
		}
	}
	

}
