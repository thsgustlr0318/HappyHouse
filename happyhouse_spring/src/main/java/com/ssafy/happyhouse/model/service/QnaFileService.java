package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.QnaFileDto;

public interface QnaFileService {

	int uploadFile(QnaFileDto file);

	List<QnaFileDto> getFileList(String qno);

	int deleteNotice(String fileno);

	QnaFileDto downloadFile(String fileno);

	QnaFileDto getDeleteFile(String fileno);

}
