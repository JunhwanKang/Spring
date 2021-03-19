package com.icia.zboard3.service;

import org.apache.commons.lang3.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import com.icia.zboard3.dao.*;
import com.icia.zboard3.dto.*;
import com.icia.zboard3.entity.*;
import com.icia.zboard3.exception.*;
import com.icia.zboard3.util.*;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MailUtil mailUtil;
	
	public void joinCheck(String checkCode) {
		User result = userDao.findByCheckCode(checkCode);
		if(result==null)
			throw new JobMvcFailException("체크코드를 확인할 수 없습니다");
		User param = User.builder().username(result.getUsername()).checkCode("1").enabled(true).build();
		userDao.update(param);
	}

	public void resetPwd(UserDto.ResetPassword dto) {
		User result = userDao.findById(dto.getUsername());
		if(result==null)
			throw new MvcUserNotFoundException();
		if(result.getEmail().equals(dto.getEmail())==false)
			throw new JobMvcFailException("이메일을 확인할 수 없습니다");
		
		String password = RandomStringUtils.randomAlphanumeric(20);
		String encodedPassword = passwordEncoder.encode(password);
		User param = User.builder().username(dto.getUsername()).password(encodedPassword).build();
		
		mailUtil.sendResetPasswordMail("admin@icia.co.kr", dto.getEmail(), password);
	}
}





