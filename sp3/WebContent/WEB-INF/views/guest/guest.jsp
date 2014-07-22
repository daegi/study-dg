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

<form action="<%=cp%>/guest/guest.action" method="post">

이름 : <input type="text" name="name">
이메일 : <input type="text" name="emain">
내용 : <input type="text" name="content">

<input type="submit"  value="등록하기">
</form>


</body>
</html>