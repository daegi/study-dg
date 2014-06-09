
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
function send() {
	var message = document.getElementById("message");
// opener 팝업창을 오픈한 부모창	
	opener.document.form1.msg.value = message.value;
}
</script>
</head>
<body>
<%
String msg = request.getParameter("msg");
msg = new String( msg.getBytes("8859_1"), "euc-kr");
/*JSP에서 한글 처리하는 방법
post 방식 : JSP 페이지의 상단에 request.setCharacterEncoding("utf-8");
get 방식 : 문자열 = new String( 문자열.getBytes("8859_1"), "euc-kr");
		문자열.getBytes() ==> 문자열을 바이트배열로 변환시킴
		8859_1 서유럽언어 인코딩을 euc-kr 인코딩으로 변환
*/
%>
	부모창에서 전송한 메시지 : <%=msg%><br>
	<form name="form1" id="form1" method="post">
		입력하세요
		<input type="text" name="message" id="message" />
		<input type="button" value="부모창에 전송" onclick="javascript:send()" />
	</form>
	
	
	<input type="button" value="닫기" onclick="window.close()" />
	<img src="../images/tree2.jpg"  />
</body>
</html>










