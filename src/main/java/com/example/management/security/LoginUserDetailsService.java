package com.example.management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.management.domain.User;
import com.example.management.repository.UserRepository;
@Service
public class LoginUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String staffId) throws UsernameNotFoundException {
		User user = userRepository.findOne(staffId);

		if (user == null) {
			throw new UsernameNotFoundException("The requested user is not found.");
		}
		if (user.getAuthorityId() == 1) {
			return new UserLoginDetails(user);
		} else if (user.getAuthorityId() == 2) {	
			return new AdminUserLoginDetails(user);
		} else {
			return null;
		}
	}
}
