package com.icia.zboard3.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;

import com.icia.zboard3.dto.*;
import com.icia.zboard3.service.*;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/user/join")
	public ModelAndView join() {
		return new ModelAndView("main").addObject("viewname", "user/join.jsp");
	}
	
	@GetMapping("/user/login")
	public ModelAndView login() {
		return new ModelAndView("main").addObject("viewname", "user/login.jsp");
	}
	
	@GetMapping("/user/find")
	public ModelAndView find() {
		return new ModelAndView("main").addObject("viewname", "user/find.jsp");
	}
	
	@GetMapping("/user/join_check")
	public ModelAndView joinCheck(@RequestParam String checkCode) {
		service.joinCheck(checkCode);
		return new ModelAndView("main").addObject("viewname", "user/login.jsp");
	}
	
	@PostMapping("/user/reset_pwd")
	public ModelAndView resetPwd(@ModelAttribute @Valid UserDto.ResetPassword dto, BindingResult bindingResult,
			RedirectAttributes ra) throws BindException {
		if(bindingResult.hasErrors())
			throw new BindException(bindingResult);
		service.resetPwd(dto);
		ra.addFlashAttribute("msg", "임시비밀번호를 이메일로 전송했습니다");
		return new ModelAndView("redirect:/user/login");
	}
	
}








