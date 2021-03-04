package com.icia.example14.dto;

import java.util.List;

import com.icia.example14.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain=true)
public class Page {
	private Integer pageno;
	private Integer prev;
	private Integer start;
	private Integer end;
	private Integer next;
	private List<Post> list;
	private Integer startRowNum;
	private Integer endRowNum;
}
