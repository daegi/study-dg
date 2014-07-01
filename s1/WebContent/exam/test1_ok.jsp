<%@page import="java.io.DataInputStream"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("utf-8");
	//enctype="multipart/form-data"는 아래와 같이 받을수 없다
	//String subject = request.getParameter("subject");
	//String upload = request.getParameter("upload");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String contentType=request.getContentType();

	Enumeration e=request.getHeaderNames();
	out.println("서버로 넘어온 해더정보...<br/>");
	while(e.hasMoreElements()) {
		String key=(String)e.nextElement();
		String value=request.getHeader(key);
		out.println(key+":"+value+"<br/>");
	}
	
	out.println("<br/>서버로 넘어온 데이터...<br/>");
	DataInputStream dis=new DataInputStream(
			request.getInputStream());
	String s;
	while((s=dis.readLine())!=null) {
		out.println(new String(
				s.getBytes("ISO-8859-1"),"euc-kr")+"<br/>");
	}
%>
</body>
</html>