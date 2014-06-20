<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	아이디:
	<%=request.getParameter("userid")%><br> 비번 :
	<%=request.getParameter("pwd")%><br>
</body>
</html>