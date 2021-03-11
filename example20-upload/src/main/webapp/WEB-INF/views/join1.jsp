<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- enctype : 서버로 전송하는 데이터의 종류 -> mime type -->
	<form action="/join1" method="post" enctype="multipart.form-data">
		아이디:<input type="text" name="username"><br>
		비밀번호:<input type="email" name="email"><br>
		<input type="file" name="profile"><br>
		<button>회원가입</button>
	</form>
</body>
</html>