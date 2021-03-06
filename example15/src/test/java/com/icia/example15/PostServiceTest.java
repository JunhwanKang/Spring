package com.icia.example15;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example15.dto.Page;
import com.icia.example15.entity.Post;
import com.icia.example15.service.PostService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/*/*-context.xml")
public class PostServiceTest {
	@Autowired
	private PostService service;
	
	//@Test
	public void listTest() {
		Page page = service.list(2);
		assertThat(page.getList().size(), is(10));
		assertThat(page.getPrev(), is(0));
		assertThat(page.getStart(), is(1));
		assertThat(page.getEnd(), is(5));
		assertThat(page.getNext(), is(6));
	}
	@Transactional
	@Test
	public void insertAndUpdateTest() {
		Post p1 = new Post(0, "서비스", "서비스", "1234", "spring", null, null);
		service.insert(p1);
		Post p2 = new Post(p1.getPno()+1, "변경", "변경", "1234", null, null, null);
		service.update(p2);
	}
}
