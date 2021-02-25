<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr><th>번호</th><th>제목</th><th>글쓴이</th><th>조회</th></tr>
		<c:forEach items="${list }" var="post">
			<tr>
				<td>${post.pno }</td>
				<td><a href="/post/read?pno=${post.pno }">${post.title }</a></td>
				<td>${post.nickname }</td>
				<td>${post.readCnt }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>