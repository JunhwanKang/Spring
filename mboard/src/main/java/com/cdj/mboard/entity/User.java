package com.cdj.mboard.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthday;
	private Integer loginFailureCnt;
	private Integer writeCnt;
	private Level level;
	private Boolean enabled;
	private String profile;
	private String checkCode;
}
