package com.icia.zboard3.dao;

import com.icia.zboard3.entity.*;

public interface UserDao {

	public User findById(String username);

	public User findByEmail(String email);

	public int insert(User user);
	
	public User findByCheckCode(String checkCode);
	
	public int update(User user);

	public void deleteByCheckCodeIsNotNull();
}
