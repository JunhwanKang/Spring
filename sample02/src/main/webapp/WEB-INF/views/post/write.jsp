<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/post/write" method="post">
		닉네임: <input type="text" name="nickname"><br>
		비밀번호: <input type="password" name="password"><br>
		제목: <input type="text" name="title"><br>
		내용: <br>
		<textarea name="content"></textarea><br>
		<button>글쓰기</button>
	</form>
</body>
</html>