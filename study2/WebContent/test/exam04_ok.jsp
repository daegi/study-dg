<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="calc" class="com.calc.CalcVO" />
<jsp:setProperty property="*" name="calc" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<%=calc.getNum1()%>
	<%=calc.getOper()%>
	<%=calc.getNum2()%>
	
	<br>
	<%=calc.result() %>
</body>
</html>