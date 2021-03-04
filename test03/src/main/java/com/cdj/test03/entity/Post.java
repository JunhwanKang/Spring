package com.cdj.test03.entity;

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
	private LocalDateTime writeTime;
	private Integer ReadCnt;
}
