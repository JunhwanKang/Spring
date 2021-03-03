package com.icia.example12.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icia.example12.entity.Emp;

public interface EmpDao {
	public List<Emp> findAll();
	public Emp findById(Integer empno);
	
	public List<Emp> findAllByJob(String job);
	// 마이바티스는 파라미터를 2개 넘길 때 이름을 지정해야한다
	public List<Emp> findAllByJobAndDeptno(@Param("job") String job, @Param("deptno") Integer deptno);
	
	public int insert(Emp emp);
	
	public int update(Emp emp);
	
	public int delete(Integer empno);
}
