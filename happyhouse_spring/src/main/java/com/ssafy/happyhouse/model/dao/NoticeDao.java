package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.dto.SearchCondition;

public interface NoticeDao {

	List<Notice> list();
	List<Notice> search(SearchCondition condition);
	int getTotalSearchCount(SearchCondition condition);
	
}
