package com.cdj.mboard.service;

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

import com.cdj.mboard.dao.AuthorityDao;
import com.cdj.mboard.dao.UserDao;
import com.cdj.mboard.dto.UserDto.Join;
import com.cdj.mboard.entity.Level;
import com.cdj.mboard.entity.User;
import com.cdj.mboard.exception.JobRestFailException;
import com.cdj.mboard.util.MailUtil;

@Service
public class UserRestService {
	@Autowired
	private UserDao dao;
	@Autowired
	private MailUtil mailUtil;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthorityDao authorityDao;
	@Value("c:/upload/image")
	private String profileFolder;
	
	public void idCheck(String username) {
		User user = dao.findById(username);
		if(user!=null)
			throw new JobRestFailException("사용중인 아이디입니다.");
	}

	public void emailCheck(String email) {
		User user = dao.findByEmail(email);
		if(user!=null)
			throw new JobRestFailException("사용중인 이메일입니다");
	}

	public void join() {
		mailUtil.sendJoinCheckMail("admin@SB.com", "wnsghks1017@naver.com", "1234");
	}
	
	@Transactional
	public void join(Join dto, MultipartFile profile) {
		User user = modelMapper.map(dto, User.class);
		System.out.println(user);
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
		System.out.println("chekCode는 :"+checkCode+"입니다.");
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		user.setLevel(Level.NORMAL);
		user.setCheckCode(checkCode);
		user.setPassword(encodedPassword);
		
		dao.insert(user);
		authorityDao.insert(user.getUsername(), "ROLE_USER");
		
		mailUtil.sendJoinCheckMail("admin@sboard.com", user.getEmail(), checkCode);
	}
}
