package com.ssafy.happyhouse.model.service;

public interface JwtService {
	String createToken(String subject, long time);
	String getSubject(String token);
	boolean isUsable(String jwt) throws Exception;
}
