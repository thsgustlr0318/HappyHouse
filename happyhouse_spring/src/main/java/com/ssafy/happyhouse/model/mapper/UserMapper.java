package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.dto.User;

public interface UserMapper {

	User select(String userid);

	int insert(User user);

	int modify(User user);

	int delete(String userid);

}
