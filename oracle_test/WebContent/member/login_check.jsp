<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- login_check.jsp -->    
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
<%
// request.getParameter("태그의 name속성값")
String userid = request.getParameter("userid");
String passwd= request.getParameter("passwd");
%>
아이디 : <%=userid%><br>
비번 : <%=passwd%><br>
<%
Context context=null;
DataSource ds=null;
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
try{
	context = new InitialContext();
	ds = (DataSource)context.lookup(
			"java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append(" select name from member ");
// userid='"+ 변수 +"'  	
	sql.append(" where userid='"+ userid +"' ");
	sql.append(" and passwd='"+ passwd + "' ");
	out.println(sql);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql.toString());
	if( rs.next() ) {
		out.println( rs.getString("name")+"님 반갑습니다.");		
	}else{
		out.println( "아이디 또는 비번이 일치하지 않습니다.");
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





