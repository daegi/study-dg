<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	직업 :
	<%
	request.setCharacterEncoding("utf-8");
	String[] hobby = request.getParameterValues("hobby");
	String memo = request.getParameter("memo");
	memo = memo.replace("\n", "<br>");
%>

	<%=request.getParameter("job")%><br> 취미:
	<%
		if (hobby != null) {
			for (int i = 0; i < hobby.length; i++) {
				out.println(hobby[i] + "");
			}
		}
	%>
	<br> 메모 :
	<%=memo%>

</body>
</html>