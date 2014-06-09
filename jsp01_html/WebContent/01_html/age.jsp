
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<%
//한글 처리
//인코딩 방식 : euc-kr(한국어 전용), utf-8(다국어 인코딩)
request.setCharacterEncoding("utf-8"); //post방식의 인코딩
//폼 입력값 가져오기
String name = request.getParameter("name");
// 폼에서 입력한 데이터는 항상 문자열로 저장되므로 형변환을 해주어야 함
int birth = Integer.parseInt( request.getParameter("birth") );
int age = 2012 - birth;
%>
<%=name%>님의 출생연도는 <%=birth%>년이고 나이는 <%=age%>세입니다.
</body>
</html>









