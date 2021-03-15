<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<style>
section {
	float: right;
	width: 80%;
	min-height: 600px;
	border: 1px solid black;
	margin-right: 100px;
}
#main{
	overflow: hidden;
}
</style>

<body>
	<div id="page">
		<header>
			<jsp:include page="include/header.jsp"/>
		</header>
		<nav>
			<jsp:include page="include/nav.jsp"/>
		</nav>
		<div id="main">
			<section>
				<jsp:include page="${viewname }"/>
			</section>
			<aside>
				<jsp:include page="include/aside.jsp"/>
			</aside>
		</div>
		<footer>
			<jsp:include page="include/footer.jsp"/>
		</footer>
	</div>
</body>
</html>