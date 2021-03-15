package com.cdj.mboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdj.mboard.dao.UserDao;
import com.cdj.mboard.entity.User;
import com.cdj.mboard.exception.JobFailException;
import com.cdj.mboard.util.MailUtil;

@Service
public class UserRestService {
	@Autowired
	private UserDao dao;
	@Autowired
	private MailUtil mailUtil;
	
	public void idCheck(String username) {
		User user = dao.findById(username);
		if(user!=null)
			throw new JobFailException("사용중인 아이디입니다.");
	}

	public void emailCheck(String email) {
		User user = dao.findByEmail(email);
		if(user!=null)
			throw new JobFailException("사용중인 이메일입니다");
	}

	public void join() {
		mailUtil.sendJoinCheckMail("admin@SB.com", "wnsghks1017@naver.com", "1234");
	}
}
