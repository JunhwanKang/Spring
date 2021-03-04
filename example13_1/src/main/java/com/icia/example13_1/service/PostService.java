package com.icia.example13_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example13_1.dao.PostDao;
import com.icia.example13_1.dto.Page;
import com.icia.example13_1.entity.Post;

@Service
public class PostService {
	@Autowired
	private PostDao dao;
	@Value("10")
	private int PAGE_SIZE;
	@Value("5")
	private int BLOCK_SIZE;
	
	@Transactional(readOnly = true)
	public Page list(int pageno) {
		int count = dao.count();  // 총 글의 수
		int countOfPage = count/BLOCK_SIZE+1;            // 총 페이지의 갯수/ 만약 150개 씩 10 개 끊으면 15개
		if(count%BLOCK_SIZE==0)
			countOfPage--;
		
		pageno=Math.abs(pageno);
		if(pageno>countOfPage)
			pageno=countOfPage;
		if(pageno==0)
			pageno=1;
		
		// 이제 한페이지에 10개 글이 나오도록 처리하자
		// pageno      startRowNum      endRowNum
		// 	  1            1  	             10
		//    2            11                20
		//    3            21                30
		//    13           121               123
		int startRowNum = (pageno-1) * PAGE_SIZE +1;
		
		int endRowNum = pageno * PAGE_SIZE;
		if(endRowNum>count)
			endRowNum=count;
		
		// 이제 한 화면에 블록페이징 처리 / -> 이전 6|7|8|9|10 다음
		// pageno      blockNo
		//  1~5           1
		//  6~10          2
		//  11~13         3
		int blockNo = pageno/BLOCK_SIZE+1;
		if(pageno%BLOCK_SIZE==0)
			blockNo--;
		
		// blockNo        prev    start    end    next
		//    1            0        1       5      6
		//    2            5        6      10     11
		//    3           10       11      13      0
		int prev = (blockNo-1) * BLOCK_SIZE;
		int start = prev+1;		
		int end = blockNo*5;
		int next = end+1;
		
		if(end>=countOfPage) {
			end=countOfPage;
			next = 0;
		}
		List<Post> list = dao.findAll(startRowNum, endRowNum);
		return Page.builder().pageno(pageno).prev(prev)
				.end(end).list(list).next(next).start(start).build();
	}
}
