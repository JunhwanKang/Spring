package com.icia.zboard3.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.icia.zboard3.dto.*;
import com.icia.zboard3.service.*;

// ModelAndView : MVC -> 화면 + 데이터 -> 성공/실패 페이지 분리
// ResponseEntity : REST -> 상태 코드 + 데이터 -> 상태코드가 왜 필요? 성공/실패를 $.ajax에서 처리
@RestController
public class UserRestController {
	@Autowired
	private UserRestService service;
	
	@GetMapping("/users/user/username")
	public ResponseEntity<?> idAvailableCheck(@RequestParam String username) {
		service.idAvailableCheck(username);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/users/user/email")
	public ResponseEntity<?> emailAvailableCheck(@RequestParam String email) {
		service.emailAvailableCheck(email);
		return ResponseEntity.ok(null);
	}

	@PostMapping("/users/user")
	public ResponseEntity<?> join(@ModelAttribute @Valid UserDto.Join dto, BindingResult bindingResult, @RequestParam MultipartFile profile ) throws BindException {
		if(bindingResult.hasErrors())
			throw new BindException(bindingResult);
		service.join(dto, profile);
		return ResponseEntity.ok(null);
	}
	
	// /zboard3/users/username/email?email=spring@naver.com
	@GetMapping("/users/username/email")
	public ResponseEntity<?> findId(@RequestParam String email) {
		System.out.println(email);
		String username = service.findId(email);
		return ResponseEntity.ok(username);
	}

}






