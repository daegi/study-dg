<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String cp=request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>study</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css"/>
</head>

<body>
<div class="layoutMain">
	<div class="layoutHeader">
		<jsp:include page="/layout/top.jsp"></jsp:include>
	</div>
	
	<div class="layoutBody">
	   <!-- 몸체영역 -->
	   
	</div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/bottom.jsp"></jsp:include>
	</div>
</div>
</body>
</html>