<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post">
		수1 : <input type="text" name="num1"><br> 수2 : <input
			type="text" name="num2"><br> <input type="submit"
			value="합" />

	</form>
	${param.num1 }+ ${param.num2 }= ${param.num1+param.num2 }
</body>
</html>