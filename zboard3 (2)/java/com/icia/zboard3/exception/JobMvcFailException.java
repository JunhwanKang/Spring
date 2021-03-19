package com.icia.zboard3.exception;

import lombok.*;

@AllArgsConstructor
public class JobMvcFailException extends RuntimeException {
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
}
