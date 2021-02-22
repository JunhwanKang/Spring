package com.cdj.daoTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private int sno;        // 학번 
	private String sname;   // 학생 이름
	private String sdept;   // 학생 학부
}
