package com.ssafy.happyhouse.controller;
import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.dto.Question;
import com.ssafy.happyhouse.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Notice>> getNotice() {
		try {
			List<Notice> list = noticeService.list();
			return new ResponseEntity<List<Notice>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/getNoticeNo")
	public ResponseEntity<Notice> getNoticeNo() {
		try {
			System.out.println("받아오기");
			Notice answer = noticeService.getNoticeNo();
			return new ResponseEntity<Notice>(answer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> insertNotice(@RequestBody Notice notice) {
		try {
			// User member = (User) session.getAttribute("userinfo");
			// userid add
			// permission error
			noticeService.insertNotice(notice);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> modify(@RequestBody Notice notice) {
		try {
			noticeService.modifyNotice(notice);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping(value = "/delete/{no}")
	public ResponseEntity<String> delete(@PathVariable String no) {
		try {
			System.out.println(no);
			noticeService.deleteNotice(no);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
//	@GetMapping("/list")
//	public String list(Model model) {	
//		try {
//			List<Notice> list = noticeService.list();
//			model.addAttribute("notice", list);
//			return "notice/list";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("msg", "공지사항 목록을 얻어오는 중 문제가 발생했습니다.");
//			return "error/error";
//		}
//	}
	
//	@GetMapping("/list")
//	public String search(Model model, @ModelAttribute SearchCondition condition) {	
//		try {
//			logger.debug("전달받은 condition: {}", condition);
//			Map<String, Object> pagingResult = noticeService.pagingSearch(condition);
//			model.addAttribute("notice", pagingResult.get("notice"));
//			model.addAttribute("navigation", pagingResult.get("navigation"));
//			return "notice/list";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("msg", "검색 목록을 얻어오는 중 문제가 발생했습니다.");
//			return "error/error";
//		}
//	}
	
	
	
}
