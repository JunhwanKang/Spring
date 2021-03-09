package com.icia.example16.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	@GetMapping("/user/list")
	public ModelAndView user(Principal principal) {
		System.out.println(principal.getName());
		return new ModelAndView("user_list");
	}
	@GetMapping("/admin/list")
	public ModelAndView admin(Principal principal) {
		System.out.println(principal.getName());
		return new ModelAndView("admin_list");
	}
	@GetMapping("/guest/list")
	public ModelAndView guest(Principal principal) {
		System.out.println(principal.getName());
		return new ModelAndView("guest_list");
	}
	@GetMapping("/everyone/list")
	public ModelAndView everyone(Principal principal) {
		if(principal!=null)
			System.out.println(principal.getName());
		return new ModelAndView("everyone_list");
	}
	
	@GetMapping("/e403")
	public ModelAndView e403() {
		return new ModelAndView("e403");
	}
	
	@GetMapping("/")
	public ModelAndView main() {
		return new ModelAndView("main");
	}
	@GetMapping("/system/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
}