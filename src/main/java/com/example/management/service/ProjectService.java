package com.example.management.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.Project;
import com.example.management.repository.ProjectRepository;
import com.example.management.repository.ProjectSelectRepository;

@Service
public class ProjectService {
	
	@Autowired
	protected ProjectRepository projectRepository;
	
	@Autowired
	protected ProjectSelectRepository projectSelectRepository;
	
	/**
	 * spec情報取得
	 * @return list
	 */

	public void insertProject(Project project) {
		projectRepository.insertProject(project);
	}

	public List<Project> selectByStaffId(String staffId) {
		//情報取得
		List<Project> projectList = projectSelectRepository.findAllPro(staffId);
		return projectList;
	}

}
