
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<h2>회원가입 입력 결과</h2>
<%
request.setCharacterEncoding("utf-8"); //한글 인코딩 설정
String userid = request.getParameter("userid");
String passwd = request.getParameter("passwd");
String jumin = request.getParameter("jumin1")+"-"
	+request.getParameter("jumin2");
String tel = request.getParameter("tel1")+"-"+request.getParameter("tel2")
	+"-"+request.getParameter("tel3");
String gender = request.getParameter("gender");
%>
아이디 : <%=userid %><br>
비번 : <%=passwd %><br>
주민번호 : <%=jumin %><br>
전화 : <%=tel %><br>
성별 : <%=gender %>
</body>
</html>



