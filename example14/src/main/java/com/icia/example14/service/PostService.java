package com.icia.example14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.example14.dao.PostDao;
import com.icia.example14.dto.Page;
import com.icia.example14.entity.Post;

@Service
public class PostService {
	@Autowired
	private PostDao dao;
	
	public Post read(Integer pno) {
		return dao.findById(pno);
	}

	public Page list(Integer pageno) {
		// 서비스는 DAO로 작업한느 클래스
		// page계산이 너무 길어서 pagingUtil 클래스로 분리 -> DB 접근은 넘겨주지 않는다 -> 계산만!!
		int count = dao.count();
		page = PagingUtil.getPage(count, pageno);
		List<Post> list = dao.findAll(page.getStartRowNum(), page.getEndRowNum());
		return page.setList(list);
	}
}
