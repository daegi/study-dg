<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${u.name } 님 나이는 ${u.age } 입니다.<br>
<%-- ${u.msg } <br> --%>

<a href="<%=cp %>/user/list.action">가기</a>

</body>
</html>