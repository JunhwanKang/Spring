package com.icia.zboard.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.icia.zboard.exception.JobFailException;

@ControllerAdvice
public class ZboardAdvice {
	@ExceptionHandler(JobFailException.class)
	public ResponseEntity<?> jobFailExceptionHandler(JobFailException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
}
