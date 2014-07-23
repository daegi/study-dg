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
<script type="text/javascript">
function searchList() {
	var f=document.searchForm;
	
	f.action="<%=cp%>/bbs/list.action";
		f.submit();
	}
</script>


</head>
<body>
	<table width="700" style="margin: 0px auto; margin-top: 30px;">
		<tr height="30">
			<td align="center" colspan="2"><span
				style="font-size: 15pt; font-weight: bold;">게시판</span></td>
		</tr>

		<tr height="30">
			<td width="50%" align="left">
				<form name="searchForm" method="post">
					<select name="searchKey" class="selectField">
						<option value="subject">제목</option>
						<option value="content">내용</option>
						<option value="userName">작성자</option>
						<option value="created">등록일</option>
					</select> <input type="text" name="searchValue" class="boxTF" /> <input
						type="button" value=" 검 색 " class="btn" onclick="searchList();" />
				</form>
			</td>
			<td align="right" width="50%"><input type="button" value="등록하기"
				onclick="javascript:location.href='<%=cp%>/bbs/created.action';"></td>
		</tr>
	</table>

	<table width="700" style="margin: 0px auto;" cellpadding="0"
		cellspacing="1" bgcolor="#cccccc">
		<tr height="25" bgcolor="#e4e4e4">
			<td width="60" align="center">번호</td>
			<td width="400" align="center">제목</td>
			<td width="100" align="center">작성자</td>
			<td width="80" align="center">등록일</td>
			<td width="60" align="center">조회수</td>
		</tr>
		<tr height="25" bgcolor="#ffffff">
			<td align="center">1</td>
			<td align="center"><a href="${articleUrl}&num=${dto.num}">아몰라</a></td>
			<td align="center">누구?</td>
			<td align="center">2013-01-01</td>
			<td align="center">1</td>
		</tr>
	</table>

</body>
</html>