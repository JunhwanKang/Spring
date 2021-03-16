package com.icia.zboard.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface AuthorityDao {
	@Insert("insert into authorities(username, authority) values(#{username}, #{authority})")
	// 마이바티스 2개를 넣을때 이렇게 한다고 했었다.
	public int insert(@Param("username") String username, @Param("authority") String authority);
	
	
}
