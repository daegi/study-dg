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
				
		f.action="<%=cp%>/bbs/created.action";
		
		<%-- 
			// 자바스크립트에서 EL 표현식사용가능
    	var mode="${mode}"; 
    	
    	if(mode=="created"){
        	f.action = "<%=cp%>/bbs/created.action";
        	f.submit();
    	}else if(mode=="update"){
        	f.action = "<%=cp%>/bbs/update.action";
        	f.submit();
    	}
		// image 버튼, submit은 submit() 메소드 호출하면 두번전송 --%>
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
					type="text" name="subject" size="75"></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">이름</td>
				<td width="400" align="left" style="padding-left: 10px;"><input
					type="text" name="name"></td>
			</tr>
			<tr height="1">
				<td colspan="2" bgcolor="#cccccc"></td>
			</tr>

			<tr height="25">
				<td width="100" align="center" bgcolor="#e4e4e4">내용</td>
				<td width="400" align="left" style="padding-left: 10px;"><textarea
						rows="15" cols="70" name="content"></textarea></td>
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
				<td colspan="2" align="center"><input type="submit"
					value="등록하기"> <input type="reset" value="다시입력"> <input
					type="button" value="등록취소"
					onclick="javascript:location.href='<%=cp%>/bbs/list.action';"></td>
			</tr>
		</table>
	</form>

</body>
</html>