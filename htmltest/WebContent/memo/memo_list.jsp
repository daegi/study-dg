<%@page import="oracle.jdbc.oracore.OracleType"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> 
<%@ page import="oracle.jdbc.OracleTypes" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
Context context=null;
DataSource ds=null;
Connection conn=null;
//Statement stmt=null;
//PreparedStatement stmt=null;
CallableStatement stmt=null;
ResultSet rs=null;
%>
<table border="1" width="600px"> <!-- 가로길이 600픽셀 -->
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>메모</td>
		<td>날짜</td>
	</tr>
<%
try{
	context = new InitialContext();
	ds = (DataSource)context.lookup(
			"java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	StringBuilder sql = new StringBuilder();
	//sql.append(" select * from memo order by idx desc ");
	sql.append( " { call memo_list(?)} ");  
	//stmt = conn.prepareStatement(sql.toString());
	stmt = conn.prepareCall(sql.toString());
	// 1번 출력매개변수의 타입을 커서로 지정 
	stmt.registerOutParameter(1, OracleTypes.CURSOR);
	// 프로시저 실행
	stmt.execute();
	//rs = stmt.executeQuery();
	// 출력매개변수의 결과값을 ResultSet으로 변환
	rs = (ResultSet)stmt.getObject(1);
	while( rs.next() ) {
		String writer = rs.getString("writer");
		// 스트링.replace(A,B)  A를 B로 변경
		writer = writer.replace("<", "&lt;"); // Less Than
		writer = writer.replace(">", "&gt;"); // Greater Than
		String memo = rs.getString("memo");
		memo = memo.replace("<", "&lt;");
		memo = memo.replace(">", "&gt;");
%>
		<tr>
			<td><%=rs.getInt("idx")%></td>
			<td><%=writer%></td>
			<td>
		<a href="memo_view.jsp?idx=<%=rs.getInt("idx")%>">
			<%=memo%></a>
			</td>
			<td><%=rs.getDate("post_date")%></td>
		</tr>
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
	</table>
</body>
</html>






