package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.QnaFileDto;

public interface QnaFileMapper {

	int uploadFile(QnaFileDto file);

	List<QnaFileDto> getFileList(String qno);

	int deleteFile(String fileno);

	QnaFileDto downloadFile(String fileno);

	QnaFileDto getDeleteFile(String fileno);

}
