package com.icia.example12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example12.dao.EmpDao;
import com.icia.example12.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class EmpDaoTest {
	@Autowired
	private EmpDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	//@Test
	public void findAllTest() {
		assertEquals(14, dao.findAll().size());
	}
	//@Test
	public void findByIdTest() {
		assertEquals("SMITH", dao.findById(7369).getEname());
	}
	//@Test
	public void findAllByJob() {
		assertEquals(4, dao.findAllByJob("SALESMAN").size());
	}
	//@Test
	public void findAllByJobAndDeptnoTest() {
		assertEquals(3, dao.findAllByJobAndDeptno("SALESMAN", 30).size());
	}
	//@Test
	@Transactional
	public void insertTest() {
		Emp emp = new Emp(0, "spring", "SALESMAN", 7369, 1000, null, 10);
		assertEquals(1, dao.insert(emp));
	}
	@Test
	@Transactional
	public void updateTest() {
		Emp emp = new Emp(7369, null, "IT", null, 5000, 1000, 20);
		assertEquals(1, dao.update(emp));
	}
}
