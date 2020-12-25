package com.udacity.jwdnd.course1.cloudstorage.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entity.UsersEntity;
import com.udacity.jwdnd.course1.cloudstorage.repositories.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	private UsersRepository usersRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersEntity user = usersRepository.findByUsername(username);
		if(user==null) {
			logger.info("UserDetailsServiceImpl::loadUserByUsername() -> User Not Found: "+username);
			throw new UsernameNotFoundException("Entered Information not Valid");
		}
		// Everyone gets user
		final List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        logger.info("UserDetailsServiceImpl::loadUserByUsername() -> Welcome: "+username + ": with role: "+roles);
		return new User(user.getUsername(),user.getPassword(), roles);
		
	}
}
