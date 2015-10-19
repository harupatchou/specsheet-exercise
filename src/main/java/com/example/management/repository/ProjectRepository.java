package com.example.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.management.domain.Project;
import com.example.management.keyId.ProjectKeyId;

@Repository
public interface ProjectRepository extends JpaRepository<Project,ProjectKeyId>{
	/**
	 * 対象スタッフのプロジェクト経験を取得する
	 * @param staffId
	 * @return 対象スタッフのプロジェクト経験リスト
	 */
	public List<Project> findByStaffIdOrderByNoAsc(String staffId);
	/**
	 * 対象ユーザのプロジェクト経験を削除する
	 * @param staffId
	 */
	@Modifying
	@Query("DELETE FROM Project p WHERE p.staffId = :staffId")
	public void deleteByStaffId(@Param("staffId")String staffId);
}
