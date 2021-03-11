<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
/*
 	$.ajax({
				url: 서버주소
				method: get, post
				data:   서버로 넘기는값
				contentType: multipate일 경우 false
			})
 
 */
	$(function(){
		/*
		$("#btn1").on("click", function(){
			$.ajax({
				url: "/example20/users/user/username?username=" + $("#username").val(),
				success: function(result){
					console.log(result);
				}, error: function(msg){
					console.log(msg.responseText);
				}
			})
		});
		*/
		// get방식에서 url의 쿼리스트링으로 데이터를 서버에 전송
		// 파라미터가 하나 + get방식의 경우 -> url에 데이터를 포함해서 넘긴다
		$("#btn1").on("click", function(){
			$.ajax({url: "/example20/users/user/username?username=" + $("#username").val()})
				.done((result)=>{console.log(result);}).fail((result)=>{console.log(result.responseText);});			
		});
		// urlencoded : irum=spring&age=20
		// 자바스크립트 객체를 만들어 서버로 넘길 값을 담으면 $.ajax가 urlencoded 형식으로 변환(processData)
		// 파라미터가 어려개: 자바스크립트 객체를 만들어 data 필들에 지정
		$("#btn2").on("click", function(){
			var params={
					username: $("#username").val()
			};
			$.ajax({
				url:"/example20/users/user/username",
				data: params
			}).done((result)=>{console.log(result);}).fail((result)=>{console.log(result.responseText);});
		});
		//폼 전체를 넘기는 경우
		$("#btn3").on("click", function(){
			$.ajax({
				url:"/example20/users/user/username",
				data: $("#rest_from").serialize()
			}).done((result)=>{console.log(result);}).fail((result)=>{console.log(result.responseText);});	
		})
	})
</script>
</head>
<body>
	<form id="rest_form">
		<input type="text" name="username" id="username"><br>
		<button type="button" id="btn1">보내기1</button>
		<button type="button" id="btn2">보내기2</button>
		<button type="button" id="btn3">보내기3</button>
	</form>
</body>
</html>