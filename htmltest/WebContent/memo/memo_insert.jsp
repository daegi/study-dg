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
<%
Context context=null;
DataSource ds=null;
Connection conn=null;
//PreparedStatement stmt=null;
CallableStatement stmt=null; //저장프로시저를 호출하는 객체
try{
	context = new InitialContext();
	ds = (DataSource)context.lookup(
			"java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	request.setCharacterEncoding("euc-kr");
	String writer = request.getParameter("writer");
	String memo = request.getParameter("memo");
	// 태그 문자 변환
	writer = writer.replace("<", "&lt;");
	writer = writer.replace(">", "&gt;");
	memo = memo.replace("<", "&lt;");
	memo = memo.replace(">", "&gt;");

	StringBuilder sql = new StringBuilder();
/* 	sql.append(" insert into memo (idx,writer,memo) values ");
	sql.append(" ( memo_seq.nextval , ?, ? )");
	stmt = conn.prepareStatement(sql.toString());
 */
 	// call 프로시저이름(매개변수)
 	sql.append( "{call memo_insert(?,?) }");
 	stmt = conn.prepareCall(sql.toString());
 	// stmt.set자료형( 물음표순서, 입력할 값 )  
	stmt.setString(1, writer);
	stmt.setString(2, memo); 
	// executeQuery() - select 문장
	// executeUpdate() - insert, delete, update 문장
	//stmt.executeUpdate();
	stmt.execute();
	
}catch(Exception e){
	e.printStackTrace();
}finally{  
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





