package com.cdj.daoTest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cdj.daoTest.entity.Student;

@Mapper
public interface StudentDao {
// 기본 메소드 CRUD   -> insert, select(read), update, delete
	@Insert("insert into student values (#{sno}, #{sname}, #{sdept})")
	public int insert(Student student);
	
	@Select("select * from student where sno=#{sno}") 
	public Student findById(int sno);
	
	@Select("select * from student")
	public List<Student> findAll();
	
	@Select("select count(*) from student where sno=#{sno}")
	public boolean existsById(int sno);
	
	@Update("update student set sname=#{sname}, sdept=#{sdept} where sno=#{sno}")
	public int update(Student student);
	
	@Delete("delete from student where sno=#{sno}")
	public int delete(int sno);
}
