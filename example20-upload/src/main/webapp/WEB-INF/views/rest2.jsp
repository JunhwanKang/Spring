<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
// 스프링에서 put, patch, delete를 처리하는 방법
// method는 post,넘기는 파라미터에 _method라는 이름으로 put, patch, delete를 넘긴다
// 스프링의 HiddenHttpMethodFileter가 _method에 해당하는 매핑을 실행시킨다
	$(function(){
		$("#send").on("click", function(){
			var params = {
				_method : "patch",
				username: "spring"
			};
			$.ajax({
				url: "/example20/users/user/username",
				data: params,
				method: "post"
			}).done((msg)=>{alert(msg);}).fail(()=>{alert("오류 발생"); })
		})
	})
</script>
</head>
<body>
	<button id="send">patch 요청 보내기</button>
</body>
</html>