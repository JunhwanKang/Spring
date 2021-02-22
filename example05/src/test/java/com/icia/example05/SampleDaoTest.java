package com.icia.example05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.icia.example05.dao.SampleDao;
import com.icia.example05.entity.Dept;

// 스프링 부트 프로젝트를 junit으로 테스트하려면 설정 어노테이션 필요

@ExtendWith(SpringExtension.class)
// 스프링 부트 설정을 읽어오도록 하는 어노테이션
@SpringBootTest
public class SampleDaoTest {
	@Autowired
	private SampleDao dao;
	
	@Test
	public void initTest() {
		assertNotNull(dao);
	}
	
	@Test
	public void findByIdTest() {
		Dept dept = dao.findById(30);
		assertEquals(dept.getDname(), "SALES");
		assertEquals(dept.getLoc(), "CHICAGO");
	}
	@Test
	public void findByDnameTest() {
		Dept dept = dao.findByDname("SALES");
		assertNotNull(dept);
	}
	@Test
	public void findByLocTest() {
		Dept dept = dao.findByLoc("CHICAGO");
		assertNotNull(dept);
	}
	@Test
	public void findByTest() {
		assertNotNull(dao.findById(30));
		assertNotNull(dao.findByDname("SALES"));
		assertNotNull(dao.findByLoc("CHICAGO"));
	}
	@Test
	public void findAllTest() {
		List<Dept> list = dao.findAll();
		assertEquals(list.size(), 4);
	}
	@Test
	public void findByIdAndDnameTest() {
		Dept dept = dao.findByIdAndDname(30, "SALES");
		assertNotNull(dept);
	}
	@Test
	public void findByIdAndDnameVer2Test() {
		Dept dept = new Dept(30, "SALES", null);
		assertNotNull(dao.findByIdAndDnameVer2(dept));
	}
}
