package com.icia.test05.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "human123");
		map.put("password", "1234");
		System.out.println("map :" + map);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String result = mapper.writeValueAsString(map);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
