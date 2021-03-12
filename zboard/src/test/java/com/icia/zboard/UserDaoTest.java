package com.icia.zboard;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.icia.zboard.dao.UserDao;
import com.icia.zboard.entity.Level;
import com.icia.zboard.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class UserDaoTest {
	@Autowired
	private UserDao dao;
	
	//@Test
	public void initTest() {
		assertThat(dao, is(notNullValue()));
	}
	
	//@Test
	public void insertTest() {
		User user = new User("SPRING22", "1234", "홍길동", "spring@naver.com",
				LocalDate.now(), LocalDate.now(), 0, 0, Level.NORMAL, false, "SPRING22.JPG", "1234");
		assertThat(dao.insert(user), is(1));
	}
	
	@Test
	public void findByTest() {
		System.out.println(dao.findById("SPRING22"));
		assertThat(dao.findById("SPRING22").getLevel(), is(Level.NORMAL));
		assertThat(dao.findByEmail("spring@naver.com").getLevel(), is(Level.NORMAL));
		assertThat(dao.findByCheckCode("1234").getLevel(), is(Level.NORMAL));
	}
	/*
		체크코드를 확인 -> 체크코드 삭제, enabled를 변경
		비밀번호 변경
		내 정보 변경 : 비밀번호, 이메일, 프사
		로그인 실패 횟수 변경
		레벨 변경
		글쓴 횟수 변경
	*/
	//@Test
	@Transactional
	public void updateTest() {
		assertThat(dao.update(User.builder().username("SPRING22").enabled(true).checkCode("").build()), is(1));
		
		assertThat(dao.update(User.builder().username("SPRING22").password("1234").build()), is(1));
		
		User user = User.builder().username("SPRING22").email("spring@naver.com").profile("spring22.jpg").build();
		assertThat(dao.update(user), is(1));
		
		assertThat(dao.update(User.builder().username("SPRING22").loginFailureCnt(3).build()), is(1));
		
		assertThat(dao.update(User.builder().username("SPRING22").level(Level.SILVER).build()), is(1));
		
		assertThat(dao.update(User.builder().username("SPRING22").writeCnt(3).build()), is(1));
	}
	
	@Test
	@Transactional
	public void deleteByIdTest() {
		assertThat(dao.deleteById("SPRING22"), is(1));
	}
	
	@Test
	@Transactional
	public void deleteByCheckCodeIsNotNullTest() {
		assertThat(dao.deleteByCheckCodeIsNotNull(), is(1));
	}
}
