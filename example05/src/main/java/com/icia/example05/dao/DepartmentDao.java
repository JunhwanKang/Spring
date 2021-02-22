package com.icia.example05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.icia.example05.entity.Dept;
// insert, delete, update의 결과값은 void 또는 int
// int인 경우는 영향을 받은 행의 개수
@Mapper
public interface DepartmentDao {
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	public int insert(Dept dept);
	
	@Select("select * from dept where deptno=#{deptno}")
	public Dept findById(int deptno);
	
	@Select("select * from dept")
	public List<Dept> findAll();
	
	@Update("update dept set dname=#{dname}, loc=#{loc} where deptno=#{deptno} and rownum=1")
	public int update(Dept dept);
	
	@Delete("delete from dept where deptno=#{deptno} and rownum=1")
	public int delete(int deptno);
	
	@Select("select count(*) from dept where deptno=#{deptno} and rownum=1")
	public boolean existsById(int deptno);
}
