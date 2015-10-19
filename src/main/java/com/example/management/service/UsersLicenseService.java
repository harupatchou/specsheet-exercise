package com.example.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domain.UsersLicense;
import com.example.management.repository.UsersLicenseRepository;

/**
 * 取得資格情報を取得するサービス。
 * @author takumi.sato
 *
 */
@Service
public class UsersLicenseService {
	@Autowired
	private UsersLicenseRepository usersLicenseRepository;
	
	/**
	 * ユーザが取得している資格をDBから取得する
	 * @return 取得資格情報
	 */
	public List<UsersLicense> findByStaffId(String staffId){
		List<UsersLicense> result = new ArrayList<UsersLicense>();
		result = usersLicenseRepository.findByStaffId(staffId);
		return result;
	}
	/**
	 * 資格情報を保存する
	 * @param usersLicenseList
	 * @param staffId
	 */
	@Transactional
	public void saveLicenseList(List<UsersLicense> usersLicenseList,String staffId){
		usersLicenseRepository.deleteUserLicenseByStaffId(staffId);
		usersLicenseRepository.save(usersLicenseList);
	}
}
