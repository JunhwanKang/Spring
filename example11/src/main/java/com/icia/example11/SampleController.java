package com.icia.example11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	@Autowired
	private java.util.Date date;
	
	@RequestMapping("/test1")
	public ModelAndView test1() {
		return new ModelAndView("test1").addObject("date", date);
	}
	
	@GetMapping("/test2")
	public ModelAndView test2(@RequestParam String irum) {
		return new ModelAndView("test2").addObject("irum", irum);
	}
	
	@GetMapping("/test3/start")
	public ModelAndView test3() {
		return new ModelAndView("test3/start");
	}
	
	@PostMapping("/test3/end")
	public ModelAndView test3(@RequestParam String irum) {
		return new ModelAndView("test3/end").addObject("irum", irum);
	}
	
	@GetMapping("/test4/start")
	public ModelAndView test4() {
		return new ModelAndView("test4/start");
	}
	
	@PostMapping("/test4/end")
	public ModelAndView test4(@RequestParam MultipartFile sajin) {
		return new ModelAndView("test4/end").addObject("sajin", sajin.getOriginalFilename());
	}
}
