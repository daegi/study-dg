
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<h2>html 태그를 이용한 글꼴 크기 설정</h2>
<%
for( int i=1; i<=7; i++ ){
	out.println( "<font size='"+ i +"'>글꼴 크기 테스트</font><br>" );
}
%>
<h2>스타일시트를 이용한 글꼴 크기 설정</h2>
<%
for( int i=10; i<=50; i++ ){
// inline css (태그의 style 속성에 스타일시트를 작성 )	
// <font style="font-size:10pt">...   style="속성:값; 속성:값;"	
	out.println( "<font style='font-size:"+ i +"pt'>글꼴 크기 테스트</font><br>" );
}
%>
</body>
</html>











