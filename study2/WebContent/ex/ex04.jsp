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
		수 : <input type="text" name="num"> <input type="submit"
			value="보내기">


	</form>


	<c:if test="${! empty param.num }">
		<c:if test="${param.num %2 ==0 }">
			<br /> ${param.num }:짝수 <br />
		</c:if>


		<c:if test="${param.num %2 ==1 }">
			<br /> ${param.num }:홀수 <br />
		</c:if>
		<c:choose>
			<c:when test="${param.num %3 ==0 && param.num % 4 ==0}">
				<br>${param.num}: 3과 4의 배수<br>
			</c:when>

			<c:when test="${param.num %3 ==0}">
				<br>${param.num}: 3의 배수<br>
			</c:when>

			<c:when test="${param.num % 4 ==0}">
				<br>${param.num}: 의 배수<br>
			</c:when>

			<c:otherwise>
				<br> ${param.num }: 3또는 4의 배수가 아님<br>
			</c:otherwise>
		</c:choose>
		

		<br>
		<c:forEach var="a" begin="1" end="9" step="1">
		${param.num }*${a}  =${param.num*a }<br>
		</c:forEach>

	</c:if>
</body>
</html>