package com.icia.example061.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.example061.entity.Dept;

@Mapper
public interface DeptDao {
	public int insert(Dept dept);
	
	public Dept findById(int deptno);
	
	public List<Dept> findAll();
	
	public boolean existsById(int deptno);
	
	public int update(Dept dept);
	
	public int delete(int deptno);
}
