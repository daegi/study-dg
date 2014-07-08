<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>

	<table>
		<tr>
			<td></td>
		</tr>

		<tr>
			<td><input type="image" src="<%=cp%>/data/images/btn_write.gif"
				onclick="javascript:location.href='<%=cp%>/notice/list.do';" /></td>
		</tr>

	</table>

</body>
</html>

