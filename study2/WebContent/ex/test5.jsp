<%@page import="com.svt.TestVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	ArrayList<TestVO> list = new ArrayList<TestVO>();
	list.add(new TestVO(1, "자바", "처음이야"));
	list.add(new TestVO(2, "jsp", "웹프로그램이군"));
	list.add(new TestVO(3, "스프링", "매우매우 중요"));
	list.add(new TestVO(4, "마이바티스", "모르면 손이 고생"));
	list.add(new TestVO(5, "ajax", "비동기통신"));

	request.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 출력 안됨......

<jsp:forward page="test5_ok.jsp"/>

</body>
</html>