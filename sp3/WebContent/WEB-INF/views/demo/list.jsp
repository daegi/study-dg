<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
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
	font-family: 돋음;
}
</style>

<script type="text/javascript">
	function check() {
		var f = document.forms[0];

		for (var i = 0; i < f.chk.length; i++) {
			if (f.chkAll.checked)
				f.chk[i].checked = true;
			else
				f.chk[i].checked = false;
		}
	}

	function deleteBoard() {
		var f = document.forms[0];

		var cnt = 0;

		for (var i = 0; i < f.chk.length; i++) {
			if (f.chk[i].checked)
				cnt++;
		}
		
		if (cnt == 0) {
			alert("선택 게시물이 없습니다.");
			return;
		}
		f.action="<%=cp%>/demo/deleteChk.action";
		f.submit();
	}
</script>

</head>
<body>


	<table width="700" style="margin: 0px auto; margin-top: 30;">
		<tr height="30">
			<td><b>게시판</b></td>
		</tr>
	</table>

	<br>

	<table width="700" style="margin: 0px auto;">
		<tr height="30">
			<td width="50%" align="left"><input type="button" value="삭제"
				onclick="deleteBoard()"></td>

			<td width="50%" align="right"><input type="button" value="등록하기">

			</td>
		</tr>
	</table>

	<form action="" method="post">

		<table width="700" style="margin: 0px auto;" cellpadding="0"
			cellspacing="1" bgcolor="#cccccc">
			<tr height="25">
				<td width="50" bgcolor="#ffffff" align="center"><input
					type="checkbox" name="chkAll" onclick="check()"></td>

				<td width="50" bgcolor="#ffffff" align="center">번호</td>

				<td width="400" bgcolor="#ffffff" align="center">제목</td>

				<td width="50" bgcolor="#ffffff" align="center">이름</td>

				<td width="50" bgcolor="#ffffff" align="center">등록일</td>

				<td width="50" bgcolor="#ffffff" align="center">조회수</td>
			</tr>

			<tr height="25" bgcolor="#ffffff">
				<td align="center"><input type="checkbox" name="chk" value="10">
				</td>

				<td align="center">10</td>
				<td align="left" style="padding-left: 5px">방가방가</td>
				<td align="center">호길동</td>
				<td align="center">2000-10-10</td>
				<td align="center">5</td>
			</tr>

			<tr height="25" bgcolor="#ffffff">
				<td align="center"><input type="checkbox" name="chk" value="10">
				</td>

				<td align="center">9</td>
				<td align="left" style="padding-left: 5px">방가방가</td>
				<td align="center">호길동</td>
				<td align="center">2000-10-10</td>
				<td align="center">5</td>
			</tr>

			<tr height="25" bgcolor="#ffffff">
				<td align="center"><input type="checkbox" name="chk" value="10">
				</td>

				<td align="center">8</td>
				<td align="left" style="padding-left: 5px">방가방가</td>
				<td align="center">호길동</td>
				<td align="center">2000-10-10</td>
				<td align="center">5</td>
			</tr>

			<tr height="25" bgcolor="#ffffff">
				<td align="center"><input type="checkbox" name="chk" value="10">
				</td>

				<td align="center">7</td>
				<td align="left" style="padding-left: 5px">방가방가</td>
				<td align="center">호길동</td>
				<td align="center">2000-10-10</td>
				<td align="center">5</td>
			</tr>
		</table>
	</form>
</body>
</html>