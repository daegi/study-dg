<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	String name=request.getParameter("name");
	String memo=request.getParameter("memo").replaceAll("\n", "<br>");
	String []h=request.getParameterValues("hobby");
	String hobbys="";
	if(h!=null) {
		for(String s: h)
			hobbys+=s+",";
		
		 hobbys=hobbys.substring(0, hobbys.length()-1);
	}

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : <%=name%><br/>
소개 : <%=memo%><br/>
취미 : <%=hobbys%><br/>

</body>
</html>