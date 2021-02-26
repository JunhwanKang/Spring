package com.icia.example10.dao;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.icia.example10.entity.*;

@Mapper
public interface PostDao {

	public List<Post> findAll();

	public Post findById(int pno);

	public int insert(Post post);

	public int update(Post post);
	
	public int delete(int pno);

}
