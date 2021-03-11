package com.icia.example20.dto;

import lombok.Data;

public class SampleDto {
	@Data
	public class Write {
		private String username;
		private String email;
	}
	
	@Data
	public static class Join{
		private String username;
		private String email;
	}
}
