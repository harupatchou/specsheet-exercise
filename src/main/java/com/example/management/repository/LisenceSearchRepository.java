//package com.example.management.repository;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.management.page.SpecDetailLicensePage;
//
//@Transactional
//@Repository
//public class LisenceSearchRepository {
//	@Autowired
//	private NamedParameterJdbcTemplate jdbcTemplate;
//	
//	private static final RowMapper<SpecDetailLicensePage> SPECDETAILLICENSEPAGE_ROW_MAPPER = (rs,i) -> {
//		 String staffId = rs.getString("staff_id");
//		 Integer usersLicenceNo = rs.getInt("users_licence_no");
//		 String name = rs.getString("name");
//		 Date acquireDate = rs.getDate("acquire_date");
//		
//		return new SpecDetailLicensePage(staffId,usersLicenceNo,name,acquireDate);
//	};
//	
//	/**
//	 * 所有している資格情報を取得.
//	 * @param staffId
//	 * @author okamoto
//	 * @return 所有している資格情報
//	 */
//	public List<SpecDetailLicensePage> licensefindByStaffId(String staffId){
//		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
//		List<SpecDetailLicensePage> page = jdbcTemplate.query(
//				"SELECT staff_id, users_licence_no, name, acquire_date FROM users_license "
//				+ " WHERE staff_id = :staffId ",
//				param,
//				SPECDETAILLICENSEPAGE_ROW_MAPPER);
//		
//		return page;
//	}
//	
//}
