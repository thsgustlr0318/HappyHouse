package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.QnaFileDto;
import com.ssafy.happyhouse.model.mapper.NoticeFileMapper;
import com.ssafy.happyhouse.model.mapper.QnaFileMapper;

@Service
public class QnaFileServiceImpl implements QnaFileService {

	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int uploadFile(QnaFileDto file) {
		return sqlSession.getMapper(QnaFileMapper.class).uploadFile(file);
	}

	@Override
	public List<QnaFileDto> getFileList(String qno) {
		return sqlSession.getMapper(QnaFileMapper.class).getFileList(qno);
	}

	@Override
	public int deleteNotice(String fileno) {
		return sqlSession.getMapper(QnaFileMapper.class).deleteFile(fileno);
	}

	@Override
	public QnaFileDto downloadFile(String fileno) {
		return sqlSession.getMapper(QnaFileMapper.class).downloadFile(fileno);
	}

	@Override
	public QnaFileDto getDeleteFile(String fileno) {
		return sqlSession.getMapper(QnaFileMapper.class).getDeleteFile(fileno);
	}

}
