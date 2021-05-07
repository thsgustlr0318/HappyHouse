package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.SearchCondition;

public interface NoticeService {

	List<Notice> list();
	List<Notice> search(SearchCondition condition);
	Map<String, Object> pagingSearch(SearchCondition condition);
	
}
