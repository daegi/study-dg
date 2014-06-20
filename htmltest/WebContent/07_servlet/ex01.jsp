<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 숫자입력 => 서블릿에 값을 전달하고 결과 출력 -->

	<form action="<%=request.getContextPath()%>/sum.do" method="post">

		숫자를 입력하세요 <input type="text" name="num"> <input type="submit"
			name="확인">


	</form>

</body>
</html>