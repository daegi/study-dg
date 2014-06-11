<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 페이지 지시어(directive) -->    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  // jsp scriptlet(jsp 코드조각) %>
<%
// request.getParamter("태그의 name")
// post 방식의 한글 처리
request.setCharacterEncoding("utf-8"); 
String userid = request.getParameter("userid");
//스트링.getBytes("캐릭터셋")
//userid = new String(userid.getBytes("iso8859-1"), "utf-8" );
String passwd = request.getParameter("passwd");
%>
<%-- <%=값 %> => 화면에 출력(표현식, expression) --%>
아이디 : <%=userid%><br>
비밀번호 : <%=passwd%>
</body>
</html>









