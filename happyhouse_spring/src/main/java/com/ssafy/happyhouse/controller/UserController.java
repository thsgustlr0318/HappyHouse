package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.JwtService;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
@Api(value="HappyHouse USER API")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/login")
	public String Login() {
		return "/user/login";
	}

	@ApiOperation(value = "입력받은 아이디와 비밀번호가 유효한지 확인한 후 로그인한다.", response = String.class)
	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody User user, HttpServletResponse response) {
		try {
			System.out.println("login "+user.getUserid());
			User selected = userService.select(user.getUserid());
			System.out.println("login2 "+user.getUserid()+" "+user.getUserpwd());
			// 계정이 존재하고 비밀번호가 일치하면 로그인 성공, 그렇지 않다면 실패이다.
			if (selected != null && user.getUserpwd().equals(selected.getUserpwd())) {

				String token = jwtService.createToken(selected, (60 * 1000 * 60));
				response.setHeader("authorization", token);
				MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	            headers.add("authorization", token);
	            System.out.println("login success");
				return new ResponseEntity<String>(token, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/join")
	public String Join() {
		return "/user/join";
	}

	@ApiOperation(value = "입력받은 User 정보로 회원가입 한다.", response = String.class)
	@PostMapping("/join")
	public ResponseEntity<String> Join(@RequestBody User user) {
		try {
			userService.insert(user);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}


	@ApiOperation(value = "userid에 해당하는 정보를 반환한다.", response = User.class)
	@RequestMapping(value = "/info/{userid}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> MyPage(@PathVariable String userid, @RequestBody Map<String, String> req) {
		try {
			User selected = userService.select(userid);
			// 계정이 존재하고 비밀번호가 일치하면 로그인 성공, 그렇지 않다면 실패이다.
			if (selected != null && jwtService.isUsable(req.get("auth"))) {
				Map<String, Object> hm = new HashMap<>();
				hm.put("user", jwtService.getSubject(req.get("auth")));
				return new ResponseEntity<Map<String, Object>>(hm, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
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
