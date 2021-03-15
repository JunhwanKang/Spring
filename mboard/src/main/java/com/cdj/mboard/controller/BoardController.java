package com.cdj.mboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@GetMapping("/")
	public ModelAndView main() {
		return new ModelAndView("main").addObject("viewname", "board/list.jsp");
	}
}
