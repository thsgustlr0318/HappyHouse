package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Answer;
import com.ssafy.happyhouse.model.dto.Question;

public interface QnAService {
	
	List<Question> selectAll();
	
	Question select(String qno);

	int insertQuestion(Question question);

	int modifyQuestion(Question question);

	int deleteQuestion(Question question);
	
	int updateQuestion(String qno);
	
	int insertAnswer(Answer answer);

	int modifyAnswer(Answer answer);

	int deleteAnswer(Answer answer);
	
}
