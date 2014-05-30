<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   <!-- j2se의 jdbc 기본라이브러리 -->
<!-- 톰캣의 dbcp(DataBase Connection Pool) 라이브러리 -->  
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
DataSource ds=null;
Connection conn = null;
PreparedStatement pstmt=null;
try{
	// 톰캣 설정파일 context.xml에서 dbcp 정보를 읽어옴
	Context context = new InitialContext(); 
	// context.xml을 검색, java:comp/env/ ==> Resource태그
	// jdbc/OracleDB   <Resource name="jdbc/OracleDB" ...>
	ds = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
	// db connection open
	conn = ds.getConnection();
	String sql = "update memo set writer=?, memo=?, post_date=sysdate where idx=?";
	// sql 구문을 실행할 statement 객체 생성
	pstmt = conn.prepareStatement(sql);
	// 물음표 자리에 들어갈 파라미터값을 연결시켜 줌(매핑작업)
	request.setCharacterEncoding("utf-8"); //한글 인코딩 설정
// statement객체.set자료형( 물음표위치, 물음표에 대입할 값 )	
	pstmt.setString(1, request.getParameter("writer"));
	pstmt.setString(2, request.getParameter("memo"));
	pstmt.setInt(3, Integer.parseInt( request.getParameter("idx")));
	// update query 실행
	pstmt.executeUpdate();
	// 페이지 이동
	response.sendRedirect("memo_list.jsp");
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