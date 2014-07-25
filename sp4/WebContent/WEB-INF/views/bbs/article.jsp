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

<script type="text/javascript">
function pwdCheck(mode) {
	var url="<%=cp%>/bbs/pwd.action?mode="+mode;
	url+="&pageNum=${pageNum}";
	url+="&numPerPage=${numPerPage}";
	url+="&num=${dto.num}";
	
	location.href=url;
}
</script>

</head>
<body>
	<table width="700" style="margin: 0px auto; margin-top: 20px;">
		<tr height="30">
			<td align="center" colspan="2"
				style="font-size: 20pt; font-family: 돋움; font-weight: bold;">글보기</td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>

	<form method="post" onsubmit="return check();">
		<table width="700" style="margin: 0px auto;" cellpadding="0"
			cellspacing="1">
			<tr height="1">
				<td colspan="4" bgcolor="#cccccc"></td>
			</tr>
			<tr height="30">
				<td colspan="4" align="center">${dto.subject}</td>
			</tr>

			<tr height="1">
				<td colspan="4" bgcolor="#cccccc"></td>
			</tr>
			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">이름</td>
				<td width="200" align="left" style="padding-left: 10px;">${dto.name}</td>
				<td width="100" align="center" bgcolor="#e4e4e4">줄수</td>
				<td width="200" align="left" style="padding-left: 10px;">${linesu}</td>
			</tr>
			<tr height="1">
				<td colspan="4" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">등록일</td>
				<td width="400" align="left" style="padding-left: 10px;">${dto.created}</td>
				<td width="100" align="center" bgcolor="#e4e4e4">조회수</td>
				<td width="400" align="left" style="padding-left: 10px;">${dto.hitCount}</td>
			</tr>
			<tr height="1">
				<td colspan="4" bgcolor="#cccccc"></td>
			</tr>

			<tr height="150">
				<td width="100" align="center" bgcolor="#e4e4e4">내용</td>
				<td width="200" align="left" style="padding-left: 10px;">${dto.content}</td>
			</tr>
			<tr height="1">
				<td colspan="4" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">이전글</td>
				<td colspan="3" align="left" style="padding-left: 10px;"><c:if
						test="${not empty preDTO}">
						<a href="<%=cp%>/bbs/article.action?${params}&num=${preDTO.num}">${preDTO.subject}</a>
					</c:if></td>
			</tr>

			<tr height="1">
				<td colspan="4" bgcolor="#cccccc"></td>
			</tr>
			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">다음글</td>
				<td colspan="3" align="left" style="padding-left: 10px;"><c:if
						test="${not empty nextDTO}">
						<a href="<%=cp%>/bbs/article.action?${params}&num=${nextDTO.num}">${nextDTO.subject}</a>
					</c:if></td>
			</tr>
			<tr height="1">
				<td colspan="4" bgcolor="#cccccc"></td>
			</tr>

			<tr height="1">
				<td width="100" colspan="4" align="right">${dto.ipAddr}</td>
			</tr>
			<tr height="30">
				<td colspan="4" align="center">
				    <input type="button" value="수정" onclick="pwdCheck('update');">
				    <input type="button" value="삭제" onclick="pwdCheck('delete');">
				    <input type="button" value="목록"
					   onclick="javascript:location.href='<%=cp%>/bbs/list.action?${params}';">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>