<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	${list } 포워딩한 페이지의 request.setAttribute("키",값); 내용을 전달받는다. <br>
	vo.getNume()식 으로 표현하지만 EL은 vo.num 식으로 표현한다.<br>
	<c:forEach var="vo" items="${list }">
		${vo.num } | ${vo.name } | ${vo.subject }  <br>
	</c:forEach>

</body>
</html>