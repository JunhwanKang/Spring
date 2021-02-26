package com.icia.example10.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;

import com.icia.example10.dto.*;
import com.icia.example10.service.*;

@Controller
public class PostController {
	@Autowired
	private PostService service;
	
	@RequestMapping(value={"/","/post/list"}, method=RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("main").addObject("viewname","post/list.jsp").addObject("list", service.list());
	}
	
	@RequestMapping(value="/post/read", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam int pno) {
		return new ModelAndView("main").addObject("viewname","post/read.jsp").addObject("post", service.read(pno));
	}
	
	@RequestMapping(value="/post/write", method=RequestMethod.GET)
	public ModelAndView write() {
		return new ModelAndView("main").addObject("viewname","post/write.jsp");
	}
	
	@RequestMapping(value="/post/write", method=RequestMethod.POST)
	public ModelAndView write(@ModelAttribute @Valid PostWriteDto dto, BindingResult bindingResult) throws BindException {
		if(bindingResult.hasErrors())
			throw new BindException(bindingResult);
		System.out.println(dto);
		int pno = service.write(dto);
		return new ModelAndView("redirect:/post/read?pno=" + pno);
	}
	
	@RequestMapping(value="/post/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute @Valid PostUpdateDto dto, BindingResult bindingResult, RedirectAttributes ra) {
		service.update(dto);
		ra.addFlashAttribute("msg", "글을 변경했습니다");
		return new ModelAndView("redirect:/post/list");
	}
	
	@RequestMapping(value="/post/delete", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam int pno, @RequestParam String password, RedirectAttributes ra) {
		service.delete(pno, password);
		ra.addFlashAttribute("msg", "글을 삭제했습니다");
		return new ModelAndView("redirect:/post/list");
	}
}
