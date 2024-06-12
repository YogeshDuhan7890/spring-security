package com.example.demo.modal.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class UrlInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		HttpSession session = request.getSession(false);

		boolean isInvalidUrl = requestURI.equals("/invalid-url") || requestURI.equals("/error");

		// Check if the user is trying to access home pages without being logged in
		if ((requestURI.equals("/home") || requestURI.startsWith("/home/"))
				&& (session == null || session.getAttribute("SPRING_SECURITY_CONTEXT") == null)) {
			response.sendRedirect("/login");
			return false;
		}

		// If the URL is invalid, log out the user and redirect to login page
		if (isInvalidUrl) {
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect("/login?session=invalid");
			return false;
		}

		return true;
	}

}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// No post-processing required in this case
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// No cleanup required in this case
//	}
//}
