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

<form action="<%=cp%>/demo2/write.action" method="post">
이름 : <input type="text" name="name">
나이 : <input type="text" name="age">
<input type="hidden" name="mode" value="save">
<input type="submit" value="보내기">



</form>

</body>
</html>