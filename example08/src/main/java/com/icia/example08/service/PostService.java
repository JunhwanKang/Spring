package com.icia.example08.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.icia.example08.dao.*;
import com.icia.example08.entity.*;

@Service
public class PostService {
	@Autowired
	private PostDao dao;
	
	public List<Post> list() {
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
		System.out.println(password);
		System.out.println(result.getPassword());
		if(password.equals(result.getPassword())==true)
			dao.delete(pno);
	}

}





