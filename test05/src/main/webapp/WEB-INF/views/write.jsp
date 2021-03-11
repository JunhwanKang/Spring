<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/test05/ckeditor/ckeditor.js"></script>
<script>
$(function() {
	// id가 content인 부분을 대체 시킴
	var ck = CKEDITOR.replace("content", {
		// 파일 업로드 주소
		filebrowserUploadUrl:'/test05/ck_upload'
	});
});
</script>
</head>
<body>
	<textarea id="content"></textarea>
</body>
</html>