package com.cdj.test03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cdj.test03.entity.Post;

public interface PostDao {
	public Integer count();
	
	public List<Post> findAll(@Param("startPageNum") int startPageNum, @Param("endPageNum") int endPageNum);
}
