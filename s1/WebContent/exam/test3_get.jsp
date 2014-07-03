<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Cookie[] ck = request.getCookies();
	String s = "";

	if (ck != null) {
		String k, v;
		for (Cookie c : ck) {
			k = c.getName();
			v = c.getValue();

			if (k.equals("lang")) {
				v = URLDecoder.decode(v, "utf-8");
			}

			s += k + ":" + v + "<br/>";

		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	쿠키가저오기
	<br>
	<%=s %> <br>

	<a href="test3.jsp">돌아가기</a>
	<br>

</body>
</html>