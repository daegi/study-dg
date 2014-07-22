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
</style>

<script type="text/javascript">
	function check() {
		var f = document.forms[0];

		if (!f.hak.value) {
			alert("학번을 입력 해야 합니다.");
			f.hak.focus();
			return false;
		}

		if (!f.name.value) {
			alert("이름을 입력 해야 합니다.");
			f.name.focus();
			return false;
		}

		if (!/^[12][0-9]{3}-[01][0-9]-[0-3][0-9]/g.test(f.brith.value)) {
			alert("날짜 형식을 정확히 입력하세요(yyyy-mm-dd)....");
			f.birth.focus();
			return false;
		}

		if (!/^[0-9]+$/g.test(f.kor.value)) {
			alert("점수는 숫자만 입력 가능 합니다.");
			f.kor.focus();
			return false;
		}

		if (!/^[0-9]+$/g.test(f.eng.value)) {
			alert("점수는 숫자만 입력 가능 합니다.");
			f.eng.focus();
			return false;
		}

		if (!/^[0-9]+$/g.test(f.mat.value)) {
			alert("점수는 숫자만 입력 가능 합니다.");
			f.mat.focus();
			return false;
		}

		return true;
	}
</script>


</head>
<body>

	<table width="500" style="margin: 0px auto; margin-top: 30px;">
		<tr height="30">
			<td align="center"><span style="font-weight: bold;"></span><b>성적처리</b></td>
		</tr>
	</table>

	<form action="<%=cp%>/score/update.action" method="post"
		onsubmit="return check();">

		<table width="500" style="margin: 0px auto;" cellpadding="0"
			cellspacing="1">
			<tr height="2">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>
			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">학번</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="text" name="hak" readonly="readonly" style="border: none;"
					value="${dto.hak}"></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">이름</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="text" name="name" value="${dto.name}"></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">생년월일</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="text" name="birth" value="${dto.birth}"></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">국어</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="text" name="kor" value="${dto.kor}"></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">영어</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="text" name="eng" value="${dto.eng}"></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">수학</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="text" name="mat" value="${dto.mat}"></td>
			</tr>
			<tr height="2">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="30">
				<td colspan="2" align="center"><input type="hidden"
					name="pageNum" value="${pageNum}"> <input type="submit"
					value="수정완료"> <input type="reset" value="다시입력"> <input
					type="button" value="수정취소"
					onclick="javascript:location.href='<%=cp%>/score/score.action';"></td>
			</tr>
		</table>
	</form>
</body>
</html>