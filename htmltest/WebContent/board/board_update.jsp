<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>   
<%
request.setCharacterEncoding("utf-8"); //한글 인코딩 방식 설정
DataSource ds=null;
Connection conn=null;
//PreparedStatement pstmt = null;
CallableStatement pstmt=null;
try{
	Context context = new InitialContext();
	ds = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	StringBuffer sql = new StringBuffer();
/* 	sql.append("update board");
	sql.append(" set name=?, subject=?, content=?");
	sql.append(" where idx=?"); */
	// {call 저장프로시저이름(매개변수)}
	sql.append( "{call board_update(?,?,?,?)}" );
	//pstmt = conn.prepareStatement(sql.toString());
	pstmt = conn.prepareCall(sql.toString()); 
	pstmt.setString(1, request.getParameter("name"));
	pstmt.setString(2, request.getParameter("subject"));
	pstmt.setString(3, request.getParameter("content"));
	pstmt.setString(4, request.getParameter("idx")); 
	//pstmt.executeUpdate();
	pstmt.execute();
	response.sendRedirect("board.jsp");
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>