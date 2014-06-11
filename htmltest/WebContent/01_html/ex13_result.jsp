<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
// 체크박스의 경우 체크된 값이 배열로 저장됨
String[] hobby = request.getParameterValues("hobby");
String memo = request.getParameter("memo");
// 줄바꿈 문자 처리
memo = memo.replace("\n", "<br>"); 
%>
직업 : <%=request.getParameter("job") %><br>
취미 : 
<%
if( hobby != null ) {
	for(int i=0; i<hobby.length; i++){
		out.println( hobby[i] + " ");
	}
}
%>
<br>
메모 : 
<br>
<%=memo %>
</body>
</html>









