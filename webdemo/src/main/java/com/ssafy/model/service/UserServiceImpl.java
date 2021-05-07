package com.ssafy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.UserDao;
import com.ssafy.model.dto.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userdao;

	@Override
	public User select(String userid) {
		// TODO Auto-generated method stub
		return userdao.select(userid);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userdao.insert(user);
	}
	
}
