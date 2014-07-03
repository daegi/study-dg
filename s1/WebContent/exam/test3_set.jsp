<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Cookie c1 = new Cookie("name", "kim");
	Cookie c2 = new Cookie("age", "10");
	Cookie c3 = new Cookie("city", "seoul");

	//쿠키로 한글저장방법(먼저 인코딩)
	String s = "자바";
	s = URLEncoder.encode(s, "utf-8");
	Cookie c4 = new Cookie("lang", s);
	
	//기본적으로 쿠키 유효시간은 브라우저가 종료되면 제거
	c1.setMaxAge(-1); //브라우저 종료시 제거 0은 바로제거
	c1.setMaxAge(60*60); //1시간후 제거
	
	//쿠키는 기본적으로 자신의 결로에서만 접근 가능
	// 다른 경로 에서도 접근가능하도록 하기 위해
	c1.setPath("/");
	
	//쿠키를 클라이언트 컴에 저장
	response.addCookie(c1);
	response.addCookie(c2);
	response.addCookie(c3);
	response.addCookie(c4);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	쿠키설정
	<br>

	<a href="test3.jsp">돌아가기</a>
	<br>

</body>
</html>