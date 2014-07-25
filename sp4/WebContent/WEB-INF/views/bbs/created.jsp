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
function searchList() {
	var f=document.searchForm;
	
	f.action="<%=cp%>/bbs/list.action";
		f.submit();
	}
</script>

<script type="text/javascript">
	function check() {
		var f = document.forms[0];
		
		if(!f.subject.value){
			alert("제목을 입력하세요");
			f.subject.focus();
			return false;
		}
		
		if(!f.name.value){
			alert("이름을 입력하세요");
			f.subject.focus();
			return false;
		}
		
		if(!f.subject.value){
			alert("내용을 입력하세요");
			f.subject.focus();
			return false;
		}
		
		if(!f.subject.value){
			alert("패스워드를 입력 하세요");
			f.subject.focus();
			return false;
		}
						
    	var mode="${mode}"; 
    	
    	if(mode=="created"){
        	f.action = "<%=cp%>/bbs/created.action";
    	}else if(mode=="update"){
        	f.action = "<%=cp%>/bbs/update.action";
		}
		return true;
	}
</script>
</head>
<body>

	<table width="700" style="margin: 0px auto; margin-top: 20px;">
		<tr height="30">
			<td align="center" colspan="2"
				style="font-size: 20pt; font-family: 돋움; font-weight: bold;">글쓰기</td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>

	<form method="post" onsubmit="return check();">
		<table width="700" style="margin: 0px auto;" cellpadding="0"
			cellspacing="1">
			<tr height="2">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>
			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">제목</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="text" name="subject" size="75" value="${dto.subject}"></td>
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
				<td width="100" align="center" bgcolor="#e4e4e4">내용</td>
				<td width="400" align="left" style="padding-left: 10px;"><textarea
						rows="15" cols="70" name="content">${dto.content}</textarea></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">비밀번호</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="password" name="pwd"></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>
			<tr height="30">
				<td colspan="2" align="center">
				
					<c:if test="${mode == 'update'}">
						<input type="hidden" name="num" value="${dto.num}">
						<input type="hidden" name="pageNum" value="${dto.pageNum}">
						<input type="hidden" name="numPerPage" value="${dto.numPerPage}">
					</c:if> 
					
					<input type="submit" value="${mode=='created' ? '등록하기' : '삭제하기'}">
					<input type="reset" value="다시입력"> 
					<input type="button" value="등록취소" onclick="javascript:location.href='<%=cp%>/bbs/list.action?${params}';"></td>
			</tr>
		</table>
	</form>

</body>
</html>