package com.ssafy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.NoticeDao;
import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.SearchCondition;
import com.ssafy.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService{

	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Notice> list() {
		// TODO Auto-generated method stub
		return noticeDao.list();
	}

	@Override
	public List<Notice> search(SearchCondition condition) {
		// TODO Auto-generated method stub
		return noticeDao.search(condition);
	}
	
	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) {
		// TODO Auto-generated method stub
		logger.debug("condition: {}", condition);
		int totalCount = noticeDao.getTotalSearchCount(condition);
		PageNavigation nav = new PageNavigation(condition.getCurrentPage(), totalCount);

		// 결과를 전달할 pagingResult를 만들고 books와 navigation을 키로 값을 저장한다.
		Map<String, Object> pagingResult = new HashMap<>();

		pagingResult.put("notice", search(condition));
		pagingResult.put("navigation", nav);
		logger.debug("result map: {}", pagingResult);
		return pagingResult;
	}


}
