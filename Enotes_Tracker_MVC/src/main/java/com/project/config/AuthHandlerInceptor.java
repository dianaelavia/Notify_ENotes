package com.project.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.project.entity.User;

public class AuthHandlerInceptor implements HandlerInterceptor
{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		User user =	(User) request.getSession().getAttribute("userObj");
		if(user != null) {
			System.out.println("Auth if block");
			return true;
		}else {
			System.out.println("Auth");
			response.sendRedirect("http://localhost:8080/Enotes_Tracker_MVC/login");
			return false;
		}
		
	}
	
}
