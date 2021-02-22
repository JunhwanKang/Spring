package com.icia.example05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.icia.example05.entity.Dept;

@Mapper
public interface SampleDao {
	@Select("select * from dept where deptno = #{deptno}")
	public Dept findById(int deptno);
	
	@Select("select * from dept where dname=#{dname}")
	public Dept findByDname(String dname);
	
	@Select("select * from dept where loc=#{loc}")
	public Dept findByLoc(String loc);
	
	@Select("select * from dept")
	public List<Dept> findAll();
	
	@Select("select * from dept where deptno=#{deptno} and dname=#{dname}")
	public Dept findByIdAndDname(int deptno, String dname);
	
	@Select("select * from dept where deptno=#{deptno} and dan,e=#{dname}")
	public Dept findByIdAndDnameVer2(Dept dept);
}