package com.cdj.mboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdj.mboard.dao.UserDao;
import com.cdj.mboard.entity.User;
import com.cdj.mboard.exception.JobMvcFailException;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	public void joinCheck(String checkCode) {
		User result = dao.findByCheckCode(checkCode);
		if(result!=null) {
			User user = User.builder().enabled(true).checkCode("1").username(result.getUsername()).build();
			System.out.println("############user���� �̷��͵��� ��� �ֽ��ϴ�: "+ user);
			dao.update(user);
		} else {
			throw new JobMvcFailException("�ùٸ��� ���� üũ�ڵ��Դϴ�.");
		}
	}

	 
	
	
}
