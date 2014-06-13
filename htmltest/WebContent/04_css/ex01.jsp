<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>스타일 시트</h2>

	<%
		for (int i = 1; i <= 50; i++) {
	%>
	<font style="font-size:<%=i%>px">hello</font>
	
	<br>


	<%
		}
	%>


</body>
</html>