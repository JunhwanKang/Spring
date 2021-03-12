package com.icia.zboard.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	private String username;
	private String password;
	private String irum;
	private String email;
	private LocalDate joinday;
	private LocalDate birthday;
	private Integer loginFailureCnt;
	private Integer writeCnt;
	private Level level;
	private Boolean enabled;  // number(1) , char(1)
	private String profile;
	private String checkCode; // 가입 후 메일로 전송할 체크 코드
}
