package com.ssafy.happyhouse.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public User select(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).select(userid);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).insert(user);
	}

	@Override
	public int modify(User user) {
		return sqlSession.getMapper(UserMapper.class).modify(user);
	}

	@Override
	public int delete(User user) {
		return sqlSession.getMapper(UserMapper.class).delete(user);
	}

}
