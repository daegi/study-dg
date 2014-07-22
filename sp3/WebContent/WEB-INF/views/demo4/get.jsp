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


	<div style="width: 200px; height: 30px; text-align: center; ${m==0? 'background:green':''}">테스트 0</div>
	<div style="width: 200px; height: 30px; text-align: center; ${m==1? 'background:green':''}">테스트 1</div>


<a href="<%=cp%>/demo4/test.action">돌아가기</a>
</body>
</html>