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

/* function deleteEvent() {
	if(confim("정말 삭제 하시겠습니까?") == true){
		document.forms[0].submit();
	}else{
		return;
	}
} */


	function check() {
		var f = document.forms[0];

		for (var i = 0; i < f.chk.length; i++) {
			if (f.chkAll.checked)
				f.chk[i].checked = true;
			else
				f.chk[i].checked = false;
		}
	}

	function deleteScore() {
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
		f.action="<%=cp%>/score/delete.action";
		f.submit();
	}
</script>

</head>
<body>

	<table width="730" style="margin: 0px auto; margin-top: 30px;">
		<tr height="30">
			<td align="center"><span
				style="font-size: 13pt; font-family: 돋움; font-weight: bold;"></span><b>성적처리</b></td>
		</tr>

		<tr height="30">
			<td width="50%" align="left"><input type="button" value="삭제"
				onclick="deleteScore()"></td>
			<td width="50%" align="right"><input type="button" value="등록하기"
				onclick="javascript:location.href='<%=cp%>/score/write.action';"></td>
		</tr>
	</table>

	<form action="" method="post">

		<table width="730" style="margin: 0px auto;" cellpadding="0"
			cellspacing="1" bgcolor="#cccccc">
			<tr height="25" bgcolor="#e4e4e4">
				<td width="30" align="center"><input type="checkbox"
					name="chkAll" onclick="check()"></td>
				<td width="70" align="center">학번</td>
				<td width="90" align="center">이름</td>
				<td width="80" align="center">생년월일</td>
				<td width="60" align="center">국어</td>
				<td width="60" align="center">영어</td>
				<td width="60" align="center">수학</td>
				<td width="60" align="center">총점</td>
				<td width="60" align="center">평균</td>
				<td width="60" align="center">석차</td>
				<td width="100" align="center">&nbsp;</td>
			</tr>
			<c:forEach var="dto" items="${list}">
				<tr height="25" bgcolor="#ffffff">
					<td width="30" align="center"><input type="checkbox"
						name="chk" value="10"></td>
					<td align="center">${dto.hak}</td>
					<td align="center">${dto.name}</td>
					<td align="center">${dto.birth}</td>
					<td align="center">${dto.kor}</td>
					<td align="center">${dto.eng}</td>
					<td align="center">${dto.mat}</td>
					<td align="center">${dto.tot}</td>
					<td align="center">${dto.ave}</td>
					<td align="center">${dto.rank}</td>
					<td align="center"><input type="button" value="수정"
						onclick="javascript:location.href='<%=cp%>/score/update.action?hak=${dto.hak}&pageNum=${pageNum}'">
						<input type="button" value="삭제"
						onclick="javascript:location.href='<%=cp%>/score/delete.action?hak=${dto.hak}'"></td>
					
				</tr>
			</c:forEach>
		</table>
	</form>

	<table width="700" style="margin: 0px auto;">
		<tr height="30">
			<td align="center"><c:if test="${dataCount ==0}">
			등록된 자료가 없습니다.
			</c:if> <c:if test="${dataCount !=0}">
			${pageIndexList}
			</c:if></td>
		</tr>
	</table>
</body>
</html>