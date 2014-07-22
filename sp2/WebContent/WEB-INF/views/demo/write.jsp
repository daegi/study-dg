<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/sp2/demo/write_ok.action" method="post">
		이름 : <input type="text" name="name"><br> 전화 : <input
			type="text" name="tel"><br> 나이 : <input type="text"
			name="age"><br> <input type="submit" value="보냄">
	</form>

</body>
</html>