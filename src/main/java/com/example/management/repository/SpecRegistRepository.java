package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.form.SpecRegistLicenseForm;

@Transactional
@Repository
public class SpecRegistRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	
	/**
	 * スペックシート登録（資格）
	 * @author okamoto
	 * @param form
	 */
	public void insertUsersLicenseByStaffId(SpecRegistLicenseForm form){
		SqlParameterSource param = new BeanPropertySqlParameterSource(form);
		jdbcTemplate.update(
				"INSERT INTO users_license (staff_id , name , acquire_date) "
				+ "　VALUES ( :staffId , :name , :acquireDate); ",
				param);
	}
	
}
