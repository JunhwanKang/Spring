package com.icia.example12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icia.example12.dao.PostDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class PostDaoTest {
	@Autowired
	private PostDao dao;
	
	@Test
	public void test1() {
		System.out.println(dao.count());
		System.out.println(dao.findAll(2, 4));
	}
}
