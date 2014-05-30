<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--     emp_dept_list.jsp
    emp_dept_view�� Ȱ���Ͽ�
    
    ��� / �̸� / �μ��ڵ� / �μ��̸�   ��� -->
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
Context context=null;
DataSource ds=null;
Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
%>
<a href="emp_write.jsp">������</a>
<table border="1" width="600px"> 
	<tr>
		<td>���</td>
		<td>�̸�</td>
		<td>�μ��ڵ�</td>
		<td>�μ��̸�</td>
	</tr>
<%
try{
	context = new InitialContext();
	ds = (DataSource)context.lookup(
			"java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append(" select * from emp_dept_view ");
	stmt = conn.prepareStatement(sql.toString());
	rs = stmt.executeQuery();
// ���, �̸�, �޿�, �μ��ڵ� �Է� �� �ۼ�	
	while( rs.next() ) {
%>
		<tr>
			<td><%=rs.getInt("empno")%></td>
			<td><%=rs.getString("ename")%></td>
			<td><%=rs.getInt("deptno")%></td>
			<td><%=rs.getString("dname")%></td>
		</tr>
<%		
	}
}catch(Exception e){
	e.printStackTrace();
}finally{  // rs -> stmt -> conn ������ �ݾ���
	try{
		if( rs != null ) rs.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		if( stmt != null ) stmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		if( conn != null ) conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
	</table>
</body>
</html>






