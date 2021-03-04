package com.icia.example13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icia.example13.dao.PostDao;
import com.icia.example13.entity.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class PostDaoTest {
	@Autowired
	private PostDao dao;
	
	//@Test
	public void insertTest() {
		for(int i=1; i<128; i++) {
			dao.insert(new Post(0, i+"번째 글", "내용없음", "spring", 0));
		}
	}
	@Test
	public void findAllTest() {
		dao.findAll(11, 20);
	}
}
