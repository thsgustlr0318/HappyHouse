package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeFileDto;

public interface NoticeFileMapper {

	int uploadFile(NoticeFileDto file);

	List<NoticeFileDto> getFileList(String no);

	int deleteFile(String fileno);

	NoticeFileDto downloadFile(String fileno);

}
