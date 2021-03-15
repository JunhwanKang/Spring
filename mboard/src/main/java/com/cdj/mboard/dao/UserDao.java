package com.cdj.mboard.dao;

import com.cdj.mboard.entity.User;

public interface UserDao {
	public User findById(String username);
	
	public User findByEmail(String email);
	
	public User findByCheckCode(String checkCode);
	
	public int insert(User user);
	
	public int update(User user);
	
	public int deleteById(String username);
	
	public int deleteByCheckCodeIsNotNull();
}
