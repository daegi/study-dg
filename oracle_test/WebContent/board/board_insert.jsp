<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 클래스 import -->    
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>   
<%
// euc-kr	한국어만 처리 가능
// utf-8	다국어 처리 가능
request.setCharacterEncoding("utf-8"); //한글 인코딩 방식 설정
DataSource ds=null; // DB소스(DBCP)
// DataBase Connection Pool
// context.xml
Connection conn=null; // DB접속처리
//PreparedStatement pstmt = null; // SQL문장을 실행 요청
CallableStatement pstmt = null;
try{
	// context.xml에 설정된 DBCP 정보를 읽는 코드
	Context context = new InitialContext();
// java:comp/env/DBCP변수명	
//<Resource name="변수명" 
	ds = (DataSource)context.lookup(
			"java:comp/env/jdbc/OracleDB");
	// DBCP에서 커넥션 1개를 받아옴
	conn = ds.getConnection();
	// SQL문장 작성
	//StringBuffer sql = new StringBuffer();
// String
// StringBuilder
	StringBuilder sql = new StringBuilder();
/* 	sql.append( "insert into board ");
	sql.append("(idx,name,subject,content) values");
	sql.append( "( (select nvl( max(idx)+1, 1 ) from");
	sql.append("board),?,?,?) "); */
	sql.append("{call board_insert(?,?,?)}");
	//pstmt = conn.prepareStatement(sql.toString());
	pstmt = conn.prepareCall(sql.toString()); 
	pstmt.setString(1, request.getParameter("name"));
	pstmt.setString(2, request.getParameter("subject"));
	pstmt.setString(3, request.getParameter("content"));
	//pstmt.executeUpdate();
	pstmt.execute();
	response.sendRedirect("board_list.jsp");
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