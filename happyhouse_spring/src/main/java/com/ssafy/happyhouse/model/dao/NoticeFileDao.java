package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.dto.NoticeFileDto;

public interface NoticeFileDao {

	int uploadFile(NoticeFileDto file);
}
