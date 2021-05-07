package com.ssafy.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.dto.SearchCondition;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;
import com.ssafy.happyhouse.util.PageNavigation;

@Service
public class NoticeServiceImpl implements NoticeService {

	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Notice> list() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(NoticeMapper.class).list();
	}

	@Override
	public List<Notice> search(SearchCondition condition) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(NoticeMapper.class).search(condition);
	}

	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) {
		// TODO Auto-generated method stub
		logger.debug("condition: {}", condition);
		int totalCount = sqlSession.getMapper(NoticeMapper.class).getTotalSearchCount(condition);
		PageNavigation nav = new PageNavigation(condition.getCurrentPage(), totalCount);

		// 결과를 전달할 pagingResult를 만들고 books와 navigation을 키로 값을 저장한다.
		Map<String, Object> pagingResult = new HashMap<>();

		pagingResult.put("notice", search(condition));
		pagingResult.put("navigation", nav);
		logger.debug("result map: {}", pagingResult);
		return pagingResult;
	}

}
