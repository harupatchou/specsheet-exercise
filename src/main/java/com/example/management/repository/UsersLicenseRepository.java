package com.example.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.management.domain.UsersLicense;
import com.example.management.keyId.UsersLicenseKeyId;

@Repository
public interface UsersLicenseRepository extends JpaRepository<UsersLicense,UsersLicenseKeyId>{
	/**
	 * 特定のユーザの資格情報を取得する。
	 * @param staffId
	 * @return
	 */
	@Query("SELECT ul FROM UsersLicense ul WHERE ul.staffId = :staffId ORDER BY ul.acquireDate DESC")
	public List<UsersLicense> findByStaffId(@Param("staffId") String staffId);
	/**
	 * 現在の資格の保有数を取得する
	 * @param staffId
	 * @return
	 */
	@Query("SELECT MAX(ul.usersLicenceNo) FROM UsersLicense ul WHERE ul.staffId=:staffId")
	public Integer getCurrentUsersLicenseNo(@Param("staffId") String staffId);
	
	/**
	 * 対象ユーザの資格を削除する
	 * @param staffId
	 */
	@Modifying
	@Query("DELETE FROM UsersLicense ul WHERE ul.staffId=:staffId")
	public void deleteUserLicenseByStaffId(@Param("staffId") String staffId);
	
}
