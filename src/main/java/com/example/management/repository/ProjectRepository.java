package com.example.management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.management.domain.Project;

@Repository
public class ProjectRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
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
