<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#btn{
		text-align:center;
	}
	#img_box{
		margin:0 auto;
		height:400px;
		width:400px;
		border-radius: 50%;
		text-align:center;
		background: red;
		overflow: hidden;
	}
	#show_profile{
		width: 100%;
    	height: 100%;
   		object-fit: cover;
	
	}
	
	.success {
		color: green;
		font-size: 0.75em;
	}
	
	.fail {
		color: red;
		font-size: 0.75em;
	}
</style>
<script>
function loadProfile() {
	  var $file = $("#profile")[0].files[0];
	  var reader = new FileReader();
	  
	  reader.onload = function () {
	   	$("#show_profile").attr("src", reader.result);  
	  }
	  
	  reader.readAsDataURL($file);
}
	  
function idCheck(){
	var $username = $("#username").val().toUpperCase();
	$("#username").val($username);
	
	var pattern = /^[A-Z0-9]{8,10}$/;
	if(username==""){
		$("#username_msg").text("아이디는 필수 입력입니다.").attr("class", "fail");
		return false;
	}
	if(pattern.test($username)==false){
		$("#username_msg").text("아이디는 대문자와 숫자 8~10자리입니다").attr("class", "fail");
		retrun false;
	}
	return true;
}	  
	  
	  
$(document).ready(function() {
	$("#profile").on("change", loadProfile);
})
</script>
</head>
<body>
	<div class="container">
		<form action="#">
			<div id="img_box">
				<img id="show_profile">
			</div>
			<div>
				<label for="profile">프로필 사진</label>
				<input id="profile" type="file" name="profile" class="form-control"  accept=".jpg,.jpeg,.png,.gif">
			</div>
			<div>
				<label for="username">아이디</label>
				<span id="username_msg"></span>
				<div class="form-group">
					<input type="text" class="form-control" id="username" name="username">
				</div>
			</div>
			<div>
				<label for="irum">이름</label>
				<span id="irum_msg"></span>
				<div class="form-group">
					<input type="text" class="form-control" id="irum" name="irum">
				</div>
			</div>
			<div>
				<label for="password">비밀번호</label>
				<span id="password_msg"></span>
				<div class="form-group">
					<input id="password" type="password" class="form-control" name="password">
				</div>
			</div>
			<div>
				<label for="password2">비밀번호 확인</label>
				<span id="password2_msg"></span>
				<div class="form-group">
					<input id="password2" type="password" class="form-control">
				</div>	
			</div>
			<div>
				<label for="email">이메일</label>
				<span id="email_msg"></span>
				<div class="form-group">
					<input id="email" type="text" name="email" class="form-control">
				</div>
			</div>
			<div>
				<label for="birthday">생년월일</label>
				<span id="birthday_msg"></span>
				<div class="form-group">
					<input id="birthday" type="date" name="birthday" class="form-control">
				</div>
			</div>
			<div id="btn">
				<button type="button" id="join" class="btn btn-primary">가입</button>
				<button type="button" id="home" class="btn btn-basic">홈으로</button>
			</div>
		</form>
	</div>
</body>
</html>