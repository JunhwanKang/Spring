package com.icia.example10.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class PostReadDto {
	private int pno;
	private String title;
	private String content;
	private String nickname;
	private String writeTimeString;
	private int readCnt;
}
