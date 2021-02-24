package com.icia.example07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.icia.example07.entity.Board;

@Mapper
public interface BoardDao {
	public int count();
	public int countByWriter(String writer);
	
	public List<Board> findAll();
	public List<Board> findAllByWriter(String writer);
	
	public Board findById();
	
	public int insert(Board board);
	
	public int getSequence();
	public int insertAll(List<Board> board);
	
	public int update(Board board);
	
	public int delete(int bno);
	public int deleteByWriter(String writer);
	
	
	
	
	
	
	
	
	
}
