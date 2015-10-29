package com.example.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.management.domain.Project;

@Repository
public interface ProjectSelectRepository extends JpaRepository<Project,Integer> {
	
	@Query("SELECT p FROM Project p where p.staffId =:stId")
	public List<Project> findAllPro(@Param("stId") String staff_id);

}
