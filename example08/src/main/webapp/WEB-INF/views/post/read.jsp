<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(document).ready(function() {
	$("#delete").on("click", function() {
		var $form = $("<form>").attr("action","/post/delete").attr("method","post").appendTo($("body"));
		$("<input>").attr("type","hidden").attr("name","pno").val("${post.pno}").appendTo($form);
		$("<input>").attr("type","hidden").attr("name","password").val($("#password").val()).appendTo($form);
		$form.submit();
	});
});
</script>
</head>
<body>
	<form action="/post/update" method="post">
		<input type="hidden" name="pno" value="${post.pno }">
		닉네임: <input type="text" name="nickname" value="${post.nickname}" readonly="readonly"><br>
		비밀번호: <input type="password" name="password" id="password"><br>
		제목: <input type="text" name="title" value="${post.title }"><br>
		내용: <br>
		<textarea name="content">${post.content }</textarea><br>
		<button>변경하기</button>
		<button type="button" id="delete">삭제하기</button>
	</form>
</body>
</html>