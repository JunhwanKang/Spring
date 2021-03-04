package com.icia.example14.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.example14.entity.Post;

@Repository
public class PostDao {
	@Autowired
	private SqlSessionTemplate tpl;
	
	public int count() {
		// insert update delete selectOne selectList
		return tpl.selectOne("postMapper.count");
	}
	
	public Post findById(int pno) {
		return tpl.selectOne("postMapper.findById", pno);
	}
	
	public List<Post> findAll(int startRowNum, int endRowNum){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		return tpl.selectList("postMapper.findAll", map);
	}
	
	public int insert(Post post) {
		//System.out.println(post);  // 찍어 볼 수 있다.
		return tpl.insert("postMapper.insert", post);
	}
	
	public int update(Post post) {
		return tpl.update("postMapper.update", post);
	}
	
	public int delete(int pno) {
		return tpl.delete("postMapper.delete", pno);
	}
}
