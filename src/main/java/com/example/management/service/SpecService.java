package com.example.management.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.Spec;
import com.example.management.repository.SpecRepository;

@Service
public class SpecService {
	
	@Autowired
	protected SpecRepository specRepository;
	
	/**
	 * spec情報取得
	 * @return list
	 */
	public Spec selectByStaffId(String staffId) {
		
		//個人の情報の取得
		Spec spec =  specRepository.findOne(staffId);
		
		return spec;
	}

}
