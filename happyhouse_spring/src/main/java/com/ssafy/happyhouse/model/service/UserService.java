package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.User;

public interface UserService {

	User select(String userid);
	int insert(User user);
	int modify(User user);
	int delete(String userid);
	
}
