package com.icia.example14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.example14.entity.Post;
import com.icia.example14.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService service;
	
	@GetMapping("/post/read")
	public @ResponseBody Post read(@RequestParam Integer pno) {
		return service.read(pno);
	}
	
	@GetMapping("/post/list")
	public @ResponseBody Page list(@RequestParam(defaultValue = "1") Integer pageno) {
		return service.list(pageno);
	}
}
