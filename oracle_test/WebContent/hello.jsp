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
<%  //�ڹ��ڵ念�� ( scriptlet ��ũ��Ʋ�� ) 
String name = "kim";
%>  
<br>   <!-- �ٹٲ�  BReak line -->
<% for (int i=1; i<=7; i++) { %>
  <font size="<%=i%>">
  	<%=name%>���� �湮�� ȯ���մϴ�.
  </font><br>
<% } %>
<%
for(int i=1; i<=7; i++){
	out.println("<font size="+i+">"
		+name+"���� �湮�� ȯ���մϴ�.</font><br>");
}
%>
</body>
</html>







