<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<!-- Ŭ���� ����Ʈ -->
<!-- WebContent/WEB-INF/lib ������ ojdbc6.jar ����
WebContent/WEB-INF/lib ���� : �ܺζ��̺귯�� ���� ����
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<!-- ���̺� �׵θ��� 1�� ���� -->
		<tr>
			<!-- Table Row ���̺��� �� -->
			<td>���</td>
			<!-- Table Division ���̺��� �� -->
			<td>�̸�</td>
			<td>�μ�</td>
		</tr>
		<%
			// �ڹ��ڵ� ����, scriptlet(��ũ��Ʋ��) 
			String driver = "oracle.jdbc.driver.OracleDriver";
			// ����Ŭ ���� ���ڿ� jdbc:oracle:thin:@�����ּ�:��Ʈ:DB�̸�
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr"; // ����Ŭ ����ڰ���
			String pwd = "hr"; // ����ڰ����� ��й�ȣ
			// DB������ ó���ϴ� �������̽�
			Connection conn = null; // java.sql.Connection
			Statement stmt = null; // java.sql.Statement
			ResultSet rs = null;
			// DB���� �۾��� �ݵ�� ����ó���� �ؾ� ��
			try {
				Class.forName(driver); // jdbc ����̹� Ŭ���� �ε�
				conn = DriverManager.getConnection(url, id, pwd); // ����Ŭ�� ����
				// System.out.println("����Ŭ�� ���ӵǾ����ϴ�.");
				// sql ���� �ۼ�
				String sql = 
"select "
+" employee_id, first_name, department_name, e.department_id "
+" from employees e, departments d "   
+" where e.department_id = d.department_id";
				// Statement��ü = Ŀ�ؼ�.createStatement() : �������ఴü ����
				stmt = conn.createStatement();
				// ����� = Statement��ü.executeQuery( ������ ) ���� ����
				rs = stmt.executeQuery(sql);
				while (rs.next()) { // ���� ���ڵ尡 �����ϸ�				
					// �����.get�ڷ���("�÷�")
					// System.out.println() ��Ĺ �ܼ�â�� ���(���������ڿ�)
					// out.println() ���������� ���			
					//				out.println(rs.getInt("eno") + "\t" + rs.getString("ename")
					//						+ "\t" + rs.getInt("salary")+"<br>");
		%>
		<tr>
			<td><%=rs.getInt("employee_id")%></td>
			<td><%=rs.getString("first_name")%></td>
			<td><%=rs.getString("department_name")%></td>
		</tr>
		<%
			} //while�� �� 
			} catch (Exception e) {
				e.printStackTrace();
			} finally { // ������ �������� �ݾ���
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				} // try
			} // while
		%>
	</table>
</body>
</html>








