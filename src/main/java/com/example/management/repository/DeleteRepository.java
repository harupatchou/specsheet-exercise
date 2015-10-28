package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * 削除用リポジトリ
 * @author ueno
 */
@Transactional
@Repository
public class DeleteRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * スペック情報全削除
	 * @author ueno
	 */
	public void deleteAll(String staffId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("staffId",staffId);
		//スペックテーブル削除
		jdbcTemplate.update("DELETE FROM spec WHERE staff_id=:staffId", param);
		//経験内訳(スタッフID欄)
		jdbcTemplate.update("DELETE FROM exp_breakdown WHERE staff_id=:staffId", param);
		//言語経験(スキル要約欄)
		jdbcTemplate.update("DELETE FROM language_exp WHERE staff_id=:staffId", param);
		//OS経験(スキル要約欄)
		jdbcTemplate.update("DELETE FROM os_exp WHERE staff_id=:staffId", param);
		//プロジェクトテーブル削除
		jdbcTemplate.update("DELETE FROM project WHERE staff_id=:staffId", param);
		//開発経験言語
		jdbcTemplate.update("DELETE FROM project_language WHERE staff_id=:staffId", param);
		//開発経験OS
		jdbcTemplate.update("DELETE FROM project_os WHERE staff_id=:staffId", param);
		//開発経験担当工程
		jdbcTemplate.update("DELETE FROM project_process WHERE staff_id=:staffId", param);
		//資格
		jdbcTemplate.update("DELETE FROM users_license WHERE staff_id=:staffId", param);
	}
}
