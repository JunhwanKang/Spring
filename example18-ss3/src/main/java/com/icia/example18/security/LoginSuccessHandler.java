package com.icia.example18.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.icia.example18.dao.UserDao;
import com.icia.example18.entity.User;

@Component("loginSuccessHandler")
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	@Autowired
	private UserDao dao;
	private RequestCache cache = new HttpSessionRequestCache();
	private RedirectStrategy rs = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//로그인 실패 횟수를 0으로 리셋
		dao.update(User.builder().username(authentication.getName()).loginFailureCnt(0).build());
		
		// 로그인한 사용자에게 출력할 메시지가 있다면 세션에 저장
		
		//이동할 주소가 있는지 알아내자
		SavedRequest savedRequest = cache.getRequest(request, response);
		//이동할 주소가 있으면 그곳으로, 없으면 루트로
		if(savedRequest!=null)
			rs.sendRedirect(request, response, savedRequest.getRedirectUrl());
		else
			rs.sendRedirect(request, response, "/");
	}
}
