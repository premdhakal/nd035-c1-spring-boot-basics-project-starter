package com.udacity.jwdnd.course1.cloudstorage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entity.UsersEntity;
import com.udacity.jwdnd.course1.cloudstorage.repositories.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UsersEntity findByUsername(String userName) {
		return usersRepository.findByUsername(userName) ;
	}
	
}