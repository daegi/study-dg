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
function sendBoard() {
    var f = document.boardForm;

	var str = f.subject.value;
    if(!str) {
        alert("\n제목을 입력하세요. ");
        f.subject.focus();
        return false;
    }
	f.subject.value = str;

	str = f.content.value;
    if(!str) {
        alert("내용을 입력하세요. ");
        f.content.focus();
        return false;
    }
	f.content.value = str;
	
	var mode="${mode}";
	
	if(mode=="created") {
    	f.action = "<%=cp%>/notice/created_ok.do";
	<%-- }else if(mode=="reply") {
       	f.action = "<%=cp%>/notice/reply_ok.do"; --%>
	}if(mode=="update") {
    	f.action = "<%=cp%>/board/update_ok.do";	
	}
		return true;
	}
</script>


</head>
<body>


	<form name="noticForm" method="post" onsubmit="return sendBoard()">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value=""></td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
			</tr>

			<tr>
				<td>내용</td>
				<td width="480"><textarea name="content" rows="20" cols="50"></textarea></td>
			</tr>

			<tr>
				<td>파일</td>
				<td><input type="file" name="files" value=""></td>
			</tr>

			<tr id="noticeCreated_footer" align="center">
				<td>
				<input type="image"	src="<%=cp%>/data/images/btn_submit.gif" /> 
					<a href="javascript:location.href='<%=cp%>/notic/list.do':"> 
					<%-- <img src="<%=cp%>/data/images/btn_cancel.gif"> --%>
					
				</a></td>

			</tr>

		</table>
	</form>
</body>
</html>