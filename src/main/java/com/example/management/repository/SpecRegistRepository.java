package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.form.SpecForm;
import com.example.management.form.SpecRegistLicenseForm;

@Transactional
@Repository
public class SpecRegistRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private OsSearchRepository osSearchRepository;
	@Autowired
	private LanguageSearchRepository languageSearchRepository;
	@Autowired
	private ProcessSearchRepository processSearchRepository;
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
				+ "VALUES (:staffId,:lisenceName,:acquireDate) ",
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
	
	/**
	 * プロジェクトOSの登録
	 * @param form
	 */
	public void insertProjectOs(SpecForm form) {
		SqlParameterSource param = new MapSqlParameterSource();
		String[] proNo= form.getProjectNo().split(",");
		String[] osList= form.getOs().split(",");
		for (int i = 0; i < proNo.length; ++i) {
			Integer no = Integer.parseInt(proNo[i]);
			for (String os : osList[i].split("/")) {
				param = new MapSqlParameterSource()
						.addValue("staffId", form.getStaffId())
						.addValue("projectNo", no)
						.addValue("osExpNo", osSearchRepository.findIdByName(os));
				jdbcTemplate.update("INSERT INTO project_os(staff_id, project_no, os_exp_no) "
						+ "VALUES (:staffId, :projectNo, :osExpNo);",
						param);

			}
		}
	}
	
	/**
	 * プロジェクト言語の登録
	 * @param form
	 */
	public void insertProjectLanguage(SpecForm form) {
		SqlParameterSource param = new MapSqlParameterSource();
		String[] proNo= form.getProjectNo().split(",");
		String[] langList= form.getLang().split(",");
		for (int i = 0; i < proNo.length; ++i) {
			Integer no = Integer.parseInt(proNo[i]);
			for (String lang : langList[i].split("/")) {
				param = new MapSqlParameterSource()
						.addValue("staffId", form.getStaffId())
						.addValue("projectNo", no)
						.addValue("langExpNo", languageSearchRepository.findIdByName(lang));
				jdbcTemplate.update("INSERT INTO project_language(staff_id, project_no, language_exp_no) "
						+ "VALUES (:staffId, :projectNo, :langExpNo);",
						param);

			}
		}
	}
	
	/**
	 * プロジェクト工程の登録
	 * @param form
	 */
	public void insertProjectProcess(SpecForm form) {
		SqlParameterSource param = new MapSqlParameterSource();
		String[] proNo= form.getProjectNo().split(",");
		String[] processList= form.getProcess().split(",");
		for (int i = 0; i < proNo.length; ++i) {
			Integer no = Integer.parseInt(proNo[i]);
			for (String process : processList[i].split("/")) {
				param = new MapSqlParameterSource()
						.addValue("staffId", form.getStaffId())
						.addValue("projectNo", no)
						.addValue("processExpNo", processSearchRepository.findIdByName(process));
				jdbcTemplate.update("INSERT INTO project_process(staff_id, project_no, process_id) "
						+ "VALUES (:staffId, :projectNo, :processExpNo);",
						param);

			}
		}
	}
	
	/**
	 * スキル要約の登録
	 * @param form
	 */
	public void insertSkill(SpecForm form) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(form);
		jdbcTemplate.update("INSERT INTO project_process(staff_id, project_no, process_id) "
				+ "VALUES (:staffId, :projectNo, :processExpNo);",
				param);
	}
}

