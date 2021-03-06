package com.cdj.test04.dto;

import java.util.List;

import com.cdj.test04.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Page {
	private Integer pageno;
	private Integer start;
	private Integer end;
	private Integer prev;
	private Integer next;
	private List<Post> list;
}
