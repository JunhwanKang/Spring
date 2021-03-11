package com.icia.test05.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestController {
	ObjectMapper mapper = new ObjectMapper();
	
	@Value("c:/upload/image")
	String uploadFolderName;
	@Value("http://localhost:8081/image/")
	String uploadFilePath;
	
	@GetMapping("/write")
	public ModelAndView write() {
		return new ModelAndView("write");
	}
	
	@GetMapping("/upload")
	public ModelAndView fileUpload() {
		return new ModelAndView("upload");
	}
	
	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam MultipartFile file) {
		System.out.println("파일의 파라미터 이름: " + file.getName()); 
		System.out.println("파일의 실제 이름:" + file.getOriginalFilename());
		System.out.println("파일의 사이즈: " + file.getSize());
		
		return null;
	}
	@GetMapping("/upload2")
	public ModelAndView fileUpload2() {
		return new ModelAndView("upload2");
	}
	
	@PostMapping("/upload2")
	public ModelAndView fileUpload2(@RequestParam List<MultipartFile> file) {
		//System.out.println(file.size());
		//System.out.println(file==null);
		//System.out.println(file.isEmpty());
		
		if(file.size()>0) {
			for(MultipartFile f:file) {
				System.out.println("f:"+ (f==null));
				System.out.println("f:"+f.isEmpty());
				
				if(f.isEmpty()==false)
					System.out.println(f.getContentType());
				else
					System.out.println("비어있습니다.");
			}
		}
		return null;
	}
	
	@PostMapping("/ck_upload")
	public ResponseEntity<?> ckUpload(@RequestParam MultipartFile upload){
		Map<String, Object> map = new HashMap<String, Object>();
		if(upload!=null && upload.isEmpty()==false) {
			if(upload.getContentType().toLowerCase().startsWith("image/")) {
				String imageName = System.currentTimeMillis() + ".jpg";
				
				File file = new File(uploadFolderName, imageName);
				try {
					FileCopyUtils.copy(upload.getBytes(), file);
					map.put("uploaded", 1);
					map.put("fileName", imageName);
					map.put("url", uploadFilePath + imageName);
					String json = mapper.writeValueAsString(map);
					System.out.println(map);
					System.out.println(json);
					return ResponseEntity.ok(json);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
