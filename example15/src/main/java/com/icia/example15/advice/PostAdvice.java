package com.icia.example15.advice;

import java.net.BindException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.example15.service.JobFailException;

@ControllerAdvice
public class PostAdvice {
	@ExceptionHandler(BindException.class)
	public ModelAndView bindExceptionHandler(BindException e, RedirectAttributes ra) {
		String msg = e.getAll
	}
	@ExceptionHandler(JobFailException.class)
	public ModelAndView jobFailExceptionHandler(JobFailException e, RedirectAttributes ra) {
		
	}
}
