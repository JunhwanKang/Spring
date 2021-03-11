<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		var $fileArea = $("#file_area");
		$("#add").on("click", function(){
			var $div = $("<div>").appendTo($fileArea);
			$("<input>").attr("type", "file").attr("name", "profile").appendTo($div);
			$("<button>").attr("type", "button").attr("class", "remove").text("제거").appendTo($div);
		});
		$("#file_area").on("click", ".remove", function(){
			// parent : 부모 요소를 선택하는 jQuery 선택자 함수
			// parent.empty() : parent는 남고 자식을 삭제
			// parent.remove() : parent 자신을 삭제
			$(this).parent().remove();
		})
	});
</script>
</head>
<body>
	<!-- enctype : 서버로 전송하는 데이터의 종류 -> mime type -->
	<form action="/join1" method="post" enctype="multipart.form-data">
		아이디:<input type="text" name="username"><br>
		비밀번호:<input type="email" name="email"><br>
		<hr>
		<button type="button" id=add">파일 추가</button>
		<div id="file_area">
					
		</div>
		<button>가입</button>
	</form>
</body>
</html>