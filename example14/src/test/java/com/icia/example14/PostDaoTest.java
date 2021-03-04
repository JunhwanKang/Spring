package com.icia.example14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example14.dao.PostDao;
import com.icia.example14.entity.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class PostDaoTest {
	@Autowired
	private PostDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	//@Test
	public void countTest() {
		assertEquals(130, dao.count());
	}
	//@Test
	public void findIdTest() {
		System.out.println(dao.findById(111));
	}
	@Transactional
	//@Test
	public void insertTest() {
		dao.insert(new Post(0, "헬로", "안녕", "spring", LocalDateTime.now(), 0));
	}
}
