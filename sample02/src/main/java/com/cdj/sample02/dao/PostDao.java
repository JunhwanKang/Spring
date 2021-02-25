package com.cdj.sample02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdj.sample02.entity.Post;

@Mapper
public interface PostDao {
	public List<Post> findAll();
	
	public Post findById(int pno);
	
	public int insert(Post post);
	
	public int update(Post post);
	
	public int delete(int pno);
	
}
