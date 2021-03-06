package com.icia.example15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example15.dao.PostDao;
import com.icia.example15.entity.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/*/*-context.xml")
public class PostDaoTest {
	@Autowired
	private PostDao dao;
	
	@Test
	public void findAllTest() {
		System.out.println(dao.findAll(11, 20));
	}
	@Transactional
	//@Test
	public void allTest() {
		Post post = new Post(0, "샘플", "샘플","1234", "test", null, 0);
		dao.insert(post);
		int pno = post.getPno()+1;
		Post result = dao.findById(post.getPno());
		assertEquals("test", result.getNickname());
		
		dao.update(post);
		dao.update(new Post(pno, "변경", "변경", "1234", "test", null, 0));
		assertEquals("변경", result.getTitle());
		
		dao.delete(pno);
		assertNull(dao.findById(post.getPno()));
		
	}
}
