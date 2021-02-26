package com.icia.example10.service;

import java.time.format.*;
import java.util.*;

import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.icia.example10.dao.*;
import com.icia.example10.dto.*;
import com.icia.example10.entity.*;
import com.icia.example10.exception.*;

@Service
public class PostService {
	@Autowired
	private PostDao dao;
	private ModelMapper modelMapper = new ModelMapper();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Transactional(readOnly=true)
	public List<PostListDto> list() {
		List<Post> result = dao.findAll();
		List<PostListDto> list = new ArrayList<>();
		for(Post post:result) {
			PostListDto dto = modelMapper.map(post, PostListDto.class);
			dto.setWriteTimeString(formatter.format(post.getWriteTime()));
			list.add(dto);
		}
		return list;
	}

	public PostReadDto read(int pno) {
		Post result = dao.findById(pno);
		if(result==null)
			throw new PostNotFoundException();
		Post param = Post.builder().pno(pno).readCnt(1).build();
		dao.update(param);
		PostReadDto dto = modelMapper.map(result, PostReadDto.class);
		return dto.setWriteTimeString(formatter.format(result.getWriteTime()));
	}

	
	public int write(PostWriteDto dto) {
		Post post = modelMapper.map(dto, Post.class);
		dao.insert(post);
		return post.getPno();
	}

	public void delete(int pno, String password) {
		Post result = dao.findById(pno);
		if(result==null)
			throw new PostNotFoundException();
		boolean passwordCheck = result.getPassword().equals(password);
		if(passwordCheck==false)
			throw new JobFailException("글을 삭제하지 못했습니다");
		dao.delete(pno);
	}

	public void update(PostUpdateDto dto) {
		Post result = dao.findById(dto.getPno());
		if(result==null)
			throw new PostNotFoundException();
		boolean passwordCheck = result.getPassword().equals(dto.getPassword());
		if(passwordCheck==false)
			throw new JobFailException("글을 변경하지 못했습니다");
		Post param = modelMapper.map(dto, Post.class);
		dao.update(param);
	}
}