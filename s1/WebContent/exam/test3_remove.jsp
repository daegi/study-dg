<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Cookie c1 = new Cookie("name", null);
	Cookie c2 = new Cookie("age", null);
	
	c1.setPath("/");
	c1.setMaxAge(0); //생성과 동시에 제거
	c2.setMaxAge(0);
	
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

	쿠키 제거
	<br>

	<a href="test3.jsp">돌아가기</a>
	<br>

</body>
</html>