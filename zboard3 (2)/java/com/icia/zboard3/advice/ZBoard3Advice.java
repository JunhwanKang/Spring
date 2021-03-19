package com.icia.zboard3.advice;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;

import com.icia.zboard3.exception.*;

// ControllerAdvice, RestControllerAdvice
@ControllerAdvice
public class ZBoard3Advice {
	@ExceptionHandler(JobMvcFailException.class)
	public ModelAndView JMFEhandler(JobMvcFailException e, RedirectAttributes ra) {
		// MVC의 경우 성공 페이지, 실패 페이지를 따로 만든다 -> 실패 페이지에서 오류 메시지 출력
		// 오류 페이지로 오류 메시지와 함께 redirect
		ra.addFlashAttribute("viewname", e.getMessage());
		return new ModelAndView("redirect:/system/error");
	}
	
	@ExceptionHandler(JobRestFailException.class)
	public ResponseEntity<?> JRFEhandler(JobRestFailException e) {
		// 페이지 이동 X -> 작업이 성공/실패를 모두 한페이지에서 처리 -> 상태 코드가 함께 간다
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
}
