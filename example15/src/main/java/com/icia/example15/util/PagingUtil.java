package com.icia.example15.util;

import java.util.HashMap;
import java.util.Map;

import com.icia.example15.dto.Page;

public class PagingUtil {
	private final static int PAGE_SIZE = 10;
	private final static int BLOCK_SIZE = 5;
	public static Map<String, Object> getPage(int count, int pageno) {
		int countOfPage = count/PAGE_SIZE + 1;
		if(count%PAGE_SIZE==0)
			countOfPage--;
		
		if(pageno<0)
			pageno = -pageno;
		if(pageno==0)
			pageno=1;
		if(pageno>countOfPage)
			pageno=countOfPage;
		
		int startRowNum = (pageno-1)*PAGE_SIZE + 1;
		int endRowNum = startRowNum + PAGE_SIZE - 1;
		if(endRowNum>count)
			endRowNum = count;
		
		
		int blockNo = pageno/BLOCK_SIZE;
		if(pageno%BLOCK_SIZE==0)
			blockNo--;
		
		int start = blockNo*BLOCK_SIZE + 1;
		int end = start + BLOCK_SIZE - 1;
		int prev = start-1;
		int next = end+1;
		
		if(end>=countOfPage) {
			end = countOfPage;
			next = 0;
		}
		Page page = Page.builder().pageno(pageno).prev(prev).start(start).end(end).next(next).build();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRowNum", startRowNum);
		map.put("endRowNum", endRowNum);
		map.put("page", page);
		return map;
	}
}
