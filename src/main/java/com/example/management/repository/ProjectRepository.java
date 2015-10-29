package com.example.management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.management.domain.Project;
import com.example.management.page.ProjectLanguagePage;
import com.example.management.page.ProjectOsPage;
import com.example.management.page.ProjectProcessPage;

@Repository
public class ProjectRepository {
	
	public static final RowMapper<ProjectLanguagePage> ProjectLangPage_RM = (rs, i) -> {
		Integer no = rs.getInt("no");
		String langName = rs.getString("name");
		return new ProjectLanguagePage(no,langName);
	};
	
	public static final RowMapper<ProjectOsPage> ProjectOsPage_RM = (rs, i) -> {
		Integer no = rs.getInt("no");
		String osName = rs.getString("os_name");
		return new ProjectOsPage(no,osName);
	};
	
	public static final RowMapper<ProjectProcessPage> ProjectProcessPage_RM = (rs, i) -> {
		Integer no = rs.getInt("no");
		String processName = rs.getString("name");
		return new ProjectProcessPage(no,processName);
	};
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * staffId値のプロジェクト内の言語情報取得
	 * @author kuro
	 * @return　言語情報情報
	 */
	public List<ProjectOsPage> findProjectOs(String staffId){
			SqlParameterSource param = new MapSqlParameterSource().addValue("staff_id", staffId);
			List<ProjectOsPage> osList = jdbcTemplate.query("select p.no,(select od.os_name from os_define od where od.os_id = po.os_exp_no) "
					+ "from project p inner join project_os po on p.no = po.project_no "
					+ "where p.staff_id =:staff_id order by p.no"
					, param, ProjectOsPage_RM);
			return osList;
	}
	
	/**
	 * staffId値のプロジェクト内の言語情報取得
	 * @author kuro
	 * @return　言語情報情報
	 */
	public List<ProjectLanguagePage> findProjectLang(String staffId){
			SqlParameterSource param = new MapSqlParameterSource().addValue("staff_id", staffId);
			List<ProjectLanguagePage> langList = jdbcTemplate.query("select p.no,(select ld.name from language_define ld where ld.id = pl.language_exp_no) "
					+ "from project p inner join project_language pl on p.no = pl.project_no "
					+ "where p.staff_id =:staff_id order by p.no"
					, param, ProjectLangPage_RM);
			return langList;
	}
	
	/**
	 * staffId値のプロジェクト内の言語情報取得
	 * @author kuro
	 * @return　言語情報情報
	 */
	public List<ProjectProcessPage> findProjectProcess(String staffId){
			SqlParameterSource param = new MapSqlParameterSource().addValue("staff_id", staffId);
			List<ProjectProcessPage> processList = jdbcTemplate.query("select p.no,(select pd.name from process_define pd where pd.id = pp.process_id) "
					+ "from project p inner join project_process pp on p.no = pp.project_no "
					+ "where p.staff_id =:staff_id order by p.no"
					, param, ProjectProcessPage_RM);
			return processList;
	}
	
	/**
	 * 開発経験を保存する
	 * @param project
	 * @return
	 */
	public Integer insertProject(Project project){
		//保存データをマップへ詰め込む
		SqlParameterSource param = 
				new BeanPropertySqlParameterSource(project);
		return jdbcTemplate.
				update("INSERT INTO project VALUES(:staffId,:no,:startDate,:finishDate,:overview,:teamNum,:allNum,:role,:content,:other)",param);
	}

}
