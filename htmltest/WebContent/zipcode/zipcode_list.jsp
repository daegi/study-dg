<%@page import="oracle.jdbc.oracore.OracleType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<%
			Context context = null;
			DataSource ds = null;
			Connection conn = null;
			PreparedStatement stmt_sido = null;
			PreparedStatement stmt_gugun = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt4 = null;
			
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			ResultSet rs = null;
			String sido = "", gugun = "";
			try {
				context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
		%>
		<select name="sido">
			<%
				StringBuilder sql = new StringBuilder();
					sql.append("select distinct sido from zipcode order by sido");
					stmt = conn.prepareStatement(sql.toString());
					rs = stmt.executeQuery();

					while (rs.next()) {
						sido = rs.getString("sido");
			%>
			<option value="<%=sido%>"><%=sido%></option>
			<%
				}
			%>
		</select> <select name="gugun"> select distinct gugun from zipcode
			where sido=? order by gugun
		</select>
		<%
			} catch (Exception e) {
				e.printStackTrace();
			} finally { // rs -> stmt -> conn 순으로 닫아줌
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
	</form>
</body>
</html>






