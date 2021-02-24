package com.icia.example07;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example07.dao.BoardDao;
import com.icia.example07.entity.Board;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardDaoTest {
	@Autowired
	private BoardDao dao;
	
	//@Test
	public void initTest() {
		assertNotNull(dao);
	}
	//@Test
	public void insertAllTest() {
		Board b1 = new Board(dao.getSequence(), "첫번째 글", "내용없음", "spring", null, null);
		Board b2 = new Board(dao.getSequence(), "두번째 글", "내용없음", "summer", null, null);
		Board b3 = new Board(dao.getSequence(), "세번째 글", "내용없음", "spring", null, null);
		List<Board> list = Arrays.asList(b1, b2, b3);
		
		dao.insertAll(list);
	}
	@Transactional
	@Test
	public void updateTest() {
		Board b1 = Board.builder().title("글제목 변경").content("내용없어요").bno(1).build();
		dao.update(b1);
		
		Board b2 = Board.builder().readCnt(11).bno(1).build();
		dao.update(b2);
	}
}
