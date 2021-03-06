<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var msg = "${msg}";
	if(msg!="")
		alert(msg);
</script>
</head>
<body>
	<table class="table table-hover">
		<tr><th>글번호</th><th>제목</th><th>글쓴이</th><th>날짜</th><th>조회</th></tr>
		<c:forEach items="${page.list }" var="post">
			<tr>
				<td>${post.pno }</td>
				<td><a href="/example15/post/read?pno=${post.pno }">${post.title }</a></td>
				<td>${post.nickname }</td>
				<td>${post.writeTime }</td>
				<td>${post.readCnt }</td>
			</tr>
		</c:forEach>
	</table>
	<div style="text=align:center;">
		<ul class="pagination">
			<c:if test="${page.prev>0 }">
				<li><a href="/example15/post/list?pageno=${page.prev }">이전</a>
			</c:if>
			<c:forEach begin="${page.start }" end="${page.end }" var="i">
				<c:if test="${i eq page.pageno }">
					<li class="active"><a href="/example15/post/list?pageno=${i}">${i}</a></li>
				</c:if>
				<c:if test="${i ne page.pageno }">
					<li><a href="/example15/post/list?pageno=${i}">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${page.next>0 }">
				<li><a href="/example15/post/list?pageno=${page.next }">다음</a>
			</c:if>
		</ul>
	</div>
</body>
</html>