
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<%
int dan = Integer.parseInt( request.getParameter("dan") );
for( int i=1; i<=9; i++ ){
	//System.out.println( dan +"x"+ i +"="+ dan*i ); //톰캣 콘솔창에 출력됨
// out - JSP의 내장객체( request, response, session 등 )	
	out.println( dan +"x"+ i +"="+ dan*i +"<br>"); //웹브라우저에 출력됨
// 웹브라우저에 줄바꿈을 하기 위해서는 <br> 태그를 입력해야 함 	
}
%>
</body>
</html>











