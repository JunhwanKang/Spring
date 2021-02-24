package com.icia.example07.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Emp {
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Integer sal;
	private LocalDate hiredate;
	private Integer comm;
	private Integer deptno;
}
