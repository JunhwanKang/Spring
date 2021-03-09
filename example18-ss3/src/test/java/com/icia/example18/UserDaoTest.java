package com.icia.example18;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example18.dao.UserDao;
import com.icia.example18.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class UserDaoTest {
	@Autowired
	private UserDao dao;
	
	@Test
	public void initTest() {
		assertThat(dao, is(notNullValue()));
	}
	
	@Test
	public void findByIdTest() {
		assertThat(dao.findById("spring"), is(notNullValue()));
	}
	
	@Test
	@Transactional
	public void updateTest() {
		dao.update(User.builder().username("spring").loginFailureCnt(3).enabled(false).build());
		assertThat(dao.findById("spring").getLoginFailureCnt(), is(3));
	}
}
