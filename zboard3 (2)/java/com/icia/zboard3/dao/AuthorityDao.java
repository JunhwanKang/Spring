package com.icia.zboard3.dao;

import org.apache.ibatis.annotations.*;

public interface AuthorityDao {
	@Insert("insert into authorities values(#{authority}, #{username})")
	public int insert(@Param("username") String username, @Param("authority") String authority);
}
