package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.dto.NoticeFileDto;

public interface QnaFileDao {

	int uploadFile(NoticeFileDto file);
}
