<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="test1_ok.jsp" method="post" enctype="multipart/form-data">
	
	제목 <input type="text" name="subject"><br>
	파일 <input type="file" name="upload"><br>
	<input type="submit" value="보내기">
	
</form>
</body>
</html>