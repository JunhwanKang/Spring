package com.icia.example07.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime writeTime;
	private Integer readCnt;
}
