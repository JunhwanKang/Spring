package com.icia.example12.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icia.example12.entity.Post;

public interface PostDao {
	public int count();
	
	public List<Post> findAll(@Param("startRowNum") int startRowNum, @Param("endRowNum") int endRowNum);
	
}
