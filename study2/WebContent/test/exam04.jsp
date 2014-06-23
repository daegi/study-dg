<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="exam04_ok.jsp" method="post">
		<input type="text" name="num1"> <select name="oper">
			<option value="+">덧셈</option>
			<option value="-">뺄셈</option>
			<option value="*">곱셈</option>
			<option value="/">나눗셈</option>

		</select> <input type="text" name="num2"> <input type="submit"
			value="보내기">
	</form>

</body>
</html>