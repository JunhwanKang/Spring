/*
		üũ�ڵ带 Ȯ�� -> üũ�ڵ� ����, enabled�� ����
		��й�ȣ ����
		�� ���� ���� : ��й�ȣ, �̸���, ����
		�α��� ���� Ƚ�� ����
		���� ����
		�۾� Ƚ�� ����
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
