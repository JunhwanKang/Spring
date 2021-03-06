package com.icia.example15.dto;

import java.util.List;

import com.icia.example15.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Page {
	private Integer pageno;
	private Integer prev;
	private Integer start;
	private Integer end;
	private Integer next;
	private List<Post> list;
}
