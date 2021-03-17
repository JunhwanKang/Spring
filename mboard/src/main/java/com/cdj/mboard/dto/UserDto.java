package com.cdj.mboard.dto;

import java.time.LocalDate;



import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

public class UserDto {
	@Data
	public static class Join{
		private String username;
		private String password;
		private String irum;
		private String email;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private LocalDate birthday;
	}
}
