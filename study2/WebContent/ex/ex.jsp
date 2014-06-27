<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String s = "";
	try {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		s = Integer.toString(num1+num2);
	} catch (Exception e) {

	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post">
		수1 : <input type="text" name="num1"><br> 수2 : <input
			type="text" name="num2"><br> <input type="submit"
			value="합" />
			
	</form>
			<%=s %>
</body>
</html>