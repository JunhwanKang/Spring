package com.icia.example15.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.example15.entity.Post;
import com.icia.example15.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService service;
	
	@GetMapping({"/", "/post/list"})
	public ModelAndView list(@RequestParam(defaultValue = "1") int pageno) {
		return new ModelAndView("main").addObject("viewname","post/list.jsp").
				addObject("page", service.list(pageno));
	}
	
	@GetMapping("/post/write")
	public ModelAndView write() {
		return new ModelAndView("main").addObject("viewname","post/write.jsp");
	}
	
	@GetMapping("/post/read")
	public ModelAndView read(@RequestParam Integer pno) {
		return new ModelAndView("main").addObject("viewname","post/read.jsp")
				.addObject("post", service.read(pno));
	}
	@PostMapping("/post/write")
	public ModelAndView write(@ModelAttribute @Valid Post post, BindingResult bindingResult) throw {
		if(bindingResult.hasErrors())
			throw new BindException(bindingResult);
		service.insert(post);
		return new ModelAndView("redirect:/");
	}
	@PostMapping("/post/update")
	public ModelAndView update(@ModelAttribute @Valid Post post, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			throw new BindException(bindingResult);
		service.update(post);
		return new ModelAndView("redirect:/");
	}
	@PostMapping("/post/delete")
	public ModelAndView delete(@RequestParam Integer pno) {
		service.delete(pno);
		return new ModelAndView("redirect:/");
	}
}