package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.form.SpecRegistLicenseForm;
import com.example.management.form.SpecForm;

@Transactional
@Repository
public class SpecRegistRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	/**
	 * スペックを保存する
	 * @param form
	 * @return
	 */
	public Integer insertSpec(SpecForm form) {
		//保存データをマップへ詰め込む
		SqlParameterSource param = 
				new BeanPropertySqlParameterSource(form);
		return jdbcTemplate.
				update("INSERT INTO spec VALUES(:staffId, :ageFlag, :stateFlag, :allExp, :relatedTech, "
						+ ":appeal, :nearestStation, :comment, :allExpYear, :allExpMonth, :updateDate, :updateName)",param);
	}
	
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
	
	public void insertProjectOs(SpecForm form) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(form);
		jdbcTemplate.update(
				"INSERT INTO users_license (staff_id , project_no , os_exp_no) "
				+ "　VALUES ( :staffId , :projectNo , :acquireDate); ",
				param);
		
	}
	
}
