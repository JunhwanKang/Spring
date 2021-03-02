package com.icia.example111.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SampleController {
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public ModelAndView test1() {
		return new ModelAndView("start");
	}
	
	@RequestMapping(value="/test1", method=RequestMethod.POST)
	public ModelAndView test1(@RequestParam MultipartFile sajin) {
		return new ModelAndView("end").addObject("sajin", sajin.getOriginalFilename());
	}
}
