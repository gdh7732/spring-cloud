package com.service;


import com.domain.User;

public interface UserService {
	
	User getUser(String username, String pass);
	
	void save(User user);
	
	boolean exists(String username);
	
}
