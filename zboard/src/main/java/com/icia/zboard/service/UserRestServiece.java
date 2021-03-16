package com.icia.zboard.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.icia.zboard.dao.AuthorityDao;
import com.icia.zboard.dao.UserDao;
import com.icia.zboard.dto.Mail;
import com.icia.zboard.dto.UserDto.Join;
import com.icia.zboard.entity.Level;
import com.icia.zboard.entity.User;
import com.icia.zboard.exception.JobFailException;
import com.icia.zboard.util.MailUtil;

@Service
public class UserRestServiece {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AuthorityDao authorityDao;
	@Autowired
	private MailUtil mailUtil;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	// BCryptPasswordEncoder : 암호를 걸지만 풀진못한다 -> (일방향 함수, 단방향 함수 -> hash함수)
	private PasswordEncoder passwordEncoder;  
	
	@Value("c:/upload/profile")
	private String profileFolder;
	
	public void idAvailableCheck(String username) {
		User user = userDao.findById(username);
		if(user!=null)
			throw new JobFailException("사용중인 아이디입니다");
	}

	public void emailAvailableCheck(String email) {
		User user = userDao.findByEmail(email);
		if(user!=null)
			throw new JobFailException("사용중인 이메일입니다");
	}
	
	public void join() {
		mailUtil.sendJoinCheckMail("admin@icia.com", "wnsghks1017@naver.com", "1234");
	}
	
	@Transactional
	public void join(Join dto, MultipartFile profile) {
		User user = modelMapper.map(dto, User.class);

		if(profile!=null && profile.isEmpty()==false) {
			user.setProfile(profile.getOriginalFilename());
			File profileFile = new File(profileFolder, profile.getOriginalFilename());
			try {
				FileCopyUtils.copy(profile.getBytes(), profileFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
		String checkCode = RandomStringUtils.randomAlphanumeric(20);
		String encodedpassword = passwordEncoder.encode(user.getPassword());
		user.setLevel(Level.NORMAL);
		user.setCheckCode(checkCode);
		user.setPassword(encodedpassword);
		
		userDao.insert(user);
		authorityDao.insert(user.getUsername(), "ROLE_USER");
		
		mailUtil.sendJoinCheckMail("admin@icia.co.kr", user.getEmail(), checkCode);
	}

}
