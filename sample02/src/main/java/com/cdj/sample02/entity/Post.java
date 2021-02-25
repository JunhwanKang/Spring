package com.cdj.sample02.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
