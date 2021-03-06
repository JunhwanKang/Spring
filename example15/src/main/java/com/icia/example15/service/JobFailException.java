package com.icia.example15.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JobFailException extends RuntimeException {
	private String message;
	
	public String getMessage() {
		return message;
	}
}
