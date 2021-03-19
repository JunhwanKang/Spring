package com.icia.zboard3.exception;

import lombok.*;

@AllArgsConstructor
public class JobRestFailException extends RuntimeException {
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
}
