package com.ssafy.happyhouse.model.service;

import java.util.Map;

import com.ssafy.happyhouse.model.dto.User;

public interface JwtService {
	String createToken(User selected, long time);
	Map<String, Object> getSubject(String token);
	boolean isUsable(String jwt) throws Exception;
}
