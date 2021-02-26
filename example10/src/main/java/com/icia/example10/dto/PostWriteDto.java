package com.icia.example10.dto;

import java.time.*;

import javax.validation.constraints.*;

import lombok.*;

@Data
public class PostWriteDto {
	@NotBlank(message="제목은 필수입력입니다")
	private String title;
	private String content;
	@NotBlank(message="글쓴이는 필수입력입니다")
	private String nickname;
	@NotBlank(message="비밀번호는 필수입력입니다")
	private String password;
	private LocalDateTime writeTime = LocalDateTime.now();
	private int readCnt = 0;
}
