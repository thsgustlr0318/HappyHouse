package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Answer;
import com.ssafy.happyhouse.model.dto.Question;
import com.ssafy.happyhouse.model.mapper.QnAMapper;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class QnAServiceImpl implements QnAService{
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Question> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).selectAll();
	}

	@Override
	public Question select(String qno) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).select(qno);
	}

	@Override
	public int insertQuestion(Question question) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).insertQuestion(question);
	}

	@Override
	public int modifyQuestion(Question question) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).modifyQuestion(question);
	}

	@Override
	public int deleteQuestion(String qno) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).deleteQuestion(qno);
	}

	@Override
	public int updateQuestion(String qno) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).updateQuestion(qno);
	}

	@Override
	public int insertAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).insertAnswer(answer);
	}

	@Override
	public int modifyAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).modifyAnswer(answer);
	}

	@Override
	public int deleteAnswer(String ano) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).deleteAnswer(ano);
	}

	@Override
	public List<Answer> selectAnswer(String qno) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(QnAMapper.class).selectAnswer(qno);
	}

}
