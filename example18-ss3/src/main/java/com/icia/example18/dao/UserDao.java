package com.icia.example18.dao;

import com.icia.example18.entity.User;

public interface UserDao {
	public User findById(String username);
	
	public int update(User user);
	
	public int insert(User user);
}
