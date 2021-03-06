package com.icia.example15.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.example15.dao.PostDao;
import com.icia.example15.dto.Page;
import com.icia.example15.dto.PostReadDto;
import com.icia.example15.entity.Post;
import com.icia.example15.util.PagingUtil;

@Service
public class PostService {
	@Autowired
	private PostDao dao;
	@Autowired
	private DateTimeFormatter dateTimeFormatter;
	@Autowired
	private ModelMapper modelMapper;
	
	public PostReadDto read(int pno) {
		Post post = dao.findById(pno);
		if(post==null)
			throw new JobFailException("글을 찾을 수 없습니다");
		PostReadDto dto = modelMapper.map(post, PostReadDto.class);
		dto.setWriteTimeString(dateTimeFormatter.format(post.getWriteTime()));
		return dto;
	}
	
	public void delete(int pno) {
		dao.delete(pno);
	}
	
	public Page list(int pageno) {
		int count = dao.count();
		Map<String, Object> map = PagingUtil.getPage(count, pageno);
		int startRowNum = (Integer) map.get("startRowNum");
		int endRowNum = (Integer)map.get("endRowNum");
		Page page = (Page)map.get("page");
		
		List<Post> list = dao.findAll(startRowNum, endRowNum);
		page.setList(list);
		return page;
	}
	
	public void insert(Post post) {
		dao.insert(post);
	}
	public void update(Post post) {
		//비밀번호를 확인 후 변경
		Post result = dao.findById(post.getPno());
		if(result==null)
			throw new JobFailException("글을 찾을 수 없습니다");
		boolean passwordCheck = result.getPassword().equals(post.getPassword());
		if(passwordCheck==false)
			throw new JobFailException("잘못된 비밀번호입니다");
		dao.update(post);
	}
	
	
}
