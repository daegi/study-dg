<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send(){
	var message = document.getElementById("message");
// opener : 팝업창을 오픈한 메인윈도우	
	opener.document.getElementById("msg").value 
		= message.value;
}
</script>
</head>
<body>
<%
// tree.jsp?msg=hello
// request.getParameter("변수명")
String msg = request.getParameter("msg");
%>
	팝업창에서 보낸 메시지 : <%=msg%><br>
	<input type="button" value="닫기" onclick="window.close()">
	<input type="text" id="message">
	<input type="button" value="부모창에 전송"
		onclick="send()">
	<img src="../images/tree2.jpg"><br>
	<img src="../images/rose.gif">	
</body>
</html>









