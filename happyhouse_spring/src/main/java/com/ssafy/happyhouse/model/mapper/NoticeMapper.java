package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.dto.SearchCondition;

public interface NoticeMapper {

	List<Notice> list();

	List<Notice> search(SearchCondition condition);

	int getTotalSearchCount(SearchCondition condition);

	int insertNotice(Notice notice);

	int modifyNotice(Notice notice);

	int deleteNotice(String no);

	Notice getNoticeNo();
}
