package com.cdj.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cdj.daoTest.dao.StudentDao;
import com.cdj.daoTest.entity.Student;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentDaoTest {
	@Autowired
	public StudentDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	//@Test
	public void insertTest() {
		Student student = new Student(1,"홍길동", "컴퓨터학과");
		assertEquals(1, dao.insert(student));
	}
	//@Test
	public void selectTest() {
		//assertEquals("홍길동", dao.findById(1).getSname());
		assertNotNull(dao.findById(1));
	}
	//@Test
	public void findAllTest() {
		assertEquals(1, dao.findAll().size());
	}
	@Test
	public void existsByIdTest() {
		assertEquals(true, dao.existsById(1));
	}
	//@Test
	public void update() {
		Student student = new Student(1,"홍길동", "IT");
		assertEquals(1, dao.update(student));
	}
	//@Test
	public void deleteTest() {
		assertEquals(1, dao.delete(1));
	}
}
