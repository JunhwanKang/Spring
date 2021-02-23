package com.icia.example061;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example061.dao.DeptDao;
import com.icia.example061.entity.Dept;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DeptDaoTest {
	@Autowired
	private DeptDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	//@Test
	public void insertTest() {
		Dept dept = new Dept(0, "IT", "SEOUL");
		dao.insert(dept);
		System.out.println(dept.getDeptno());
	}
	//@Test
	public void findByIdTest() {
		Dept dept = dao.findById(10);
		System.out.println(dept);
		assertNotNull(dept);
	}
	@Transactional
	@Test
	public void update() {
		Dept dept = new Dept(30, "IT", "SEOUL");
		dao.update(dept);
	}
	@Transactional
	@Test
	public void delete() {
		assertEquals(1, dao.delete(30));
	}
	
}	
	
	
	
	
