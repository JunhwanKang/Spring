package com.icia.example041.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.example041.dto.LoginDto;

@Controller
public class TestController {
	@GetMapping("/list")
	public ModelAndView list() {
		return new ModelAndView("list");
	}
	
	@PostMapping("/login1")
	public ModelAndView login1(@ModelAttribute @Valid LoginDto dto, BindingResult bindingResult) throws BindException{
		if(bindingResult.hasErrors())
			throw new BindException(bindingResult);
		return new ModelAndView("redirect:/list");
	}
	
	@GetMapping("/login")
	public ModelAndView login1() {
		return new ModelAndView("login");
	};
	
	@ExceptionHandler(BindException.class)
	public ModelAndView bindExceptionHandler(BindingResult bindingResult, RedirectAttributes ra) {
		System.out.println("===================================");
		String msg = bindingResult.getAllErrors().get(0).getDefaultMessage();
		ra.addFlashAttribute("msg",msg);
		return new ModelAndView("redirect:/list");
	}
}
//정규식
