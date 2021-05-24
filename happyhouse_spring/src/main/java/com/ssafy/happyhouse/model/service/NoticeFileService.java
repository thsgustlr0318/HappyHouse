package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeFileDto;

public interface NoticeFileService {

	int uploadFile(NoticeFileDto file);

	List<NoticeFileDto> getFileList(String no);

	int deleteNotice(String fileno);

	NoticeFileDto downloadFile(String fileno);

}
