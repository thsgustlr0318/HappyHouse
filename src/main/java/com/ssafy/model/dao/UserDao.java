package com.ssafy.model.dao;

import com.ssafy.model.dto.User;

public interface UserDao {

	User select(String userid);
	int insert(User user);
	
}
