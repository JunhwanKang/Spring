package com.icia.example05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.icia.example05.dao.DepartmentDao;
import com.icia.example05.entity.Dept;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DepartmentDaoTest {
	@Autowired
	private DepartmentDao dao;
	
	//@Test
	public void insertTest() {
		Dept dept = new Dept(50, "IT", "SEOUL");
		assertEquals(1, dao.insert(dept));
	}
	//@Test
	public void findByIdTest() {
		Dept dept = dao.findById(50);
		assertEquals(dept.getDname(), "IT");
	}
	//@Test
	public void updateTest() {
		Dept dept = new Dept(50, "IT", "INCHEON");
		assertEquals(1, dao.update(dept));
	}
	//@Test
	public void deleteTest() {
		dao.delete(50);
		assertNull(dao.findById(50));
	}
	@Test
	public void existsByIdTest() {
		assertEquals(dao.existsById(40), true);
		assertEquals(dao.existsById(50), false);
	}
}
