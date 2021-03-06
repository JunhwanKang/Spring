<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/example15/post/write" method="post">
		<table class="table">
			<tr><td>nickname</td><td><input type="text" name="nickname"></td></tr>
			<tr><td>비밀번호</td><td><input type="password" name="password"></td></tr>
			<tr><td>제목</td><td><input type="text" name="title"></td></tr>
			<tr><td colspan="2"><textarea id="textarea" name="content"></textarea></td></tr>
			<tr><td colspan="2"><button>작성</button></td></tr>
		</table>
	</form>
</body>
</html>