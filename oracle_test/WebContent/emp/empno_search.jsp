<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- empno_search.jsp -->
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function empno_input() {
		// operner : �θ�â
		opener.document.form1.empno.value = from1.empno.value;
		window.close();//���� â�� ����
	}
</script>



</head>
<body>
	<h2>��� ��ȸ</h2>
	<!-- action ���� => ���� �������� reloading�� -->
	<%
		//request.getParameter("������")
		String empno = request.getParameter("empno");
		if (empno == null)
			empno = "";
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select count(*) from  emp where empno=? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, empno);
			rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1); //�÷� �ε���(1����)
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
	<form method="post" name="from1">
		����� �Է��ϼ��� <input type="text" name="empno" value="<%=empno%>">
		<input type="submit" value="Ȯ��">
	</form>
	<%
		if (!empno.equals("")) {
			if (count == 0) {
	%>
	��밡���� ����Դϴ�.
	<input type="button" value="����Է�" onclick="empno_input()">
	<%
		} else {
	%>
	����� �� ���� ����Դϴ�.
	<%
		}
		}
	%>
</body>
</html>








