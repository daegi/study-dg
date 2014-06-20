<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../include/jquery-2.1.1.js"></script>
<script type="text/javascript">

	// 페이지가 로드되면
	$(document).ready(
			function() { //키이벤트
				$("#userid").keyup(function() {
					var param = "userid=" + $("#userid").val();
					$.ajax({
						type : "post",
						data : param,
						url : "idcheck.jsp",
						success : function(msg) {
							$("#div1").html(msg);
						}
					});
				});
				$("#btnIdCheck").click(function() { //아이디 중복 확인
					var param = "userid=" + $("#userid").val();
					$.ajax({
						type : "post",
						data : param,
						url : "idcheck.jsp",
						success : function(msg) {
							$("#div1").html(msg);
						}
					});
				});

				$("#btnLogin").click(
						function() { //로그인 버튼 클릭
							var param = "userid=" + $("#userid").val()
									+ "&pwd=" + $("#pwd").val();
							$.ajax({
								type : "post",
								data : param,
								url : "login_check.jsp",
								success : function(msg) {
									$("#div1").html(msg);
								}
							});
						});

				$("#btnCheck").click(
						function() { //버튼 클릭 이벤트
							// 태그.val()  태그에 입력된 값
							var param = "userid=" + $("#userid").val()
									+ "&pwd=" + $("#pwd").val();
							//비동기식 호출
							$.ajax({
								type : "post",
								data : param,
								url : "login_result.jsp",
								success : function(msg) {
									$("#div1").html(msg);
								}
							});
						});
			});
</script>
</head>
<body>
	<h2>비동기식 로그인</h2>
	아이디 :
	<input type="text" name="userid" id="userid">
	<br> 비번 :
	<input type="password" name="pwd" id="pwd">
	<br>
	<input type="button" id="btnCheck" value="입력값 확인">
	<input type="button" id="btnLogin" value="로그인">
	<input type="button" id="btnIdCheck" value="아이디 중복확인">
	<!-- 결과가 출력되는 영역 -->
	<div id="div1"></div>
</body>
</html>









