package com.icia.zboard.dto;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class UserDto {
	@Data
	public static class Join{
		@Pattern(regexp = "^[0-9A-Z]{8,10}$")
		private String username;
		private String password;
		private String irum;
		private String email;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private LocalDate birthday;
	}
}
