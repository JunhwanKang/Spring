package com.icia.example12.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
}
