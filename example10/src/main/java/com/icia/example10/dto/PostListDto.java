package com.icia.example10.dto;

import lombok.*;

@Data
public class PostListDto {
	private int pno;
	private String title;
	private String nickname;
	private String writeTimeString;
	private int readCnt;
}
