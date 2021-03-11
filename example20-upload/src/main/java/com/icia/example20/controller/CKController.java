package com.icia.example20.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
public class CKController {
	// 자바 객체를 json으로 변환하기 위해서 Jackson객체를 생성
	ObjectMapper mapper = new ObjectMapper();
	@Value("c:/upload/image")
	String uploadFolderName;
	@Value("http://localhost:8081/image/")
	String uploadFilePath;
	
	@GetMapping("/write")
	public ModelAndView write() {
		return new ModelAndView("write");
	}
	// 출력형식 : {"uploaded":1, "fileName": 파일명 "url":주소}
	// json형식: {"uploaded":"1" , "fileName": "11111.jpg", "url":"localhost:8081/image/11111.jpg"} 
 	@PostMapping("/ck_upload")
	public ResponseEntity<?> ckUpload(@RequestParam MultipartFile upload){
		Map<String, Object> map = new HashMap<String, Object>();
		// 1.파일을 업로드한 경우
		if(upload!=null && upload.isEmpty()==false) {
			// 2. 사진 파일인지 확인 : image/jpg, image.jpeg, image/png, image/gif
			if(upload.getContentType().toLowerCase().startsWith("image/")) {
				// 3. 사진 파일 이름이 겹치지 않도록 조치 -> 이름을 미리 바꾼 다음 저장(년월일시분초)
				//    윈도우의 경우 aaa.jpg가 있는데 또 넣으면 aaa(1).jpg가 된다	  -> 난이도 높음...
				String imageName = System.currentTimeMillis() + ".jpg"; // nanoTime()
				// File 객체를 만들면 파일이 하드디스크에 생성된다. 파일이 존재할 경우 덮어쓴다
				File file = new File(uploadFolderName, imageName);
				try {
					FileCopyUtils.copy(upload.getBytes(), file);
					map.put("uploaded", 1);
					map.put("fileName", imageName);
					map.put("url", uploadFilePath + imageName);
					String json = mapper.writeValueAsString(map);
					return ResponseEntity.ok(json);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
