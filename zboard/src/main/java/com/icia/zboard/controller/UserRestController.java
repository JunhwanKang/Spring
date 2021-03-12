package com.icia.zboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icia.zboard.service.UserRestServiece;

@RestController
public class UserRestController {
	@Autowired
	private UserRestServiece service;
	@GetMapping("/users/username")
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
}
