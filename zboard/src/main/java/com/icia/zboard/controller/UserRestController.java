package com.icia.zboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.icia.zboard.dto.UserDto;
import com.icia.zboard.entity.User;
import com.icia.zboard.service.UserRestServiece;

@RestController
public class UserRestController {
	@Autowired
	private UserRestServiece service;
	
	@GetMapping("/users/user/username")
	public ResponseEntity<?> idAvailableCheck(@RequestParam String username){
		service.idAvailableCheck(username);
		return ResponseEntity.ok(null);
		/*	
		 * (서버응답)=>{코드}
		 * 
			"아이디 사용가능"
			"아이디 사용불가"
			if(result=="아이디 사용가능")
		*/	
	}
	
	@GetMapping("/users/user/email")
	public ResponseEntity<?> emailAvailableCheck(@RequestParam String email){
		service.emailAvailableCheck(email);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> join(@ModelAttribute UserDto.Join dto, @RequestParam(required=false) MultipartFile profile){
		service.join(dto, profile);
		return ResponseEntity.ok(null);
	}
	
}
