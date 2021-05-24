package com.ssafy.happyhouse.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.happyhouse.model.dto.QnaFileDto;
import com.ssafy.happyhouse.model.service.QnaFileService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qnafile")
public class QnaFileController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private QnaFileService QnaFileServiceImpl;

	@PostMapping(value = "/upload/{qno}")
	public ResponseEntity<String> uploadFile(@RequestParam("files") List<MultipartFile> files, @PathVariable String qno) {
		//저장 경로 설정
		//		String savePath = System.getProperty("user.dir") + "\\files";
		String savePath = "C:\\Users\\thsgu\\Documents\\github\\v3\\HappyHouse_Vue\\src" + "\\assets\\files\\qnafiles";

		File uploadPath = new File(savePath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartfile : files) {
			logger.info("-----------------------------------------------");
			logger.info("파일 이름 : " + multipartfile.getOriginalFilename());
			logger.info("파일 타입 : " + multipartfile.getContentType());
			logger.info("파일 크기 : " + multipartfile.getSize());
			String uploadFileName = multipartfile.getOriginalFilename();
			String uuid = UUID.randomUUID().toString();
			uploadFileName = uuid + "_" + uploadFileName;
			File saveFile = new File(uploadPath, uploadFileName);
			try {
				multipartfile.transferTo(saveFile);
				QnaFileDto file = new QnaFileDto();
				file.setFilename(uploadFileName);
				file.setOriginalfilename(multipartfile.getOriginalFilename());
				file.setQno(Integer.parseInt(qno));
				file.setFilepath(savePath);
				QnaFileServiceImpl.uploadFile(file);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@GetMapping(value = "/getFileList/{qno}")
	public ResponseEntity<List<QnaFileDto>> getFileList(@PathVariable String qno) {
		try {
			System.out.println(qno);
			List<QnaFileDto> answer = QnaFileServiceImpl.getFileList(qno);
			return new ResponseEntity<List<QnaFileDto>>(answer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "/deleteFile/{fileno}")
	public ResponseEntity<String> delete(@PathVariable String fileno) {
		try {
			System.out.println("파일삭제ㅔ요");
			System.out.println(fileno);
			QnaFileDto deleteFiles = QnaFileServiceImpl.getDeleteFile(fileno);
			QnaFileServiceImpl.deleteNotice(fileno);

			System.out.println(deleteFiles);
			System.out.println(deleteFiles.getFilepath() + "\\" + deleteFiles.getFilename());
			File deleteFile = new File(deleteFiles.getFilepath() + "\\" + deleteFiles.getFilename());
			if (deleteFile.exists()) {
				deleteFile.delete();
				System.out.println("파일 삭제되었음");
			} else {
				System.out.println("파일 삭제 안됨");
			}

			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/downloadFile/{fileno}")
	public ResponseEntity<QnaFileDto> downloadFile(@PathVariable String fileno) throws IOException {
		QnaFileDto fileInfo = QnaFileServiceImpl.downloadFile(fileno);
		return new ResponseEntity<QnaFileDto>(fileInfo, HttpStatus.OK);
		//		File file = new File(fileInfo.getFilepath());
		//		ResponseEntity<byte[]> result = null;
		//		try {
		//			HttpHeaders header = new HttpHeaders();
		//			header.add("Content-type", Files.probeContentType(file.toPath()));
		//			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		//		return result;
	}
	//	@GetMapping(value = "/downloadFile/{fileno}")
	//	public ResponseEntity<byte[]> downloadFile(@PathVariable String fileno) throws IOException {
	//		NoticeFileDto fileInfo = noticefileService.downloadFile(fileno);
	//		HttpHeaders headers = new HttpHeaders();
	//		headers.set("Content-Type", "application/octet-stream");
	//		//		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	//		//		headers.add("Content-Disposition", "attachment; filename=\");
	//		InputStream imageStream = new FileInputStream(fileInfo.getFilepath() + "\\" + fileInfo.getFilename());
	//		imageStream.close();
	//		return new ResponseEntity<byte[]>(IOUtils.toByteArray(imageStream), headers, HttpStatus.OK);
	//	}

}
