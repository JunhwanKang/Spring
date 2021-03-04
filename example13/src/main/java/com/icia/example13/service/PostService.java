package com.icia.example13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icia.example13.dao.PostDao;
import com.icia.example13.dto.Page;
import com.icia.example13.entity.Post;

@Service
public class PostService {
	@Autowired
	private PostDao dao;
	@Value("10")
	private int PAGE_SIZE; // 한페이지당 글의 개수 게시글이 한페이지에 몇개냐
	@Value("5")
	private int BLOCK_SIZE; // 한블록당 숫자 수 1|2|3|4|5
	
	@Transactional(readOnly = true) //데이터를 변경하거나 추가 삭제 안함
	public Page list(int pageno) {   // 현재 페이지를 받아서 글 리스트를 보여준다.
		// 글의 개수를 가지고 온다 : 123개               120개     count
		// 페이지의 개수를 계산 : 123/10  13개           13x->12  countOfPage
		int count = dao.count();    // 글의 총 개수
		int countOfPage = count/PAGE_SIZE + 1;
		if(count%PAGE_SIZE==0)
			countOfPage--;
// 잘못된 pageno에 대한 처리
		// url에 페이지 no를 검색할 수도 있다(항상 우리가 만든 버튼으로 누르지 않는다)
		pageno = Math.abs(pageno); // 음수가 들어오면 절대값 처리
		if(pageno==0)   // 0페이지 일때 1로 변경 아니면 음수가 나옴
			pageno=1;
		if(pageno> countOfPage)   // pageno가 큰 숫자가 들어오면 마지막 페이지를 리턴
			pageno=countOfPage;
		//문제가 있을 때 찍어보자
//		System.out.println("countOfPage: "+ countOfPage);
//		System.out.println("pageno: " + pageno);
		//					startRowNum     endRowNum
		//pageno    1            1             10
		//          2            11            20
		//          12           111           120
		//          13           121           123
		
		//int startRowNum = (pageno-1)*10+1   10을 PAGE_SIZE로 변경
		int startRowNum = (pageno-1)*PAGE_SIZE+1;
		//int endRowNum = startRowNum + 9   9를 PAGE_SIZE-1로 변경 
		//(나중에 이것을 고칠 때 변수로 하는게 변경하기 쉽다)
		int endRowNum = startRowNum + PAGE_SIZE-1;
 		if(endRowNum>count)    //endRowNum이 130(121+9)인데 마지막이 123일경우
 			endRowNum = count;
		//1|2|3|4|5 블락no1 6|7|8|9|10 블락2
 		// blockNo				prev     start     end     next
 		//    0                  0         1        5        6           
 		//    1                  5         6       10       11
 		//    2                 10        11       13        0
 		// 현재 페이지 번호가 1~10까지는 0번째 블락
 		//             11~20까지는 1번째 블락....
 		
 		// pageno     blockNo
 		// 1~5  		0
 		// 6~10		 	1
 		// 11~15		2
 		//int blockNo = pageno/5; 5를 변수 BLOCK_SIZE로 변경
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
		
		List<Post> list = dao.findAll(startRowNum, endRowNum);
		return Page.builder().pageno(pageno).prev(prev).start(start).
				end(end).next(next).list(list).build();
		
	}
}
