<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#left { float: left; }
	#right { float: right; color: blue; font-weight: bold;}
	#upper { overflow: hidden; }
	.btn { width: 100px;}
</style>
<script>
$(function() {
	$("#delete").on("click", function() {
		if($("#password").val()=="") {
			$("#alert").text("비밀번호를 입력하세요");
			$("#msg").show();
			return;
		}
		var $form = $("<form>").attr("action","/post/delete").attr("method","post").appendTo($("body"));
		$("<input>").attr("type","hidden").attr("name","pno").val("${post.pno}").appendTo($form);
		$("<input>").attr("type","hidden").attr("name","password").val($("#password").val()).appendTo($form);
		$form.submit();
	});
	$("#update").on("click", function() {
		if($("#password").val()=="") {
			alert("비밀번호를 입력하세요");
			return;
		}
		var $form = $("<form>").attr("action","/post/update").attr("method","post").appendTo($("body"));
		$("<input>").attr("type","hidden").attr("name","pno").val("${post.pno}").appendTo($form);
		$("<input>").attr("type","hidden").attr("name","title").val($("#title").val()).appendTo($form);
		$("<input>").attr("type","hidden").attr("name","content").val($("#content").val()).appendTo($form);
		$("<input>").attr("type","hidden").attr("name","password").val($("#password").val()).appendTo($form);
		$form.submit();
	});
})
</script>
</head>
<body>
	<div class="alert alert-danger alert-dismissible" id="msg" style="display:none;">
   		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    	<strong>오류 메시지 </strong><span id="alert"></span>
	</div>
	<div>
		<div class="form-group" id="upper">
			<div id="left">
				글번호 ${post.pno } | ${post.writeTimeString } | 조회 ${post.readCnt } 
			</div>
			<div id="right">${post.nickname }</div>
		</div>
		<div class="form-group">
			<label for="title">제목:</label>
			<input class="form-control" type="text" name="title" id="title" value="${post.title }">
		</div>
		<div class="form-group">
			<label for="content">본문:</label>
			<textarea class="form-control" name="content" id="content">${post.content }</textarea>
		</div>
		<div class="form-group">
			<label for="password">글 비밀번호:</label>
			<input class="form-control" type="password" name="password" id="password">
		</div>
		<button id="delete" class="btn btn-dnager">삭제</button>
		<button id="update" class="btn btn-primary">변경</button>
	</div>
</body>
</html>