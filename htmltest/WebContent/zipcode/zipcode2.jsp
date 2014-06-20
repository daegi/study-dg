<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- zipcode.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jquery 명령 작성
input 태그에 keyup 이벤트 등록
호출할 url : zipcode_list2.jsp(우편번호 테이블만 출력)
div에 결과 출력 -->
<script type="text/javascript" src="../include/jquery-2.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#dong").keyup(function() {
			var param = "dong=" + $("#dong").val();
			$.ajax({
				type : "post",
				url : "zipcode2_list.jsp",
				data : param,
				success : function(msg) {
					$("#div1").html(msg);
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>우편번호 찾기</h2>
	동을 입력하세요
	<input type="text" id="dong">
	<!-- 결과 출력 -->
	<div id="div1"></div>
</body>
</html>









