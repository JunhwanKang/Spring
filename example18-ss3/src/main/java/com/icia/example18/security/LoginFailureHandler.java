package com.icia.example18.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.icia.example18.dao.UserDao;
import com.icia.example18.entity.User;

@Component("loginFailureHandler")
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	@Autowired
	private UserDao dao;
	
	//컨트롤러가 아닌 곳에서 리다이렉트 처리하는 객체
	private RedirectStrategy rs = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		//AuthenticationException 인증 실패 예외의 부모
		//BadCredentialsException : 아이디가 없거나 틀렸거나 또는 비밀번호가 틀렸거나
		// 1. 아이디 틀림
		// 2. 비밀번호 틀림 -> 실패횟수가 3이하, 4이상인 경우
		//DisabledException : enabled가 false
		// 3. 계정이 블록된 경우
		HttpSession session = request.getSession();
		if(exception instanceof BadCredentialsException) {
			String username = request.getParameter("username");
			User user = dao.findById(username);
			if(user==null) {
				session.setAttribute("msg", "잘못된 아이디입니다");
			} else {
				int loginFailureCnt = user.getLoginFailureCnt()+1;
				if(loginFailureCnt<5) {
					dao.update(User.builder().username(username).loginFailureCnt(loginFailureCnt).build());
					session.setAttribute("msg", "로그인에 "+loginFailureCnt+"회 실패했습니다");
				} else {
					dao.update(User.builder().username(username).enabled(false).build());
					session.setAttribute("msg", "로그인에 5회 이상 실패해 계정이 블록되었습니다.");
				}
			}
			
		} else if(exception instanceof  DisabledException) {
			session.setAttribute("msg", "블록된 계정입니다. 관리자에게 연락하세요");
		}
		rs.sendRedirect(request, response, "/user/login");
	}
}
