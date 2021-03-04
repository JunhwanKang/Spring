package com.icia.example13.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icia.example13.entity.Post;

public interface PostDao {
	public int count();
	
	public List<Post> findAll(@Param("startRowNum") int startRowNum, @Param("endRowNum") int endRowNum);
	
	public int insert(Post post);
}
