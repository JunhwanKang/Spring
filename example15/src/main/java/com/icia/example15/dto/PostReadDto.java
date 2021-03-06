package com.icia.example15.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReadDto {
	private Integer pno;
	private String title;
	private String content;
	private String nickname;
	private String writeTimeString;
	private Integer readCnt;
}
