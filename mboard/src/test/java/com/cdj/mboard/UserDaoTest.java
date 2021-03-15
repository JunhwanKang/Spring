package com.cdj.mboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cdj.mboard.dao.UserDao;
import com.cdj.mboard.entity.Level;
import com.cdj.mboard.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class UserDaoTest {
	@Autowired
	private UserDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
		//assertThat(dao, is(notNullValue()));
	}
	
	@Test
	public void insertTest() {
		User user = User.builder().username("USER123456").password("1234").irum("ȫ�浿").email("user123@naver.com")
				.joinday(LocalDate.now()).birthday(LocalDate.now()).loginFailureCnt(3).writeCnt(2)
				.level(Level.GOLD).enabled(false).profile("user123.jpg").checkCode("1111").build();
		assertEquals(1, dao.insert(user));		
	}
	
	//@Test
	public void findByIdTest() {
		assertEquals("ȫ�浿", dao.findById("user123").getIrum());
	}
	
	//@Test
	public void findByEmailTest() {
		assertEquals("ȫ�浿", dao.findByEmail("user123@naver.com").getIrum());
	}
	
	//@Test
	public void findByCheckCodeTest() {
		assertEquals("ȫ�浿", dao.findByCheckCode("1111").getIrum());
	}
	
	//@Test
	@Transactional
	public void updateTest() {
		//üũ �ڵ�Ȯ�ν� ���� -> enabled true
		//��й�ȣ ����
		// ������ ���� : �̸���/ ����
		// �α��� ���� Ƚ�� ����
		// ���� ����
		// �۾� Ƚ�� ����
		assertEquals(1, dao.update(User.builder().username("user123").checkCode("").enabled(true).build()));
		
		assertEquals(1, dao.update(User.builder().username("user123").password("1111").build()));
		
		assertEquals(1, dao.update(User.builder().username("user123").email("user1234@naver.com").profile("user1234.jpg").build()));
		
		assertEquals(1, dao.update(User.builder().username("user123").loginFailureCnt(2).build()));
		
		assertEquals(1, dao.update(User.builder().username("user123").level(Level.GOLD).build()));
		
		assertEquals(1, dao.update(User.builder().username("user123").writeCnt(0).build()));
	}
	
	//@Test
	@Transactional
	public void deleteTest() {
		assertEquals(1, dao.deleteById("user123"));
	}
	
	//@Test
	@Transactional
	public void deleteByCheckCodeIsNotNullTest() {
		assertEquals(1, dao.deleteByCheckCodeIsNotNull());
	}
	
}
