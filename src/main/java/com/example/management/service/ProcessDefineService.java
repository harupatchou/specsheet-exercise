package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.management.domain.ProcessDefine;
import com.example.management.repository.ProcessDefineRepository;


/**
 * スペックシート詳細表示をするサービス.
 * @author takayuki.honma
 *
 */
@Service
public class ProcessDefineService {
	@Autowired
	private ProcessDefineRepository processDefineRepository;
	
	
	public List<ProcessDefine> findAll() {
		return processDefineRepository.findAll();
	}
	/**
	 * 降順でデータを取得
	 * @return
	 */
	public List<ProcessDefine> findAllOrderByIdDesc(){
		Sort sort = new Sort(Sort.Direction.DESC,"processId");
		return processDefineRepository.findAll(sort);
	}
}
