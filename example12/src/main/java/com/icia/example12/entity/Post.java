package com.icia.example12.entity;

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
	private Integer readCnt;
}
