<%@page import="oracle.jdbc.oracore.OracleType"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		// Statment���� PreparedStatement ����� ������
		// �ڵ��ϱ� ����
		// SQL injection ���ݿ� ������
		// ���� ���� �ӵ��� ����
		/* where userid='kim' and passwd='1234'
		 where userid='park' and passwd='1234'
		 where userid='hong' and passwd='1234'
		 ��� �ٸ� ������ �ν� : ������, �����ȹ, ����
		 where userid=? and passwd=?
		 */

		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		//Statement stmt=null;
		//PreparedStatement stmt=null;
		CallableStatement stmt = null;
		ResultSet rs = null;
	%>
	<!-- �޸��Է��� -->
	<!-- action="�ڷḦ ó���� �������� �ּ�" -->
	<form method="post" action="memo_insert.jsp">
		�̸� <input type="text" name="writer"> �޸� <input type="text"
			name="memo" size="30"> <input type="submit" value="Ȯ��">
		<!-- ���۹�ư -->
	</form>

	<table border="1" width="600px">
		<!-- ���α��� 600�ȼ� -->
		<tr>
			<td>��ȣ</td>
			<td>�̸�</td>
			<td>�޸�</td>
			<td>��¥</td>
		</tr>
		<%
			try {
				context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
				StringBuilder sql = new StringBuilder();
				//sql.append(" select * from memo order by idx desc ");
				sql.append(" { call memo_list(?)} ");
				//stmt = conn.prepareStatement(sql.toString());
				stmt = conn.prepareCall(sql.toString());
				// 1�� ��¸Ű������� Ÿ���� Ŀ���� ���� 
				stmt.registerOutParameter(1, OracleTypes.CURSOR);
				// ���ν��� ����
				stmt.execute();
				//rs = stmt.executeQuery();
				// ��¸Ű������� ������� ResultSet���� ��ȯ
				rs = (ResultSet) stmt.getObject(1);
				while (rs.next()) {
					String writer = rs.getString("writer");
					// ��Ʈ��.replace(A,B)  A�� B�� ����
					writer = writer.replace("<", "&lt;"); // Less Than
					writer = writer.replace(">", "&gt;"); // Greater Than
					String memo = rs.getString("memo");
					memo = memo.replace("<", "&lt;");
					memo = memo.replace(">", "&gt;");
		%>
		<tr>
			<td><%=rs.getInt("idx")%></td>
			<td><%=writer%></td>
			<td><a href="memo_view.jsp?idx=<%=rs.getInt("idx")%>"> <%=memo%></a>
			</td>
			<td><%=rs.getDate("post_date")%></td>
		</tr>
		<%
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
	</table>
</body>
</html>






