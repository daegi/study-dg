<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- board.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--
 jquery로 board_list.jsp를 비동기식 호출하여 div태그에 목록 출력 -->
<%
//현재 페이지 번호
String cur_page = "1";
if( request.getParameter("cur_page") != null ){
	cur_page = request.getParameter("cur_page");
}
%>
<script type="text/javascript" src="../include/jquery-2.1.1.js"></script>
<script type="text/javascript">
//문서가 로딩되면 board_list() 실행
$(document).ready(board_list);  
function board_list(){	
	var param = "cur_page=<%=cur_page%>";
	$.ajax({
		type: "post",
		url: "board_list.jsp",
		data: param,
		success: function(msg){
			$("#div1").html(msg);
		}
	});
}
</script> 
</head>
<body>
<h2>게시판</h2>
<div id="div1"></div>
</body>
</html>









