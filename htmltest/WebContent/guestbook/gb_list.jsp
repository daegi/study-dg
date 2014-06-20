<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>방명록</h2>
	<%
		List<GuestbookDto> list = (List) request.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
			GuestbookDto dto = list.get(i);
			String name = dto.getName();
			Date post_date = dto.getPost_date();
			String email = dto.getEmail();
			String content = dto.getContent();
	%>
	<table border="1" width="500px">
		<tr>
			<td>이름</td>
			<td><%=name%></td>
			<td>날짜</td>
			<td><%=post_date%></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td colspan="3"><%=email%></td>
		</tr>
		<tr>
			<td colspan="4"><%=content%></td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>




