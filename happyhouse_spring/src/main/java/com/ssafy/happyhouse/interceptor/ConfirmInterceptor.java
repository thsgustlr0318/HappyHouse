package com.ssafy.happyhouse.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class ConfirmInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/* HttpSession session = request.getSession(); MemberDto memberDto = (MemberDto) session.getAttribute("userinfo"); if(memberDto == null) { response.sendRedirect(request.getContextPath()); return false; } */
		return true;
	}

}
