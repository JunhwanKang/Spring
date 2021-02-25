package com.icia.example08.entity;

import java.time.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	private Integer pno;
	private String title;
	private String content;
	private String nickname;
	private String password;
	private LocalDateTime writeTime;
	private Integer readCnt;
}
