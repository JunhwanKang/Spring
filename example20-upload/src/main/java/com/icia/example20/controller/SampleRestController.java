package com.icia.example20.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.example20.dto.SampleDto;

@Controller
public class SampleRestController {
	@GetMapping("/user/join")
	public ModelAndView rest1() {
		return new ModelAndView("rest1");
	}

	//아이디 중복 확인
	@GetMapping(value="/users/user/username", produces = "text/plain;charset=utf-8")
	public ResponseEntity<?> idCheck(@RequestParam String username){
		// modelAndView : 화면 + 데이터
		// ResponseEntity : 데이터 + 상태코드 (200, 400, 403, 404, 500...)
		// <?>는 알아서 타입이 변경 됨
		// username이 spring이면 사용불가(409), 아니면 사용가능(200)
		if(username.equals("spring")) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("사용중인 아이디입니다");
		} else {
			return ResponseEntity.ok("사용가능한 아이디입니다");
		}
	}
	@GetMapping("/user/rest2")
	public ModelAndView rest2() {
		return new ModelAndView("rest2");
	}
	
	@GetMapping("/user/rest3")
	public ModelAndView rest3() {
		return new ModelAndView("rest3");
	}
	// put, patch, deleteMapping은 method는 post, _method에 실제 매핑에 담아 서버로 보내야 한다
	@PatchMapping("/users/user/username")
	public ResponseEntity<String> test(@RequestParam String username){
		System.out.println("patch 매핑 호출");
		return ResponseEntity.ok(username);
	}
	
	@PostMapping(value="/users/user", produces="application/json")
	public ResponseEntity<?> join(@ModelAttribute SampleDto.Join dto, @RequestParam MultipartFile profile){
		System.out.println(profile.getOriginalFilename());
		return ResponseEntity.ok(dto);
	}
}
