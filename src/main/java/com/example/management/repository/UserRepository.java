package com.example.management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.Users;
import com.example.management.form.UserEditForm;
import com.example.management.form.UserRegistForm;

/**
 * ユーザー関連リポジトリクラス.
 * @author ueno
 */
@Transactional
@Repository
public class UserRepository {
	public static final RowMapper<Users> USER_ROW_MAPPER = (rs, i) -> {
		String staffId = rs.getString("staff_id");
		String sex = rs.getString("sex");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String firstPhonetic = rs.getString("first_phonetic");
		String lastPhonetic = rs.getString("last_phonetic");
		Integer authorityId = rs.getInt("authority_id");
		String password = rs.getString("password");
		return new Users(staffId,sex,firstName,lastName,firstPhonetic,lastPhonetic,authorityId,password);
	};
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * ユーザー情報全件取得.
	 * @author ueno
	 * @return ユーザー情報一覧
	 */
	public List<Users> findAll(){
		List<Users> users = jdbcTemplate.query("SELECT * FROM users", USER_ROW_MAPPER);
		return users;
	}
	
	/**
	 * staffId値のユーザー情報取得
	 * @author ueno
	 * @return　ユーザー情報
	 */
	public Users findOne(String staffId){
		try{
			SqlParameterSource param = new MapSqlParameterSource().addValue("staff_id", staffId);
			Users user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE staff_id=:staff_id", param, USER_ROW_MAPPER);
			return user;
		}catch(DataAccessException e){
			return null;
		}
	}
	
	/**
	 * staffId・passwordと一致するユーザー情報取得.
	 * @author ueno
	 * @return ユーザー情報
	 */
	public Users findByStaffIdAndPassword(String staffId, String password){
		try{
			SqlParameterSource param = new MapSqlParameterSource().addValue("staffId", staffId).addValue("password", password);
			Users user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE staff_id=:staffId AND password=:password", param, USER_ROW_MAPPER);
			return user;
		}catch(DataAccessException e){
			return null;
		}
	}
	
	/**
	 * ユーザー情報新規登録.
	 * @author ueno
	 */
	public void insert(UserRegistForm form){
		SqlParameterSource param = new BeanPropertySqlParameterSource(form);
		jdbcTemplate.update("INSERT INTO users(staff_id, sex, first_name, last_name, first_phonetic, last_phonetic, authority_id, password)"
				+ " values(:staffId, :sex, :firstName, :lastName, :firstPhonetic, :lastPhonetic, :authorityId,'boost2000') ", param);
	}
	
	/**
	 * ユーザー情報更新.
	 * @author ueno
	 */
	public void update(UserEditForm form){
		SqlParameterSource param = new BeanPropertySqlParameterSource(form);
		if(form.getNewPassword() != ""){
			jdbcTemplate.update("UPDATE users SET staff_id=:staffId, sex=:sex, first_name=:firstName, last_name=:lastName, first_Phonetic=:firstPhonetic,"
					+ "last_Phonetic=:lastPhonetic, authority_id=:authorityId, password=:newPassword WHERE staff_id=:tempStaffId", param);			
		} else {
			jdbcTemplate.update("UPDATE users SET staff_id=:staffId, sex=:sex, first_name=:firstName, last_name=:lastName, first_Phonetic=:firstPhonetic,"
					+ "last_Phonetic=:lastPhonetic, authority_id=:authorityId WHERE staff_id=:tempStaffId", param);	
		}
	}
}
