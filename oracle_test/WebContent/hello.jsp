<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
hello jsp
<%  //자바코드영역 ( scriptlet 스크립틀릿 ) 
String name = "kim";
%>  
<br>   <!-- 줄바꿈  BReak line -->
<% for (int i=1; i<=7; i++) { %>
  <font size="<%=i%>">
  	<%=name%>님의 방문을 환영합니다.
  </font><br>
<% } %>
<%
for(int i=1; i<=7; i++){
	out.println("<font size="+i+">"
		+name+"님의 방문을 환영합니다.</font><br>");
}
%>
</body>
</html>







