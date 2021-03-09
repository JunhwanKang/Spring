package com.icia.example17.controller;

import java.security.Principal;

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
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/user/require_login")
	public ModelAndView requiredLogin(Principal principal) {
		return new ModelAndView("require_login");
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/user/list")
	public ModelAndView user(Principal principal) {
		return new ModelAndView("user");
	}
}
