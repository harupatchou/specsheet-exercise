package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.management.domain.OsDefine;
import com.example.management.repository.OsDefineRepository;
import com.example.management.repository.OsSearchRepository;


/**
 * スペックシート詳細表示をするサービス.
 * @author takayuki.honma
 *
 */
@Service
public class OsDefineService {
	@Autowired
	private OsDefineRepository osDefineRepository;
	@Autowired
	private OsSearchRepository osSearchRepository;
	
	public List<OsDefine> findAll() {
		return osDefineRepository.findAll();
	}
	
	/**
	 * 降順でデータを取得
	 * @return
	 */
	public List<OsDefine> findAllOrderByIdDesc(){
		Sort sort = new Sort(Sort.Direction.DESC,"osId");
		return osDefineRepository.findAll(sort);
	}
	
	/**
	 * OS名からIDを取得
	 * @param name
	 * @return　ID
	 */
	public Integer findIdByName(String name) {
		return osSearchRepository.findIdByName(name);
	}
}
