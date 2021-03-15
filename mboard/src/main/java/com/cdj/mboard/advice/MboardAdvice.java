package com.cdj.mboard.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cdj.mboard.exception.JobFailException;

@ControllerAdvice
public class MboardAdvice {
	@ExceptionHandler(JobFailException.class)
	public ResponseEntity<?> jobFailExceptionHandler(JobFailException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
}
