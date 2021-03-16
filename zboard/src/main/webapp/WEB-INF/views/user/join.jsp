<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
// 나눠서 한다 코드 재사용을 위해서;;
// usernameCheck 
	// 아이디 입력안함 => 필수 입력입니다.
	// 아이디 입력함 => 영숫자 8~10
// ajax처리 => 아이디 사용가능 여부
function usernameCheck(){
	// 아이디는 대문자로 변환해서 저장
	var $username = $("#username").val().toUpperCase();
	$("#username").val($username);
	
	var pattern = /^[A-Z0-9]{8,10}$/;
	if($username==""){
		$("#username_msg").text("필수입력입니다").attr("class", "fail");
		return false;		
	}
	if(pattern.test($username)==false){
		$("#username_msg").text("아이디는 대문자와 숫자 8~10자입니다").attr("class", "fail");
		return false;
	}
	return true;
}

function emailCheck(){
	var $email = $("#email").val();
	var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if($email == ""){
		$("#email_msg").text("필수입력입니다").attr("class", "fail");
		return false;
	}
	if(pattern.test($email)==false){
		$("#email_msg").text("잘못된 이메일 형식입니다.").attr("class", "fail");
		return false;
	}
	return true;
}

function loadProfile(){
	var $file = $("#profile")[0].files[0];
	var maxSize = 1024 * 1024   // 업로드할 프로필 최대 크기 : 1MB
	if($file.size>maxSize){
		Swal.fire({
			icon: 'error',
			title: '파일 크기 오류',
			text: '프로필 사진은 1MB를 넘을 수 없습니다'
		});
		// 파일 크기 오류  발생 했기 때문에 => 파일 정보를 초기화, 프로필 미리보기도 삭제
		$("#profile").val("");
		$("#show_profile").removeAttr("src");
		return false;
	}
	// <img id="show_profile">에 선택한 프사를 src로 지정 => 하드디스크의 이미지를 직접 읽어오게 하자
	var reader = new FileReader();
	reader.onload = function(){
		console.log(this.result);
		$("#show_profile").attr("src", this.result);
	}
	// 컨텐츠를 파일에서 읽어오는 메소드
	reader.readAsDataURL($file);
	return true;
}

$(document).ready(function() {
	// multipart/form-data를 처리하는 자바스크립트 내장 객체 FormData 생성
	$("#join").on("click", function(){
	var formData = new FormData($("#join_form")[0]);
		$.ajax({
			url: "/zboard/users",
			method: "post",
			data : formData,
			contentType: false, // multipart/form-data 
			processData: false  // 자바스크립트 객체를 자동으로 urlencoded로 변환 => 꺼라
		}).done(()=>{alert("가입 확인 메일을 보냈습니다. 메일을 확인하세요")}).fail(()=>{alert("가입에 실패했습니다")});
	})
	
	$("#profile").on("change", loadProfile);
	$("#email").on("blur", function(){
		if(emailCheck()==false)
			return false;
		$.ajax({
			url: "/zboard/users/user/email?email=" + $("#email").val()})
			.done(()=>{$("#email_msg").text("사용가능한 이메일입니다.").attr("class", "success")})
			.fail(()=>{$("#email_msg").text("사용중인 이메일입니다.").attr("class", "fail")})
	})
	$("#username").on("blur", function(){
		if(usernameCheck()==false)
			return false;
		$.ajax({
			url: "/zboard/users/user/username?username=" + $("#username").val()
		}).done(()=>{$("#username_msg").text("좋은 아이디네요.").attr("class", "success")})
		.fail(()=>{$("#username_msg").text("사용중인 아이디입니다.").attr("class", "fail")});
	});
	
})


</script>
</head>
<body>
	<form id="join_form">
		<div id="wrap">
			<img id="show_profile" height="240px">
			<input type="hidden" name="_csrf" value="${_csrf.token }">
			<div class="form-group">
				<label for="profile">프로필 사진</label>
				<!-- accept : 확장자 지정 -->
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
			<div class="form-group" style="text-align: center;">
				<button type="button" id="join" class="btn btn-info">가입</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" id="home" class="btn btn-primary">HOME</button>
			</div>
		</div>
	</form>
</body>
</html>