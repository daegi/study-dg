<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  //scriptlet(스크립틀릿)  
String str = "Hello JSP";
//application.getRealPath("/jsp/ex07.jsp") 명령어로 실제 경로를 알 수 있음.
%>
<!-- h1~h6 Header 제목 표시 태그 -->
<h1><%=str%></h1>
</body>
</html>







