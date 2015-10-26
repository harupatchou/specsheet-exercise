package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
