package com.ssafy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;

@Controller
@RequestMapping("/user")
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
			System.out.println(res+" "+user.getUserid());
			if ( res > 0 ) {
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
}
