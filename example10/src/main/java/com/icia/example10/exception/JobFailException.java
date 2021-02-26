package com.icia.example10.exception;

import lombok.*;

@AllArgsConstructor
public class JobFailException extends RuntimeException {
	private String cause;
	@Override
	public String getMessage() {
		return cause;
	}
}
