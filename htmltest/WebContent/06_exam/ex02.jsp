<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../include/jquery-2.1.1.js"></script>
<script type="text/javascript">
	// $.ajax({}) 비동기식 호출 함수
	// Asynchronouse javascript And Xml
	$(document).ready(function() {

		$.ajax({
			type : "post",
			url : " hello.jsp",
			success : function(msg) {
				//hello.jsp의 실행 결과가 msg에 넘어옴
				//div1 태그의 내용이 변경됨
				$("#div1").html(msg);
			}
		});
		alert("test");
	});
</script>
</head>
<body>

	<!-- 	비동기식 호출 : 동시 실행
	Asynchronouse
	동기식 호출: a -> b -> c
	Synchromouse -->

	<div id="div1"></div>

</body>
</html>