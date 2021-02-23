package com.icia.example06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.example06.entity.Dept;

@Mapper
public interface DeptDao {
	public Dept findById(int deptno);
	
	public List<Dept> findAll();
	
	public int insert(Dept dept);
	
	public int update(Dept dept);
	
	public int delete(int deptno);
	
	public boolean existsById(int deptno);
}
