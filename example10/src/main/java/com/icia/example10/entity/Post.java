package com.icia.example10.entity;

import java.time.*;

import javax.validation.constraints.*;

import lombok.*;
import lombok.experimental.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain=true)
public class Post {
	private int pno;
	private String title;
	private String content;
	private String nickname;
	private String password;
	private LocalDateTime writeTime;
	private int readCnt;
}
