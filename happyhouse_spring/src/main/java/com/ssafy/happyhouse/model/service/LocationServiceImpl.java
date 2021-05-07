package com.ssafy.happyhouse.model.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Location;
import com.ssafy.happyhouse.model.mapper.LocationMapper;

@Service
public class LocationServiceImpl implements LocationService {

	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;

	public Location getUserInfo(String id) {
		return sqlSession.getMapper(LocationMapper.class).getUserInfo(id);
		//return LocationDaoImpl.getLocationDao().getUserInfo(id);
	}

}
