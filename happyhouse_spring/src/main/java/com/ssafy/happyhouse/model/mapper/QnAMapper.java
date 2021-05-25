package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Answer;
import com.ssafy.happyhouse.model.dto.Question;

public interface QnAMapper {

	List<Question> selectAll();
	
	Question select(String qno);
	
	List<Question> searchById(String userid);

	int insertQuestion(Question question);

	int modifyQuestion(Question question);

	int deleteQuestion(String qno);

	List<Answer> selectAnswer(String qno);
	
	int updateQuestion(String qno);
	
	int insertAnswer(Answer answer);

	int modifyAnswer(Answer answer);

	int deleteAnswer(String ano);

	Question getQnaNo();
	
}
