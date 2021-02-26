package com.icia.example10.dto;

import javax.validation.constraints.*;

import lombok.*;

@Data
public class PostUpdateDto {
	private Integer pno;
	@NotBlank(message="제목은 필수입력입니다")
	private String title;
	private String content;
	@NotBlank(message="글쓴이는 필수입력입니다")
	private String nickname;
	@NotBlank(message="비밀번호는 필수입력입니다")
	private String password;
}
