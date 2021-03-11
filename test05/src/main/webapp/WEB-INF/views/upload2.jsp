<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#add").on("click", function(){
			var $div = $("<div>").appendTo($("#file_div"))
			$("<input>").attr("type", "file").attr("name", "file").appendTo($div);
			$("<button>").attr("type", "button").attr("class", "remove").text("제거").appendTo($div);
		})
		$("#file_div").on("click", ".remove", function(){
			$(this).parent().remove();
		})
	})
</script>
</head>
<body>
	<form action="/test05/upload2" method="post" enctype="multipart/form-data">
			<button type="button" id="add">파일추가</button>
			<div id="file_div">
			
			</div>
			<button>보내기</button>
	</form>
</body>
</html>