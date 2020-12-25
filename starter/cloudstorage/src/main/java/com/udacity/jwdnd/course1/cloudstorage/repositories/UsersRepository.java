package com.udacity.jwdnd.course1.cloudstorage.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udacity.jwdnd.course1.cloudstorage.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer>{
	UsersEntity findByUsername(String username);
	
}
