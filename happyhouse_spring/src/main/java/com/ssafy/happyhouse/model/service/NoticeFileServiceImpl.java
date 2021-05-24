package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.NoticeFileDto;
import com.ssafy.happyhouse.model.mapper.NoticeFileMapper;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Service
public class NoticeFileServiceImpl implements NoticeFileService {

	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int uploadFile(NoticeFileDto file) {
		return sqlSession.getMapper(NoticeFileMapper.class).uploadFile(file);
	}

	@Override
	public List<NoticeFileDto> getFileList(String no) {
		return sqlSession.getMapper(NoticeFileMapper.class).getFileList(no);
	}

	@Override
	public int deleteNotice(String fileno) {
		return sqlSession.getMapper(NoticeFileMapper.class).deleteFile(fileno);
	}

	@Override
	public NoticeFileDto downloadFile(String fileno) {
		return sqlSession.getMapper(NoticeFileMapper.class).downloadFile(fileno);
	}

}
