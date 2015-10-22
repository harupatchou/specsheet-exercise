package com.example.management.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.Project;
import com.example.management.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	protected ProjectRepository projectRepository;
	
	/**
	 * spec情報取得
	 * @return list
	 */

	public void insertProject(Project project) {
		projectRepository.insertProject(project);
	}

}
