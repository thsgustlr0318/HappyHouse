package com.ssafy.model.service;

import com.ssafy.model.dto.User;

public interface UserService {

	User select(String userid);
	int insert(User user);
	
}
