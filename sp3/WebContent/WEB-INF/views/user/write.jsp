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
	<form action="<%=cp%>/user/write.action" method="post">
		이름 :<input type="text" name="name"><br>
		생년월일 :<input type="text" name="birth"><br>
		나이 :<input type="text" name="age"><br>
		전화번호 :<input type="text" name="tel"><br>
		
		<input type="submit" value="보내기">

	</form>

</body>
</html>