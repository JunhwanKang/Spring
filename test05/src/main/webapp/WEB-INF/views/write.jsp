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
	// id�� content�� �κ��� ��ü ��Ŵ
	var ck = CKEDITOR.replace("content", {
		// ���� ���ε� �ּ�
		filebrowserUploadUrl:'/test05/ck_upload'
	});
});
</script>
</head>
<body>
	<textarea id="content"></textarea>
</body>
</html>