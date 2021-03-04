package com.icia.example14.service;


import com.icia.example14.dto.Page;

public class PagingUtil {
	private final static int PAGE_SIZE = 10;
	private final static int BLOCK_SIZE = 5;
	
	public Page getPage(int count, int pageno) {
		int countOfPage = count/PAGE_SIZE + 1;
		if(count%PAGE_SIZE==0)
			countOfPage--;

		pageno = Math.abs(pageno); // 음수가 들어오면 절대값 처리
		if(pageno==0)   // 0페이지 일때 1로 변경 아니면 음수가 나옴
			pageno=1;
		if(pageno> countOfPage)   // pageno가 큰 숫자가 들어오면 마지막 페이지를 리턴
			pageno=countOfPage;
		
		int startRowNum = (pageno-1)*PAGE_SIZE+1;
		//(나중에 이것을 고칠 때 변수로 하는게 변경하기 쉽다)
		int endRowNum = startRowNum + PAGE_SIZE-1;
 		if(endRowNum>count)    //endRowNum이 130(121+9)인데 마지막이 123일경우
 			endRowNum = count;

 		int blockNo = pageno/BLOCK_SIZE;
 		if(pageno%BLOCK_SIZE==0)
 			blockNo--;
 		//int start = blockNo * 5 +1;
 		int start = blockNo * BLOCK_SIZE +1;
 		int end = start+BLOCK_SIZE - 1;
		int prev = start-1;
		int next = end+1;  // 마지막 블럭은 성립안함
		
		if(end>=countOfPage) {
			end = countOfPage;
			next = 0;
		}
		
		return Page.builder().pageno(pageno).prev(prev).start(start).
				end(end).next(next).startRowNum(startRowNum).endRowNum(endRowNum).build();
	}
}
