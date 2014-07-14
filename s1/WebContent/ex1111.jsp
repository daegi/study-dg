<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	**inline 태그
	<br>
	<span style="width: 200px; display: inline-block; background: #ffff00">자바</span>
	<span style="background: #00ff00">스프링</span>

	<br> **block 태그
	<div style="width: 200px; background: #ffff00">자바</div>
	<div style="background: #00ff00">스프링</div>

	<br>

	<div>
		<div style="width: 424px; position:relative ;top:-50px;">
			<div style="border:2px solid #000000; width: 200px; background: #ff0000; float: left;">a</div>
			<div style="padding:10px; width: 200px; background: #00ff00; float: left;">b</div>
		</div>
		
		<div style="clear: both;">
			<div style="width: 200px; background: #ff0000; float: left;">c</div>
			<div style="width: 200px; background: #00ff00; float: left;">d</div>
		</div>
	</div>








</body>
</html>