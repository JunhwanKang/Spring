package com.cdj.test04;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cdj.test04.dao.PostDao;
import com.cdj.test04.entity.Post;

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
	public void insert1() {
		for(int i=1; i<124; i++) {
			dao.insert(new Post(0, i+"번째 글", "내용", "nick", LocalDateTime.now(), 0));
		}
	}
	//@Test
	public void findAllTest() {
		dao.findAll(1, 5);
	}
}
