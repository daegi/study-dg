
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 페이지 지시어(directive) -->    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<% // Java code 영역(스크립틀릿)
// request.getParameter(" 폼 태그 name ") ==> 태그에 입력한 값
String userid = request.getParameter("userid");
String passwd = request.getParameter("passwd");
%>
<!--  =변수   ==> 변수의 값을 화면에 출력하라는 의미
out.println(userid); 와 같은 의미
 -->
아이디 : <%=userid%><br>
비번 : <%=passwd%><br>

<a href="ex10_form_login.html">로그인 페이지</a>
</body>
</html>
















