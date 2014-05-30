<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>방명록</h2>
<!-- location.href= "이동할 주소" -->
<input type="button" value="글쓰기"
	onclick="location.href='gb_write.jsp';"> 
<%
Context context=null;
DataSource ds=null;
Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
try{
	context = new InitialContext();
	ds = (DataSource)context.lookup(
			"java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append(" select * from guestbook order by idx desc ");
	stmt = conn.prepareStatement(sql.toString());
	rs = stmt.executeQuery();
	while( rs.next() ) {
		String name = rs.getString("name");
		name = name.replace("<", "&lt;");
		name = name.replace(">", "&gt;");
		String content = rs.getString("content");
		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");
%>		
<table border="1" width="500px">
	<tr>
		<td>이름</td>
		<td><%=name%></td>
		<td>날짜</td>
		<td><%=rs.getDate("post_date") %></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td colspan="3"><%=rs.getString("email") %></td>
	</tr>
	<tr>
		<td colspan="4"><%=content%></td>
	</tr>
</table>
<%		
	}
}catch(Exception e){
	e.printStackTrace();
}finally{  // rs -> stmt -> conn 순으로 닫아줌
	try{
		if( rs != null ) rs.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		if( stmt != null ) stmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		if( conn != null ) conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
</body>
</html>



