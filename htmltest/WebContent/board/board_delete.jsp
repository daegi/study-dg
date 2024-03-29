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
CallableStatement pstmt = null;
try{
	Context context = new InitialContext();
	ds = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	StringBuffer sql = new StringBuffer();
	//sql.append("delete from board where idx=?");
	sql.append( "{call board_delete(?)} ");
	//pstmt = conn.prepareStatement(sql.toString());
	pstmt = conn.prepareCall(sql.toString()); 
	pstmt.setString(1, request.getParameter("idx"));
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