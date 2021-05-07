package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.dto.User;

public interface UserDao {

	User select(String userid);
	int insert(User user);
	
}
