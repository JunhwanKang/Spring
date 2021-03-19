package com.icia.zboard3.dto;

import java.time.*;

import org.springframework.format.annotation.*;

import lombok.*;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class UserDto {
	@Data
	public static class Join {
		private String username;
		private String password;
		private String irum;
		private String email;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private LocalDate birthday;
	}
	
	@Data
	public static class ResetPassword {
		private String username;
		private String email;
	}
}
