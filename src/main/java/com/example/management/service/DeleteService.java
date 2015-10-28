package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.repository.DeleteRepository;
/**
 * 削除用サービス.
 * @author ueno
 */
@Service
public class DeleteService {
	@Autowired
	private DeleteRepository deleteRepository;
	
	/**
	 * スペック情報削除
	 * @author ueno
	 */
	public void delete(String staffId){
		deleteRepository.deleteAll(staffId);
	}
}
