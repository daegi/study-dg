<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/WEB-INF/tld/mytag.tld"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<my:sum num="100" />
	<br>
	<my:sum num="1000" />
	<br>

	<my:for end="10" var="v" begin="1">
	${v} 테스트 <br>
	</my:for>
	
	<br>
	<br>
	<br>
	<br>
	


	<my:dan dan="3" />
	<br>


</body>
</html>