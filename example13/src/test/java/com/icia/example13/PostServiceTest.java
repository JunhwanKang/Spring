package com.icia.example13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icia.example13.service.PostService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class PostServiceTest {
	@Autowired
	private PostService service;
	
	@Test
	public void listTest() {
		for(int i=-3; i<20; i++) {
			System.out.println(service.list(i));
		}
	}
}
