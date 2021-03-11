package com.icia.example20.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.example20.dto.SampleDto;

@Controller
public class SampleController {
	@GetMapping("/join1")
	public ModelAndView join1() {
		return new ModelAndView("join1");
	}
	@GetMapping("/join2")
	public ModelAndView join2() {
		return new ModelAndView("join2");
	}
	@GetMapping("/join3")
	public ModelAndView join3() {
		return new ModelAndView("join3");
	}
	@PostMapping("/join1")
	public ModelAndView join1(@ModelAttribute SampleDto.Join dto, @RequestParam(required=false) MultipartFile profile) {
		// ?username=&email=&profile=
		System.out.println(dto);
		System.out.println(profile);
		System.out.println(dto.getUsername()==null);
		System.out.println(dto.getEmail()==null);
		System.out.println(profile==null);
		System.out.println(dto.getUsername().equals(""));
		System.out.println(profile.isEmpty());
		return null;
	}
	@PostMapping("/join2")
	public ModelAndView join2(@ModelAttribute SampleDto.Join dto, @RequestParam List<MultipartFile> profile) {
		// 파일을 선택하지 않아도 profile의 크기는 1이다
		System.out.println(profile.size());
		System.out.println(profile==null);
		System.out.println(profile.isEmpty());
		if(profile.size()>0) {
			for(MultipartFile f:profile) {
				// 리스트의 파일에 대해서 비어있는지 확인이 필요하다
				if(f.isEmpty()==false)
					System.out.println(f.getContentType());
				else
					System.out.println("비어있습니다");
			}
		}
		return null;
	}
	@PostMapping("/join3")
	public ModelAndView join3(@ModelAttribute SampleDto.Join dto, @RequestParam List<MultipartFile> profile) {
		for(MultipartFile f:profile) {
			if(f.isEmpty()==false)
				System.out.println(f.getContentType());
			else
				System.out.println("비어있습니다");
		}
		return null;
	}
}
