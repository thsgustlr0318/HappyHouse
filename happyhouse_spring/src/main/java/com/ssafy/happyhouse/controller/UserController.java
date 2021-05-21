package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
@Api(value="HappyHouse USER API")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String Login() {
		return "/user/login";
	}

	@PostMapping("/login")
	public String Login(@ModelAttribute User user, HttpSession session, Model model) {
		try {
			User selected = userService.select(user.getUserid());
			// 계정이 존재하고 비밀번호가 일치하면 로그인 성공, 그렇지 않다면 실패이다.
			if (selected != null && user.getUserpwd().equals(selected.getUserpwd())) {
				session.setAttribute("userinfo", selected);
				return "redirect:/";
			} else {
				model.addAttribute("msg", "로그인 실패");
				return "error/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/error";
		}
	}

	@GetMapping("/join")
	public String Join() {
		return "/user/join";
	}

	@PostMapping("/join")
	public String Join(@ModelAttribute User user, Model model) {
		try {
			int res = userService.insert(user);
			if (res > 0) {
				return "redirect:/";
			} else {
				model.addAttribute("msg", "로그인 실패");
				return "error/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 중 문제가 발생했습니다.");
			return "error/error";
		}
	}

	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String MyPage(HttpSession session) {
		return "/user/mypage";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(HttpSession session) {
		return "/user/modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(User user, Model model, HttpSession session, HttpServletResponse response) {
		User member = (User) session.getAttribute("userinfo");
		if (member != null) {
			user.setUserid(member.getUserid());
			try {
				userService.modify(user);
				session.setAttribute("userinfo", userService.select(user.getUserid()));
				return "redirect:/";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "회원 정보 수정 중 문제가 발생했습니다.");
				return "error/error";
			}
		} else {
			model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
			return "error/error";
		}
	}
	
	/*
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("articleno") int articleno, Model model) {
		try {
			guestBookService.deleteArticle(articleno);
			return "redirect:list?pg=1&key=&word=";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글삭제 처리 중 문제가 발생했습니다.");
			return "error/error";
		}
	}
	 */
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(User user, Model model, HttpSession session) {
		try {
			userService.delete((User)session.getAttribute("userinfo"));
			session.invalidate();
			return "redirect:/";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "아이디 삭제 중 문제가 발생했습니다.");
			return "error/error";
		}
		
	}

}
