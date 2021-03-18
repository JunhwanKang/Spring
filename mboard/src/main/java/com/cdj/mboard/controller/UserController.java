package com.cdj.mboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdj.mboard.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/user/join")
	public ModelAndView join() {
		return new ModelAndView("main").addObject("viewname", "user/join.jsp");
	}
	@GetMapping("/user/imgtq")
	public ModelAndView img() {
		return new ModelAndView("main").addObject("viewname", "user/imgtq.jsp");
	}
	
	@GetMapping("/user/login")
	public ModelAndView login() {
		return new ModelAndView("main").addObject("viewname", "user/login.jsp");
	}
	
	@GetMapping("/user/join_check")
	public ModelAndView joinCheck(@RequestParam String checkCode) {
		service.joinCheck(checkCode);
		return new ModelAndView("redirect:/user/login");
	}
	
	
}
