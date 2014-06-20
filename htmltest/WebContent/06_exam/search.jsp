<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../include/jquery-2.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() { //페이지 로딩이 완료되면
		$("#search").keyup(function() { //키이벤트 처리
			var param = "search=" + $("#search").val();
			if (search.length == 0) {
				$("#div1").css("visibility", "visible"); //숨김
			} else {
				$("#div1").css("visibility", "visible"); //표시
				$.ajax({
					type : "post",
					url : "search_result.jsp",
					data : param,
					success : function(msg) {
						//alert(msg);
						$("#div1").html(msg);
					}
				});
			}
		});
	});
</script>
</head>
<body>
	<h2>키워드 검색</h2>
	<input type="text" id="search">
	<!-- 결과를 출력할 영역 -->
	<div id="div1"></div>
</body>
</html>









