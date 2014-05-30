<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	var form1 = document.getElementById("form1");
	var name = document.getElementById("name");
	var subject = document.getElementById("subject");
	var content = document.getElementById("content");
	if( name.value == "" ) {
		alert("이름을 입력하세요");
		name.focus();
		return;
	}
	if( subject.value == "" ) {
		alert("제목을 입력하세요");
		subject.focus();
		return;
	}
	if( content.value == "" ) {
		alert("본문을 입력하세요");
		content.focus();
		return;
	}
	form1.submit();
}
</script>
</head>
<body>
<h2>게시판 글쓰기</h2>
<form name="form1" id="form1" action="board_insert.jsp" method="post">
<table border="1" style="width:600px">
	<tr>
		<td style="text-align:center;">이름</td>
		<td><input type="text" name="name" id="name" /></td>
	</tr>
	<tr>
		<td style="text-align:center;">제목</td>
		<td><input type="text" name="subject" id="subject"  size="60" /></td>
	</tr>
	<tr>
		<td style="text-align:center;">본문</td>
		<td>
			<textarea name="content" id="content" 
				rows="5" cols="60" ></textarea></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="button" value="확인" onclick="javascript:check();" />
			<input type="reset" value="취소" />
		</td>
	</tr>
</table>
</form>
</body>
</html>