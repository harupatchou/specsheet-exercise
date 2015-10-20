package com.example.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.management.domain.Spec;



/**
 * スペック関連リポジトリクラス.
 * @author okamoto
 *
 */
@Repository
public class SpecDetailRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<Spec> SPEC_ROW_MAPPER = (rs,i) -> {
		String staffId = rs.getString("staff_id");
		Integer ageId = rs.getInt("age_id");
		Integer stateFlag = rs.getInt("state_flag");
		Integer allExp = rs.getInt("all_exp");
		String relatedTech = rs.getString("related_tech");
		String appeal = rs.getString("appeal");
		String nearestStation = rs.getString("nearest_station");
		String comment = rs.getString("comment");
		Date updateDate = rs.getDate("update_date");
		String updateName = rs.getString("update_name");
		return new Spec(staffId,ageId,stateFlag,allExp,relatedTech,appeal,
				nearestStation,comment,updateDate,updateName);
	};
	
	/**
	 * スペックシートデータ全件取得.
	 * @return スペックシートデータ全件
	 */
	public List<Spec> findAll(){
		List<Spec> specList = jdbcTemplate.query(
				"SELECT s.staff_id, u.name, s.age_id, s.sex, s.state_flag, s.all_exp,"
				+ " ld.name AS lang_name, a.age_range, s.comment, s.update_date "
				+ "FROM spec s "
				+ "LEFT OUTER JOIN users u ON s.staff_id=u.staff_id "
				+ "LEFT OUTER JOIN age a ON s.age_id=a.id "
				+ "LEFT OUTER JOIN language_exp le ON s.staff_id=le.staff_id "
				+ "LEFT OUTER JOIN language_define ld ON le.no=ld.id "
				+ "ORDER BY u.name" ,
				SPEC_ROW_MAPPER);
		return specList;
	}

	/**
	 * スペックシートデータ1件取得.
	 * @param staffId スタッフID
	 * @return 1件のスペックシートデータ、ない場合はnullを返す
	 */
	public Spec findByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staff_id", staffId);
		try{
			Spec spec = jdbcTemplate.queryForObject(
					"SELECT * FROM spec s "
					+ "LEFT OUTER JOIN age a ON s.age_id=a.id "
					+ "WHERE s.staff_id = :staff_id" ,
					param, 
					SPEC_ROW_MAPPER);
			return spec;
		}catch (DataAccessException e){
			return null;
		}
	}
	
}
