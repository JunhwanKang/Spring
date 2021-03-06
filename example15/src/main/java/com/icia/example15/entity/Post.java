package com.icia.example15.entity;

import java.time.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;
import lombok.experimental.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain=true)
public class Post {
	@NotNull(message="글번호는 필수입력입니다.")
	private Integer pno;
	@NotBlank(message="제목은 필수입력입니다")
	private String title;
	private String content;
	@NotBlank(message="비밀번호는 필수입력입니다")
	private String password;
	private String nickname;
	private LocalDateTime writeTime;
	private Integer readCnt;
}
