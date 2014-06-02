<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!-- j2se의 jdbc 기본라이브러리 -->
<!-- 톰캣의 dbcp(DataBase Connection Pool) 라이브러리 -->
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
	DataSource ds = null;
	Connection conn = null;
	CallableStatement pstmt = null;
	try {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		String sql = "{call memo_delete(?)}";
		pstmt = conn.prepareCall(sql);
		request.setCharacterEncoding("utf-8"); //한글 인코딩 설정
		pstmt.setInt(1, Integer.parseInt(request.getParameter("idx")));
		pstmt.execute();
		response.sendRedirect("memo_list.jsp");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
%>