<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.btn { width: 100px; }
	.error { color: red; font-size: 0.75em; }
</style>
<script>
</script>
</head>
<body>
	<div class="alert alert-danger alert-dismissible" id="msg" style="display:none;">
   		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    	<strong>오류 메시지 </strong><span id="alert"></span>
	</div>
	<form action="/post/write" method="post" id="writeForm">
		<div>
			<div class="form-group">
				<label for="writer">글쓴이:</label><span id="nickname_msg" class="error"></span>
				<input class="form-control" type="text" name="nickname" id="nickname">
			</div>
			<div class="form-group">
				<label for="title">제목:</label><span id="title_msg" class="error"></span>
				<input class="form-control" type="text" name="title" id="title">
			</div>
			<div class="form-group">
				<label for="content">본문:</label>
				<textarea class="form-control" name="content" id="content"></textarea>
			</div>
			<div class="form-group">
				<label for="password">글 비밀번호:</label><span id="password_msg" class="error"></span>
				<input class="form-control" type="password" name="password" id="password">
			</div>
			<button id="write" class="btn btn-info">작성</button>
		</div>
	</form>
</body>
</html>