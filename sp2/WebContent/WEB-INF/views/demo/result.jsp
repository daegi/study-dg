<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="/sp2/demo/list.action">리스트</a>
	<br>
	<br> ${msg}
	<br> 전화 : ${dto.tel}
	<br> 나이 : ${dto.age}
	<br>

</body>
</html>