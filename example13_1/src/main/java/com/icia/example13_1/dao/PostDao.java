package com.icia.example13_1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icia.example13_1.entity.Post;

public interface PostDao {
	public int count();
	
	public List<Post> findAll(@Param("startRowNum") int startRowNum, @Param("endRowNum") int endRowNum);
	
	public int insert(Post post);
}
