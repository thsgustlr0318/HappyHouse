package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.SearchCondition;

public interface NoticeDao {

	List<Notice> list();
	List<Notice> search(SearchCondition condition);
	int getTotalSearchCount(SearchCondition condition);
	
}
