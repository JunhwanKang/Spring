package com.cdj.mboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdj.mboard.dao.UserDao;
import com.cdj.mboard.entity.User;
import com.cdj.mboard.exception.JobFailException;

@Service
public class UserRestService {
	@Autowired
	private UserDao dao;
	
	public void idCheck(String username) {
		User user = dao.findById(username);
		if(user!=null)
			throw new JobFailException("사용중인 아이디입니다.");
	}
}
