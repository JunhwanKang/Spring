package com.icia.zboard3.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class BoardController {
	@GetMapping({"/","/board/list"})
	public ModelAndView join() {
		return new ModelAndView("main").addObject("viewname", "board/list.jsp");
	}
}
