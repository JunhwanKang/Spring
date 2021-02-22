package com.icia.example05.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	private int pno;
	private String title;
	private String content;
	private String writer;
	private int readCnt;
}
