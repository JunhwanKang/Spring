package com.icia.example07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.example07.entity.Emp;

@Mapper
public interface EmpDao {
	public int count(int deptno);
	
	public List<Emp> findAll();
	
	public List<Emp> findAllByDeptno(int deptno);
	
	public List<Emp> findAllByJob(String job);
	
	public Emp findById(int empno);
	
	public int insert(Emp emp);
	
	public int update(Emp emp);
	
	public int delete(int empno);
	
	public int insertAll(List<Emp> list);
}
