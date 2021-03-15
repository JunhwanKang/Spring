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
		var maxSize = 1024*1024;			// 업로드할 프로필 최대 크기 : 1MB
		if($file.size>maxSize) {
			Swal.fire({
				icon: 'error',
				title : '프로필 크기 오류',
				text : '프로필 사진은 1MB를 넘을 수 없습니다'
			});
			$("#profile").val("");
			$("#show_profile").removeAttr("src");
			return false;
		}
	
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
	if($username==""){
		$("#username_msg").text("아이디는 필수 입력입니다.").attr("class", "fail");
		return false;
	}
	if(pattern.test($username)==false){
		$("#username_msg").text("아이디는 대문자와 숫자 8~10자리입니다").attr("class", "fail");
		return false;
	}
	return true;
}	  

function emailCheck(){
	var $email = $("#email").val();
	var pattern =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if($email==""){
		$("#email_msg").text("필수 입력입니다.").attr("class", "fail");
		return false;		
	}
	
	if(pattern.test($email)==false){
		$("#email_msg").text("올바르지 않은 이메일 형식입니다.").attr("class", "fail");
		return false;		
	}
}
	  
$(document).ready(function() {
	$("#profile").on("change", loadProfile);
	$("#username").on("blur", function(){
		if(idCheck()==false)
			return false;
		$.ajax({
			url: "/mboard/users/user/username?username=" + $("#username").val()
		}).done(()=>{$("#username_msg").text("사용 가능한 아이디입니다").attr("class", "success")})
		.fail(()=>{$("#username_msg").text("이미 사용중인 아이디입니다").attr("class", "fail")})
	});
	
	$("#email").on("blur", function(){
		if(emailCheck()==false)
			return false;
		$.ajax({
			url:"/mboard/users/user/email?email=" + $("#email").val()
		}).done(()=>{$("#email_msg").text("사용 가능한 이메일입니다").attr("class", "success")})
		.fail(()=>{$("#email_msg").text("이미 사용중인 이메일입니다").attr("class", "fail")})
	})
	
	$("#join").on("click", function(){
		if(idCheck()==false)
			if(emailCheck()==false)
				return false;
		var formData = new FormData($("#join_form")[0]);
		
		$.ajax({
			url: "/mboard/users",
			method:"post",
			data: formData,
			contentType: false,
			processData: false
		}).done(()=>{alert("가입 확인 메일을 확인해주세요")})
		.fail(()=>{alert("가입에 실패했습니다")});
	})
})
</script>
</head>
<body>
	<div class="container">
		<form id="join_form">
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