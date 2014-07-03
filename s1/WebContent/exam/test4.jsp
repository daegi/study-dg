<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<a href="test4_1.jsp">노트북</a> | 100
	<br>
	<a href="test4_2.jsp">태블릿</a> | 50
	<br>
	<a href="test4_3.jsp">스마트폰</a> | 80
	<br> 오늘본 상품 목록
	<%
		String s = "";
		Cookie[] ck = request.getCookies();
		
		
		String v;
		for (Cookie c : ck) {
			if (c.getName().startsWith("name")) {
				v = URLDecoder.decode(c.getValue(), "utf-8");
				s += v + "<br>";
			}
		}
	%>
	
	
	<br>
	<br>
	<br>
	<br>
	
	<%=s%>




</body>
</html>