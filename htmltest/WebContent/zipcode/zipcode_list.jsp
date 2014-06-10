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
	<form id="form1" name="form1">
		<%
			Context context = null;
			DataSource ds = null;
			Connection conn = null;
			PreparedStatement stmt_sido = null, stmt_gugun = null, stmt_dong = null, stmt_list = null;
			ResultSet rs_sido = null, rs_gugun = null, rs_dong = null, rs_list = null;
			String sido = "", gugun = "";
			if (request.getParameter("sido") != null) {
				sido = request.getParameter("sido");
			}
			try {
				context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
		%>
		<select name="sido" onchange="document.form1.submit()">
			<%
				StringBuilder sql = new StringBuilder();
					sql.append("select distinct sido from zipcode order by sido");
					stmt_sido = conn.prepareStatement(sql.toString());
					rs_sido = stmt_sido.executeQuery();

					while (rs_sido.next()) {
						String strSido = rs_sido.getString("sido");
			%>
			<option value="<%=strSido%>"><%=strSido%></option>
			<%
				}
			%>
		</select> <select name="gugun">
			<%
				StringBuilder sql_gugun = new StringBuilder();
					sql_gugun.append("select distinct gugun from zipcode");
					sql_gugun.append(" where sido=? order by gugun");
					System.out.println(sql_gugun + "\n" + sido);
					stmt_gugun = conn.prepareStatement(sql_gugun.toString());
					stmt_gugun.setString(1, sido);
					rs_gugun = stmt_gugun.executeQuery();

					while (rs_gugun.next()) {
						gugun = rs_gugun.getString("gugun");
			%>
			<option value="<%=gugun%>"><%=gugun%></option>
			<%
				}
			%>
		</select>
		<%
			} catch (Exception e) {
				e.printStackTrace();
			} finally { // rs -> stmt -> conn 순으로 닫아줌
				try {
					if (rs_gugun != null)
						rs_gugun.close();
					if (rs_sido != null)
						rs_sido.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (stmt_gugun != null)
						stmt_gugun.close();
					if (stmt_sido != null)
						stmt_sido.close();
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







