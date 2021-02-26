package com.icia.example10.advice;

import javax.servlet.http.*;

import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;

import com.icia.example10.exception.*;

@ControllerAdvice
public class PostControllerAdvice {
	@ExceptionHandler(BindException.class)
	public ModelAndView BindExceptionHandler(BindingResult results, RedirectAttributes ra, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		String previousUrl = referer.substring(22);
		String msg = results.getAllErrors().get(0).getDefaultMessage();
		ra.addFlashAttribute("msg", msg);
		return new ModelAndView("redirect:/" + previousUrl);
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public ModelAndView postNotFoundExceptionHandler(RedirectAttributes ra) {
		ra.addFlashAttribute("msg", "글을 찾을 수 없습니다");
		return new ModelAndView("redirect:/post/list");
	}
	
	@ExceptionHandler(JobFailException.class)
	public ModelAndView JobFaileExceptionHandler(JobFailException e, RedirectAttributes ra) {
		ra.addFlashAttribute("msg", e.getMessage());
		return new ModelAndView("redirect:/post/list");
	}
}
