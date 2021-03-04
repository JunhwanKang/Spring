package com.cdj.test03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cdj.test03.dao.PostDao;
import com.cdj.test03.dto.Page;
import com.cdj.test03.entity.Post;

@Service
public class PostService {
	// 페이징 처리 해보자!!
	@Autowired
	private PostDao dao;
	
	@Value("10")
	private int PAGE_SIZE;
	
	@Value("5")
	private int BLOCK_SIZE;
	
	public Page list(Integer pageno){
		
		int count = dao.count();
		int countOfPage = count/PAGE_SIZE+1;
		if(count%PAGE_SIZE==0)
			countOfPage--;
		
		pageno = Math.abs(pageno);
		if(pageno==0)
			pageno=1;
		if(pageno>countOfPage)
			pageno = countOfPage;
		
		int startPageNum = (pageno-1)*PAGE_SIZE+1;
		int endPageNum = pageno*PAGE_SIZE;
		if(endPageNum>count)
			endPageNum=count;
		
		int blockNo = pageno/BLOCK_SIZE+1;
		if(pageno%BLOCK_SIZE==0)
			blockNo--;
		
		int prev = (blockNo-1) * 5;
		int start = prev+1;
		int end = blockNo * 5;
		int next = end+1;
		
		if(end>=countOfPage) {
			end=countOfPage;
			next=0;
		}
		
		List<Post> list = dao.findAll(startPageNum, endPageNum);
		
		return Page.builder().end(end).list(list).next(next).pageno(pageno).prev(prev).start(start).build();
		
	}
}
