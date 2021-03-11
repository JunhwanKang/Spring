<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/test05/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<button>보내기</button>
	</form>
</body>
</html>