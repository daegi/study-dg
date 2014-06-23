<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page errorPage="/error.jsp" %>

<%!
   int n=0;
%>

<%
    Calendar cal=Calendar.getInstance();
    
	// int age=Integer.parseInt(request.getParameter("age"));
	// String s="나이 : " + age;
	
	int m=0;
	
	n++;
	m++;
	
	String s="n:"+n+",m:"+m;

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=s%><br/>

<table border="1" width="500">
<%for(int i=1; i<=5; i++) { %>
   <tr height="25">
		<%for(int j=1; j<=10; j++) {
		    out.print("<td>"+i*j+"</td>");
		} %>   
   </tr>
<%} %>
</table>



</body>
</html>