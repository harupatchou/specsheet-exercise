package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.management.domain.OsDefine;
import com.example.management.repository.OsDefineRepository;


/**
 * スペックシート詳細表示をするサービス.
 * @author takayuki.honma
 *
 */
@Service
public class OsDefineService {
	@Autowired
	private OsDefineRepository osDefineRepository;
	
	
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
}
