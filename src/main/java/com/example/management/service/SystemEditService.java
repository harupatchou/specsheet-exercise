package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.LanguageDefine;
import com.example.management.domain.OsDefine;
import com.example.management.repository.LanguageDefineRepository;
import com.example.management.repository.OsDefineRepository;

/**
 * システム情報を編集するサービス.
 * @author takayuki.honma
 *
 */
@Service
public class SystemEditService {
	@Autowired
	private LanguageDefineRepository languageDefineRepository;
	@Autowired
	private OsDefineRepository osDefineRepository;
	
	/**
	 * 言語一覧を取得.
	 * @return 言語一覧
	 */
	public List<LanguageDefine> findAllLanguage(){
		return languageDefineRepository.findAll();
	}
	
	/**
	 * OS一覧を取得.
	 * @return OS一覧
	 */
	public List<OsDefine> findAllOs(){
		return osDefineRepository.findAll();
	}
	
 	/**
 	 * 言語を登録.
 	 * @param name 言語名
 	 */
 	public void editLanguage(String name){
		LanguageDefine language = new LanguageDefine();
		List<LanguageDefine> languageList = languageDefineRepository.findAll();
		int id = languageList.size() + 1;
		language.setId(id);
		language.setName(name);
		languageDefineRepository.save(language);
	}
	
	/**
	 * OSを登録.
	 * @param osName OS名
	 */
	public void editOs(String osName){
		OsDefine os = new OsDefine();
		List<OsDefine> osList = osDefineRepository.findAll();
		int id = osList.size() + 1;
		os.setOsId(id);
		os.setOsName(osName);
		osDefineRepository.save(os);
	}
}
