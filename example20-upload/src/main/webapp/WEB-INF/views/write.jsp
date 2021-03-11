<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/example20/ckeditor/ckeditor.js"></script>
<script>
	$(function(){
		var ck = CKEDITOR.replace("content",{
			//파일 업로드 주소
			filebrowserUploadUrl : '/example20/ck_upload'
		})
	})
</script>
</head>
<body>
	<textarea id="content"></textarea>
</body>
</html>