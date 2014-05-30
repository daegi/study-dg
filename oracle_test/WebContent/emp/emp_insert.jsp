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
PreparedStatement pstmt = null; // SQL문장을 실행 요청
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
	StringBuffer sql = new StringBuffer();
	sql.append( "insert into ");
	sql.append(" emp ");
	sql.append(" (empno, ename, deptno) values ");
	sql.append( "	( ?,?,?) ");
	// Sql 문장을 실행시키는 객체 생성
	pstmt = conn.prepareStatement(sql.toString());
	// 물음표에 대입할 값들을 입력함
	// 물음표 인덱스는 1부터 시작
	// request.getParameter("변수명")
//<input type="text" name="name">	
	pstmt.setString(1, request.getParameter("empno"));
	pstmt.setString(2, request.getParameter("ename"));
	pstmt.setString(3, request.getParameter("deptno"));
	// SQL문장 실행 요청
	pstmt.executeUpdate();
	// 페이지를 이동시킴
	response.sendRedirect("emp_dept_list.jsp");
	//out.println("입력되었습니다.");
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