package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.dto.Question;
import com.ssafy.happyhouse.model.dto.SearchCondition;

public interface NoticeService {

	List<Notice> list();
	List<Notice> search(SearchCondition condition);
	Map<String, Object> pagingSearch(SearchCondition condition);
	int insertNotice(Notice notice);
	int modifyNotice(Notice notice);
	int deleteNotice(String no);
	
}
