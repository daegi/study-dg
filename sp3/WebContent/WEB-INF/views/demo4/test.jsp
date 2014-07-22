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


<a href="<%=cp%>/demo4/set.action">쿠키설정</a>
<a href="<%=cp%>/demo4/get.action">쿠키가저오기</a>

</body>
</html>