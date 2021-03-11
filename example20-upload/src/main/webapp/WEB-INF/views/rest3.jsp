<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	// 자바스크립트에는 내장 객체 : Date, JSON, FormData...
	$(function(){
		$("#join").on("click", function(){
			var formData = new FormData($("#join_form")[0]);
			// formData에 담긴 값들을 확인하는 ES6스크립트
			// entries는 하나의 이름/ 값 
			for(var pair of formData.entries()){
				console.log(pair[0]+ ":" + pair[1]);
			}
			//console.log(formData);
			$.ajax({
				url: "/example20/users/user",
				method:"post",
				data: formData,
				contentType: false, // $.ajax에서 컨텐트타입을 multipart/form-data로 지정
				processData: false  // 자바스크립트 객체를 urlencoded로 자동 변환
			}).done((dto)=>{console.log(dto);}).fail(()=>{ alert("업로드 오류");})
		})
	})
</script>
</head>
<body>
	<form id="join_form">
		아이디:<input type="text" name="username"><br>
		이메일:<input type="email" name="email"><br>
		<input type="file" name="profile"><br>
		<button type="button" id="join">회원가입</button>
	</form>
</body>
</html>