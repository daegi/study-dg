<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	border: 1px solid black;
	height: 20px;
	width: 200px;
}
</style>
</head>
<body>
	<h2>iframe을 이용한 화면 변경</h2>
	<div id="item1" style="background: red;"></div>
	<div id="item2" style="background: green;"></div>
	<div id="item3" style="background: blue;"></div>
	<!-- inner frame - 내부 프레임 -->
	<iframe src="ex01_background.jsp" 
	width="0px" height="0px"></iframe>
</body>
</html>









