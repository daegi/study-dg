<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- memo.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../include/jquery-2.1.1.js"></script>
<script type="text/javascript">
	// 페이지가 로딩되면 memo_list()를 자동으로 호출함
	$(document).ready(function() {
		memo_list();
		$("#btnWrite").click(memo_insert);

	});

	function memo_insert() {
		var param = "writer=" + $("#writer").val() + "&memo=" + $("memo").val();
		$.ajax({
			type : "post",
			url : "memo_insert.jsp",
			data : param,
			success : function() {
				memo_list();

				$("#writer").val("");
				$("#memo").val("");
			}
		});

	}

	function memo_list() {
		$.ajax({
			type : "post",
			url : "memo_list.jsp",
			success : function(msg) {
				$("#div1").html(msg);
			}
		});
	}
</script>
</head>
<body>
	<h2>jQuery 한줄메모장</h2>
	<div>
		이름 : <input type="text" name="writer" id="writer"> 메모 : <input
			type="text" name="memo" id="memo" size="40"> <input
			type="button" id="btnWrite" value="확인">
	</div>
	<div id="div1"></div>
</body>
</html>










