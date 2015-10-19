package com.example.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.domain.Spec;
import com.example.management.repository.UserRepository;

@Service
public class UserSearchService {
	@Autowired
	private UserRepository userRepository;
	
	public List<Spec> findAll() {
		return userRepository.findAll();
	}

}
