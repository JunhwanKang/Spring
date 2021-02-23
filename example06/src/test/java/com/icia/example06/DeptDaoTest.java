package com.icia.example06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.icia.example06.dao.DeptDao;
import com.icia.example06.entity.Dept;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DeptDaoTest {
	@Autowired
	private DeptDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	@Test
	public void findByIdTest() {
		assertNotNull(dao.findById(10));
	}
	@Test
	public void insertTest() {
		Dept dept = new Dept(90, "IT", "SEOUL");
		assertEquals(1, dao.insert(dept));
	}
	@Test
	public void updateTest() {
		Dept dept = new Dept(90, "IT-1", "INCHEON");
		assertEquals(1, dao.update(dept));
	}
	@Test
	public void deleteTest() {
		assertEquals(1, dao.delete(90));
	}
	@Test
	public void existsByIdTest() {
		assertEquals(false, dao.existsById(90));
		assertEquals(true, dao.existsById(30));
	}
	
}
