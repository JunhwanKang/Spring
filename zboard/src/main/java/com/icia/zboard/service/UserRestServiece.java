package com.icia.zboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.zboard.dao.UserDao;
import com.icia.zboard.entity.User;
import com.icia.zboard.exception.JobFailException;

@Service
public class UserRestServiece {
	@Autowired
	private UserDao userDao;
	
	public void idAvailableCheck(String username) {
		User user = userDao.findById(username);
		if(user!=null)
			throw new JobFailException("사용중인 아이디입니다");
	}

}
