package com.icia.example17;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icia.example17.dao.UserDao;
import com.icia.example17.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class UserDaoTest {
	@Autowired
	private UserDao dao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	//@Test
	public void initTest() {
		assertThat(dao, is(notNullValue()));
	}
	@Test
	public void insertTest() {
		String password = passwordEncoder.encode("1234");
		User user = User.builder().username("spring").password(password).email("spring@naver.com")
				.irum("홍길동").build();
		assertThat(dao.insert(user), is(1));
	}
}
