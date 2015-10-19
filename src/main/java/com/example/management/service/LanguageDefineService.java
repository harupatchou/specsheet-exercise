package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.LanguageDefine;
import com.example.management.repository.LanguageDefineRepository;

/**
 * 言語定義テーブルに関するサービス.
 * @author takayuki.honma
 *
 */
@Service
public class LanguageDefineService {
	@Autowired
	private LanguageDefineRepository languageDefineRepository;
	
	public List<LanguageDefine> findAll() {
		return languageDefineRepository.findAll();
	}
}
