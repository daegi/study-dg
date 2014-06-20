<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	//클라이언트에서 넘어온 charet 설정(하지않으면 한글은 안나와)
	request.setCharacterEncoding("utf-8");

	//클라이언트가 보낸 정보 받기
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));

	String oper = request.getParameter("oper");

	String s = "";
	if (oper.equals("합")) {
		s = String.format("%d+%d=%d", num1, num2, num1 + num2);
	} else if (oper.equals("차")) {
		s = String.format("%d-%d=%d", num1, num2, num1 - num2);
	} else if (oper.equals("곱")) {
		s = String.format("%d*%d=%d", num1, num2, num1 * num2);
	} else if (oper.equals("몫")) {
		s = String.format("%d%%d=%d", num1, num2, num1 % num2);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=s%>

</body>
</html>