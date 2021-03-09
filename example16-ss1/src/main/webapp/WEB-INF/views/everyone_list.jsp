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
	<!-- 로그인 했으면 ~~님 환영합니다 + 로그아웃 -->
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username" var="username"/>
		${username }님 환영합니다
		<form action="/example16/system/logout" method="post">
			<input type="hidden" name="_csrf" value="${_csrf.token }">
			<button id="logout">로그아웃</button>
		</form>
	</sec:authorize>
	<!-- 비로그인이면 로그인으로 이동하는 링크 -->
	<sec:authorize access="isAnonymous()">
		<a href="/example16/login">로그인</a>
	</sec:authorize>
</body>
</html>