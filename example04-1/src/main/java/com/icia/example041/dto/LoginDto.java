package com.icia.example041.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LoginDto {
	@NotNull(message = "아이디는 필수입력입니다")
	@Pattern(regexp = "^[A-Za-z0-9]{6,10}$", message = "아이디는 영숫자 6~10자입니다")
	private String username;
	
	@NotNull(message= "비밀번호는 필수입력입니다")
	@Pattern(regexp = "^[0-9]{6,10}$", message= "비밀번호는 숫자 6~10자입니다")
	private String password;
}
