package com.arms.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arms.domain.entity.User;
import com.arms.domain.repository.UserRepository;

@Service
public class UserAuthenticationService implements UserAccountService, UserDetailsService{

	@Autowired
	UserRepository repository;

	@Override
	public User findOneByEmail(String username) {
		return repository.findOneByEmail(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new AccountUserDetails(findOneByEmail(username));
	}


	
}
