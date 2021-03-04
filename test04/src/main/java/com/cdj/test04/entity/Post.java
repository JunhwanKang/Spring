package com.cdj.test04.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
	private Integer pno;
	private String title;
	private String content;
	private String nickname;
	private LocalDateTime writeTime;
	private Integer readCnt;
}
