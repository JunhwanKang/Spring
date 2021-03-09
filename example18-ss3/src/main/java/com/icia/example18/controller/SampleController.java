package com.icia.example18.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	@GetMapping("/")
	public ModelAndView main() {
		return new ModelAndView("main");
	}
	
	@PreAuthorize("isAnonymous()")
	@GetMapping("/user/login")
	public ModelAndView login(HttpSession session) {
		if(session.getAttribute("msg")!=null) {
			String msg = (String)session.getAttribute("msg");
			session.removeAttribute("msg");
			return new ModelAndView("login").addObject("msg", msg);
		}
		return new ModelAndView("login");
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/user/list")
	public ModelAndView user() {
		return new ModelAndView("user_list");
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/list")
	public ModelAndView admin() {
		return new ModelAndView("admin_list");
	}
	
	@GetMapping("/system/e403")
	public ModelAndView e403() {
		return new ModelAndView("e403");
	}
}
