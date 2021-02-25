package com.cdj.sample02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdj.sample02.dao.PostDao;
import com.cdj.sample02.entity.Post;

@Service
public class PostService {
	/* 모든 글 읽기: 모든 글을 가져오자
	 * 글 읽기 : 글을 누르면 해당 글을 읽자
	 * 쓰기: 글을 쓰자
	 * 수정: 글을 수정하자
	 * 삭제: 모든 글을 지우자
	 */
	@Autowired
	private PostDao dao;
	
	public List<Post> readAll() {
		return dao.findAll();
	}
	
	public Post read(int pno) {
		return dao.findById(pno);
	}
	
	public void write(Post post) {
		dao.insert(post);
	}
	
	public void update(Post post) {
		Post result = dao.findById(post.getPno());
		if(post.getPassword().equals(result.getPassword())==true)
			dao.update(post);
	}
	
	public void delete(int pno, String password) {
		Post result = dao.findById(pno);
		if(password.equals(result.getPassword())==true)
			dao.delete(pno);
	}
}
