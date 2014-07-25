<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	font-size: 9pt;
	font-family: 돋움;
}

a:link {
	color: #007cd0;
	text-decoration: none
}

a:visited {
	color: #007cd0;
	text-decoration: none
}

a:active {
	color: #007cd0;
	text-decoration: none
}

a:hover {
	color: #0099ff;
	text-decoration: none
}
</style>
</head>
<body>


	<table width="300" style="margin: 0px auto; margin-top: 20px;">
		<tr height="50">
			<td align="center" colspan="2"
				style="font-size: 20pt; font-family: 돋움; font-weight: bold;">패스워드 확인</td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>

	<form action="<%=cp%>/bbs/pwd.action" method="post">

		<table width="300" style="margin: 0px auto; margin-top: 20px;"
			bgcolor="#cccccc">
			<tr height="35" bgcolor="#e4e4e4">
				<td align="center"><b>게시물 ${title}</b></td>
			</tr>

			<tr height="35" bgcolor="#ffffff">
				<td align="center">패스워드: <input type="password" name="pwd"
					style="width: 100px;"> <input type="hidden" name="num"
					value="${num}"> <input type="hidden" name="pageNum"
					value="${pageNum}"> <input type="hidden" name="mode"
					value="${pageNum}"> <input type="hidden" name="numPerPage"
					value="${numPerPage}">
				</td>
			</tr>



		</table>


		<table width="300" style="margin: 0px auto; margin-top: 20px;">

			<tr height="35">
				<td align="center"><input type="submit" value="확인"> <input
					type="button" value="취소"
					onclick="javascript:location.href='<%=cp%>/bbs/list.action?pageNum=${pageNum}&numPerPage=${numPerPage}'">
				</td>
			</tr>

			<tr height="35">
				<td align="center"><span style="color: blue">${msg}</span></td>
			</tr>
		</table>
	</form>
</body>
</html>