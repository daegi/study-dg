<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		//PreparedStatement stmt=null;
		CallableStatement stmt = null;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String hp = request.getParameter("hp");
			String zip = request.getParameter("zip");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");

	

			StringBuilder sql = new StringBuilder();
			// call 프로시저이름(매개변수)
			sql.append("{call member_insert(?,?,?,?,?,?,?,?) }");
			stmt = conn.prepareCall(sql.toString());
			// stmt.set자료형( 물음표순서, 입력할 값 )  
			stmt.setString(1, userid );
			stmt.setString(2, passwd);
			stmt.setString(3, name);
			stmt.setString(4, email);
			stmt.setString(5, hp);
			stmt.setString(6, zip);
			stmt.setString(7, address1);
			stmt.setString(8, address2);
			
			// executeQuery() - select 문장
			// executeUpdate() - insert, delete, update 문장
			//stmt.executeUpdate();
			stmt.execute();
			// 페이지 이동
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>





