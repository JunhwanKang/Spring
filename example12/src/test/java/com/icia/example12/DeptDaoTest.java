package com.icia.example12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icia.example12.dao.DeptDao;

// junit 4.12
// ** : 폴더 있을 수도 있고 없을 수도 있음
// *을주면 둘다 읽어옴(모든 파일이므로, 앞에 글자만 다름)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class DeptDaoTest {
	@Autowired
	private DeptDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	@Test
	public void findByIdTest() {
		assertEquals("CHICAGO", dao.findById(30).getLoc());
	}
}
