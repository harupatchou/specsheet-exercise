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
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.Spec;
import com.example.management.domain.Users;
import com.example.management.page.SpecDetailExpBreakdownPage;
import com.example.management.page.SpecDetailLanguagePage;
import com.example.management.page.SpecDetailLicensePage;
import com.example.management.page.SpecDetailOsPage;
import com.example.management.page.SpecDetailProcessPage;
import com.example.management.page.SpecDetailDevelopmentRelatedTechnologyPage;
import com.example.management.service.SpecDetailService;



/**
 * スペック関連リポジトリクラス.
 * @author okamoto
 *
 */
@Transactional
@Repository
public class SpecDetailRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<Spec> SPEC_ROW_MAPPER = (rs,i) -> {
		String staffId = rs.getString("staff_id"); //★もしかしたら↓の重複と関係してエラー出るかも
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
				nearestStation,comment,updateDate,updateName,null,null);
	};
	
	public static final RowMapper<Users> USERS_ROW_MAPPER = (rs,i) -> {
		String staffId = rs.getString("staff_id"); //★もしかしたら上の重複と関係してエラー出るかも
		String sex = rs.getString("sex");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String firstPhonetic = rs.getString("first_phonetic");
		String lastPhonetic = rs.getString("last_phonetic");
		Integer authorityId = rs.getInt("authority_id");
		String password = rs.getString("password");
		
		return new Users(staffId,sex,firstName,lastName,
				firstPhonetic,lastPhonetic,authorityId,password);
	};
	
	public static RowMapper<SpecDetailExpBreakdownPage> SPECDETAILEXPBREAKDOWNPAGE_ROW_MAPPER = (rs,i) -> {
		String staffId = rs.getString("staff_id");
		Integer expBreakdownId = rs.getInt("exp_breakdown_id");
		Integer monthOfExp = rs.getInt("month_of_exp");
		String breakdownName = rs.getString("breakdownName");
		
		return new SpecDetailExpBreakdownPage(staffId,expBreakdownId,monthOfExp,breakdownName,null,null);
	};
	
	public static RowMapper<SpecDetailLicensePage> SPECDETAILLICENSEPAGG_ROW_MAPPER = (rs,i) -> {
		String staffId = rs.getString("staff_id");
		Integer usersLicenceNo = rs.getInt("users_licence_no");
		String name = rs.getString("name");
		Date acquireDate = rs.getDate("acquire_date");
		
		return new SpecDetailLicensePage(staffId,usersLicenceNo,name,acquireDate);
	};
	

	
	public static RowMapper<String> SPECDETAILLANGUAGEPAGE_ROW_MAPPER = (rs,i) -> {
		String name = rs.getString("name");
	
		return new String(name);
	};
		
	public static RowMapper<String> SPECDETAILOS_ROW_MAPPER = (rs,i) -> {
		 String osName = rs.getString("os_name");
		
		return new String(osName);
	};

	public static RowMapper<String> SPECDETAILPROCESS_ROW_MAPPER = (rs,i) -> {
		 String name = rs.getString("name");
		
		return new String(name);
	};

	public static RowMapper<String> SPECDETAILSKILLSSUMMARYPAGE_ROW_MAPPER = (rs,i) -> {
		String other = rs.getString("other");
		
		return new String(other);
	};
	
	
	
	
	
	/**
	 * スペックシートデータ全件取得.
	 * @return スペックシートデータ全件
	 */
	public List<Spec> findAll(){
		List<Spec> specList = jdbcTemplate.query(
				"SELECT s.staff_id , u.name, s.age_id, s.sex, s.state_flag, s.all_exp,"
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
	 * スペックシートデータ1件取得(Spec).
	 * @param staffId スタッフID
	 * @return 1件のスペックシートデータ、ない場合はnullを返す
	 */
	public Spec findSpecByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		try{
			Spec spec = jdbcTemplate.queryForObject(
					"SELECT staff_id,age_id,state_flag,all_exp,related_tech,"
					+ " appeal,nearest_station,comment,update_date,update_name "
					+ "FROM spec s "
					+ "LEFT OUTER JOIN age a ON s.age_id=a.id "
					+ "WHERE s.staff_id=:staffId" ,
					param, 
					SPEC_ROW_MAPPER);
			return spec;
		}catch (DataAccessException eSpec){
			return null;
		}
	}
	
	/**
	 * スペックシートデータ1件取得(Users).
	 * @param staffId スタッフID
	 * @return 1件のスペックシートデータ、ない場合はnullを返す
	 */
	public Users findUsersByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		
		try{
			Users users = jdbcTemplate.queryForObject(
					"SELECT staff_id,sex,first_name,last_name,"
					+ " first_phonetic,last_phonetic,authority_id,password "
					+ " FROM users WHERE staff_id=:staffId",
					param,
					USERS_ROW_MAPPER);
			return users;
		}catch (DataAccessException eUsers){
			return null;
		}
	}
	
	/**
	 * スペックシート全体経験の内訳データ取得.
	 * @param staffId スタッフID
	 * @return　スペックシート全体経験の内訳
	 */
	public List<SpecDetailExpBreakdownPage> findExpBreakdownByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		try{
			List<SpecDetailExpBreakdownPage> specDetailExpBreakdownPageList = jdbcTemplate.query(
					"SELECT staff_id,exp_breakdown_id,month_of_exp,ebd.name AS breakdownName"
					+ " FROM exp_breakdown eb"
					+ " LEFT OUTER JOIN exp_breakdown_define ebd "
					+ " ON eb.exp_breakdown_id = ebd.id"
					+ " WHERE staff_id = :staffId",
					param,
					SPECDETAILEXPBREAKDOWNPAGE_ROW_MAPPER);
			return specDetailExpBreakdownPageList;
		}catch (DataAccessException eExpBreakdown){
			return null;
		}
	}
	
	/**
	 * スペックシート資格データ取得.
	 * @param staffId スタッフID
	 * @return　スペックシート資格データ
	 */
	public List<SpecDetailLicensePage> findLicenseByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		try{
			List<SpecDetailLicensePage> specDetailLicensePageList = jdbcTemplate.query(
					"SELECT staff_id, users_licence_no, name, acquire_date "
					+ " FROM users_license "
					+ " WHERE staff_id = :staffId", 
					param,
					SPECDETAILLICENSEPAGG_ROW_MAPPER);
			return specDetailLicensePageList;
		}catch (DataAccessException eLicense){
			return null;
		}
	}
	
	/**
	 * スペックシートスキル要約の言語取得.
	 * @param staffId スタッフID
	 * @return スキル要約の言語
	 */
	public List<String> findLanguageByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		try{
			List<String> specDetailLanguagePageList = jdbcTemplate.query(
					"SELECT DISTINCT name "
							+ " FROM language_exp le "
							+ " LEFT OUTER JOIN language_define ld ON le.language_id = ld.id "
							+ " WHERE staff_id = :staffId",
							param,
							SPECDETAILLANGUAGEPAGE_ROW_MAPPER);
			return specDetailLanguagePageList;
		}catch(DataAccessException eLanguage){
			return null;
		}
	}

	/**
	 * スペックシートスキル要約の環境(OS等)取得.
	 * @param staffId スタッフID
	 * @return スキル要約の環境(OS等)	
	 */
	public List<String> findOsByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
		try{
			List<String> specDetailOsPageList = jdbcTemplate.query(
					"SELECT DISTINCT os_name "
					+ " FROM os_exp oe "
					+ " LEFT OUTER JOIN os_define od ON oe.os_id = od.os_id "
					+ " WHERE staff_id = :staffId",
					param,
					SPECDETAILOS_ROW_MAPPER);
			return specDetailOsPageList;	
		}catch(DataAccessException eOs){
			return null;
		}
	}

	/**
	 * スペックシートスキル要約の開発関連技術取得.
	 * @param staffId スタッフID
	 * @return スキル要約の開発関連技術
	 */
	public List<String> findDevelopmentRelatedTechnologyByStaffId(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
	try{
		List<String> specDetailDevelopmentRelatedTechnologyList = jdbcTemplate.query(
				"SELECT DISTINCT other "
				+ "FROM project  "
				+ "WHERE staff_id = :staffId",
				param,
				SPECDETAILSKILLSSUMMARYPAGE_ROW_MAPPER);
		return specDetailDevelopmentRelatedTechnologyList;
	}catch(DataAccessException eDevelopmentRelatedTechnology){
		return null;
	}
}

	/**
	 * スペックシートスキル要約の業務範囲(工程)取得.
	 * @param staffId スタッフID
	 * @return スキル要約の業務範囲(工程)
	 */
	public List<String> findProcessByStaffId(String staffId){
	SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId);
	try{
		List<String> specDetailProcessPageList = jdbcTemplate.query(
				"SELECT DISTINCT name "
				+ "FROM project_process pp "
				+ "LEFT OUTER JOIN process_define pd ON pp.process_id = pd.id "
				+ "WHERE staff_id = :staffId",
				param,
				SPECDETAILPROCESS_ROW_MAPPER);
		return specDetailProcessPageList;
	}catch (DataAccessException eProcess){
		return null;
	}
}
	
	
	
}
