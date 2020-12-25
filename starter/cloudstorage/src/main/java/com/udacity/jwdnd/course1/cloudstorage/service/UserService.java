package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.entity.UsersEntity;

public interface UserService{
	UsersEntity findByUsername(String userName);
}