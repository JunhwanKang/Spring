package com.cdj.sample02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cdj.sample02.dao.PostDao;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SampleTest {
	@Autowired
	private PostDao dao;
	
	@Test
	public void findAllTest() {
		assertEquals(3, dao.findAll().size());
	}
}
