/*
		체크코드를 확인 -> 체크코드 삭제, enabled를 변경
		비밀번호 변경
		내 정보 변경 : 비밀번호, 이메일, 프사
		로그인 실패 횟수 변경
		레벨 변경
		글쓴 횟수 변경
 */

package com.cdj.mboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdj.mboard.service.UserRestService;

@RestController
public class UserRestController {
	@Autowired
	private UserRestService service;
	
	@GetMapping("/users/username")
	public ResponseEntity<?> idCheck(@RequestParam String username){
		service.idCheck(username);
		return ResponseEntity.ok(null);
	}
	

}
