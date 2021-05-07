package com.ssafy.controller;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.SearchCondition;
import com.ssafy.model.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	/*
	@GetMapping("/list")
	public String list(Model model) {	
		try {
			List<Notice> list = noticeService.list();
			model.addAttribute("notice", list);
			return "notice/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "공지사항 목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	*/
	@GetMapping("/list")
	public String search(Model model, @ModelAttribute SearchCondition condition) {	
		try {
			logger.debug("전달받은 condition: {}", condition);
			Map<String, Object> pagingResult = noticeService.pagingSearch(condition);
			model.addAttribute("notice", pagingResult.get("notice"));
			model.addAttribute("navigation", pagingResult.get("navigation"));
			return "notice/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	
	
	
}
