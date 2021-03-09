<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인하면 ~~님 환영합니다 -->
	<sec:authentication property="principal.username" var="username"/>
	${username }님 환영합니다.
	
	<!-- 로그아웃 버튼 -->
	<!-- 모든 post 요청은 csrf 토큰을 포함해야 한다 -->
	<form action="/example16/system/logout" method="post">
		<input type="hidden" name="_csrf" value="${_csrf.token }">
		<button id="logout">로그아웃</button>
	</form>
</body>
</html>