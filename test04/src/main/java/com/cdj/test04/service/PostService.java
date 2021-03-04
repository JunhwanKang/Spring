package com.cdj.test04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cdj.test04.dao.PostDao;
import com.cdj.test04.dto.Page;
import com.cdj.test04.entity.Post;


@Service
public class PostService {
	@Autowired
	private PostDao dao;
	
	@Value("10")
	private int PAGE_SIZE;
	@Value("5")
	private int BLOCK_SIZE;
	
	public Page list(Integer pageno) {
		int count = dao.count(); // 글의 총 개수
		int countOfPage = count/PAGE_SIZE+1;
		if(count%PAGE_SIZE==0)
			countOfPage--;
		
		pageno = Math.abs(pageno);
		if(pageno==0)
			pageno=1;
		if(pageno>countOfPage)
			pageno=countOfPage;
		
		/* 만약에 총 글이 124개 있다면
		 *  pageno    spn      epn
		 *     1       1       10
		 *     2      11       20
		 *     3      21       30
		 *     .
		 *     .
		 *     .
		 *    12      111     120
		 *    13      121     124
		 */
		
		int startPageNum = (pageno-1)* PAGE_SIZE +1;
		int endPageNum = pageno*10;
		if(pageno*10>count)
			endPageNum = count;
		
		/*
		 *  pageno    blockNo
		 *   1~5         1
		 *   6~10        2
		 *   11~13       3
		 */
		
		int blockNo = pageno / BLOCK_SIZE+1;
		if(pageno % BLOCK_SIZE==0)
			blockNo--;
		
		/*
		 *  blockNo     prev   start   end   next
		 *     1         0       1      5     6   
		 *     2         5       6     10    11
		 *     3        10      11     13     0           
		 */
		int prev = (blockNo-1) * BLOCK_SIZE;
		int start = prev +1;
		int end = blockNo*BLOCK_SIZE;
		int next = end+1;
		
		if(blockNo*BLOCK_SIZE>countOfPage) {
			end = countOfPage;
			next = 0;
		}
		List<Post> list = dao.findAll(startPageNum, endPageNum); 
		return Page.builder().pageno(pageno).start(start)
				.end(end).prev(prev).list(list).next(next).build();
		
	}
}
