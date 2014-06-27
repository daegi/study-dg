<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	request.setAttribute("test", "테스트입니다.");
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	안녕하세요 저 안보여요

	<jsp:forward page="ex03_ok.jsp" />

</body>
</html>