<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//폼에서 넘어온 자료는 항상 String
request.setCharacterEncoding("utf-8");   //한글 처리
String name = request.getParameter("name");
String birth = request.getParameter("birth");
int age = 2014 - Integer.parseInt(birth);
%>
<%=name%>님의 나이는 <%=age%>세입니다.
</body>
</html>









