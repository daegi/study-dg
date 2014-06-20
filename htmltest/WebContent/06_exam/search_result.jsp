<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- page import="Ŭ����" -->
<%@ page import="java.sql.*"%>
<!-- tomcat-dbcp.jar -->
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
		Context context = null; //context.xml ������ �м�
		// DataBase Connection Pool (�����ͺ��̽� ���� Ǯ)		
		DataSource ds = null; // DBCP ������ �м�
		Connection conn = null; // DB�� ����ó��
		PreparedStatement stmt = null; // SQL ���� ����
		ResultSet rs = null; // select ������ ����� ó��
		try {
			// ������ - �캯�� �ִ� Ŭ������ �޼ҵ尡 �����
			context = new InitialContext();

			ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from keywords where keyword like ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, "%" + request.getParameter("search") + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				out.println(rs.getString("keyword") + "<br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // rs -> stmt -> conn ������ �ݾ���
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
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




