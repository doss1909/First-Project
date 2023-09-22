package com.das.service;

import com.das.entity.User;

public interface UserService {

	User saveUser(User user);
	
	User findByEmail(String Email);
	
}
