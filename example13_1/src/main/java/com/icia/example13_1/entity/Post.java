package com.icia.example13_1.entity;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

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
