package com.icia.example08.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.icia.example08.entity.*;
import com.icia.example08.service.*;

@Controller
public class PostController {
	@Autowired
	private PostService service;
	
	@GetMapping({"/", "/post/list"})
	public ModelAndView list() {
		List<Post> list = service.list();
		return new ModelAndView("main").addObject("viewname", "post/list.jsp").addObject("list", list);
	}
	
	@GetMapping("/post/read")
	public ModelAndView read(@RequestParam int pno) {
		Post post = service.read(pno);
		return new ModelAndView("main").addObject("viewname", "post/read.jsp").addObject("post", post);
	}
	
	@GetMapping("/post/write")
	public ModelAndView write() {
		return new ModelAndView("main").addObject("viewname", "post/write.jsp");
	}
	
	@PostMapping("/post/write")
	public ModelAndView write(@ModelAttribute Post post) {
		service.write(post);
		return new ModelAndView("redirect:/post/list");
	}
	
	@PostMapping("/post/update")
	public ModelAndView update(@ModelAttribute Post post) {
		service.update(post);
		return new ModelAndView("redirect:/post/list");
	}
	
	@PostMapping("/post/delete")
	public ModelAndView delete(@RequestParam int pno, @RequestParam String password) {
		service.delete(pno, password);
		return new ModelAndView("redirect:/post/list");
	}
}
