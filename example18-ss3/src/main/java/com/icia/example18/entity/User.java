package com.icia.example18.entity;

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
	private Integer wirteCnt;
	private Level level;
	private Boolean enabled;
	private String profile;
	private String checkCode;
}
