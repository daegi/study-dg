<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%


	String s = "노트북";
	s = URLEncoder.encode(s, "utf-8");
	Cookie c1 = new Cookie("name1", s);
	Cookie c2 = new Cookie("price2", "100");

	
	c1.setMaxAge(-1); 
	c1.setMaxAge(60 * 60);


	c1.setPath("/");

	response.addCookie(c1);
	response.addCookie(c2);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
노트북 100원
	<br>

	<a href="test4.jsp">돌아가기</a>
	<br>

</body>
</html>