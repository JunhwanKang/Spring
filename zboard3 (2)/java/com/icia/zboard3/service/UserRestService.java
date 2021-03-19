package com.icia.zboard3.service;

import java.io.*;

import org.apache.commons.lang3.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.util.*;
import org.springframework.web.multipart.*;

import com.icia.zboard3.dao.*;
import com.icia.zboard3.dto.*;
import com.icia.zboard3.entity.*;
import com.icia.zboard3.exception.*;
import com.icia.zboard3.util.*;

@Service
public class UserRestService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AuthorityDao authorityDao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MailUtil mailUtil;
	@Value("c:/upload/profile")
	private String profileFolder;
	
	@Transactional(readOnly=true)
	public void idAvailableCheck(String username) {
		if(userDao.findById(username)!=null)
			throw new JobRestFailException("사용중인 아이디입니다");
	}

	@Transactional(readOnly=true)
	public void emailAvailableCheck(String email) {
		if(userDao.findByEmail(email)!=null)
			throw new JobRestFailException("사용중인 이메일입니다");
		
	}

	@Transactional
	public void join(UserDto.Join dto, MultipartFile profile) {
		User user = modelMapper.map(dto, User.class);
		if(profile!=null && profile.isEmpty()==false) {
			String profileFileName = user.getUsername() + ".jpg";
			File file = new File(profileFolder, profileFileName);
			try {
				FileCopyUtils.copy(profile.getBytes(), file);
				user.setProfile(profileFileName);
			} catch (IOException e) {
				user.setProfile("default.jpg");
				e.printStackTrace();
			}
		} else
			user.setProfile("default.jpg");
		
		String checkCode = RandomStringUtils.randomAlphanumeric(20);
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword).setCheckCode(checkCode).setLevels(Level.NORMAL);
		
		userDao.insert(user);
		authorityDao.insert(user.getUsername(), "ROLE_USER");
		mailUtil.sendJoinCheckMail("admin@icia.co.kr", user.getEmail(), checkCode);
	}

	public String findId(String email) {
		User user = userDao.findByEmail(email);
		if(user==null)
			throw new RestUserNotFoundException();
		return user.getUsername();

	}
	
	
}






