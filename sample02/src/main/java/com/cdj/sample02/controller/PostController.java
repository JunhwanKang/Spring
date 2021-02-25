package com.cdj.sample02.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdj.sample02.entity.Post;
import com.cdj.sample02.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService service;
	
	@GetMapping({"/","/post/list"})
	public ModelAndView list() {
		List<Post> list = service.readAll();
		return new ModelAndView("main").addObject("viewpage", "post/list.jsp").addObject("list", list);
	}
	@GetMapping("/post/read")
	public ModelAndView read(@RequestParam int pno) {
		Post post = service.read(pno);
		return new ModelAndView("main").addObject("viewpage", "post/read.jsp").addObject("post", post);
	}
	@GetMapping("/post/write")
	public ModelAndView write() {
		return new ModelAndView("main").addObject("viewpage", "post/write.jsp");
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
