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
<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css" />

<script type="text/javascript" src="<%=cp%>/data/js/util.js"></script>
<script type="text/javascript">
function sendNotice() {
    var f = document.noticeForm;
    var mode ="${mode}";

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
	
	
	if(mode=="created")
	       f.action="<%=cp%>/notice/created_ok.do";
	    else if(mode=="update")
	       f.action="<%=cp%>/notice/update_ok.do";

		f.submit();

	}
</script>


</head>
<body>
	<div class="layoutMain">
		<div class="layoutHeader">
			<jsp:include page="/layout/header.jsp"></jsp:include>
		</div>

	<form name="noticeForm" method="post" onsubmit="return sendNotice()">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" size="60"
					value="${dto.subject}"></td>
			</tr>

			<tr>
				<td>이름</td>
				<td>${sessionScope.session.userName}</td>
			</tr>

			<tr>
				<td>내용</td>
				<td width="480"><textarea name="content" rows="20" cols="50">${dto.content}</textarea></td>
			</tr>


			<tr id="noticeCreated_footer" align="center">
				<td>
				<input type="button" value="등록하기" class="btn" onclick="sendNotice();"/>
					<input type="reset" value="다시입력" class="btn"/>
					<input type="button" value="등록취소" class="btn" onclick="javascript:location.href='<%=cp%>/notice/list.do';" />
				</td>
			</tr>
		</table>
	</form>
	<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>
	</div>
</body>
</html>