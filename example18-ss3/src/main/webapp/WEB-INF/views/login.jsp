<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var msg= "${msg}";
		if(msg!="")
			alert(msg);
	})
</script>
</head>
<body>
	<form action="/example18/user/login" method="post">
		아이디:<input type="text" name="username">
		비밀번호:<input type="password" name="password">
		<input type="hidden" name="_csrf" value="${_csrf.token }">
		<button>로그인</button>
	</form>
</body>
</html>