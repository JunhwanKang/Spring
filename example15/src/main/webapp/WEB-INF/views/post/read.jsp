<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	$("#delete").on("click", function(){
		var $form = $("<form>").attr("action","/example15/post/delete")
		.attr("method","post").appendTo($("body"));
		$("<input>").attr("type", "hidden").attr("name", "password").val($("#password").val())
		.appendTo($form);
		$("<input>").attr("type", "hidden").attr("name", "pno").val("${post.pno}").val();
	});
	
	$("#update").on("click", function(){
		var $form = $("<form>").attr("action","/example15/post/update")
		.attr("method","post").appendTo($("body"));
		$("<input>").attr("type", "hidden").attr("name", "password").val($("#password").val())
		.appendTo($("body"));
		$("<input>").attr("type", "hidden").attr("name", "pno").val($("${pno}").val())
		.appendTo($("body"));
		$("<input>").attr("type", "hidden").attr("name", "title").val($("#title").val())
		.appendTo($("body"));
		$("<input>").attr("type", "hidden").attr("name", "content").val($("#content").val())
		.appendTo($("body"));
	})
})
</script>
</head>
<body>
	<div class="post">
		<div>
			${post.nickname }&nbsp;&nbsp;&nbsp;${post.writeTimeString }
		</div>
		<div><input type="text" name="title" id="title" value="${post.title }"></div>
		<div><textarea name="content" id="content">${post.content }</textarea></div>
		<div>글 비밀번호:<input type="password" name="password" id="password"></div>
		<button type="button" id="delete">삭제</button>
		<button type="button" id="update">변경</button>
	</div>
</body>
</html>