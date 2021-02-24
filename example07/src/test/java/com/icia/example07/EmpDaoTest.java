package com.icia.example07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example07.dao.EmpDao;
import com.icia.example07.entity.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmpDaoTest {
	@Autowired
	private EmpDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	//@Test
	public void countTest() {
		log.info("{}", dao.count(0));
		log.info("{}", dao.count(10));
	}
	//@Test
	public void findAllTest() {
		assertEquals(14, dao.findAll().size());
		assertEquals(3, dao.findAllByDeptno(10).size());
		assertEquals(4, dao.findAllByJob("CLERK").size());
	}
	//@Test
	public void findByIdTest() {
		log.info("{}", dao.findById(7369));
		assertNotNull(dao.findById(7369));
		assertNull(dao.findById(9999));
	}
	@Transactional
	//@Test
	public void insertTest() {
		Emp emp = new Emp(null, "홍길동", "CLERK", 7369, 1000, LocalDate.now(), 100, 10);
		assertEquals(1, dao.insert(emp));
		//dao.insert(emp);
		//System.out.println(emp.getEmpno());
	}
	//@Test
	@Transactional
	public void updateTest() {
		Emp emp = Emp.builder().empno(7369).mgr(7500).build();
		dao.update(emp);
		
		Emp emp2 = Emp.builder().empno(7369).ename("Goose").mgr(7700).deptno(30).build();
		dao.update(emp2);
	}
	@Transactional
	@Test
	public void insertAllTest() {
		List<Emp> list = new ArrayList<>();
		list.add(new Emp(9000, "홍길동", "IT", 7369, 1000, LocalDate.now(), 100, 10)); 
		list.add(new Emp(9001, "전우치", "IT", 7369, 1000, LocalDate.now(), 100, 10)); 
		list.add(new Emp(9002, "임꺽정", "IT", 7369, 1000, LocalDate.now(), 100, 10));
		
		assertEquals(3, dao.insertAll(list));
	}
}
