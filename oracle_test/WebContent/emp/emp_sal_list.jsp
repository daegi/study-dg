<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--     WebContent/emp/emp_list.jsp
    emp_sal_view �並 Ȱ���Ͽ� ȭ�鿡 ���
    
    �μ��� / ������ / ��ձ޿� / �ְ��޿� / �����޿�
 -->    
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
<table border="1" width="600px"> 
	<tr>
		<td>�̸�</td>
		<td>����</td>
		<td>����</td>
		<td>�Ǽ��ɾ�</td>
	</tr>
<%
try{
	context = new InitialContext();
	ds = (DataSource)context.lookup(
			"java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append(" select ename, fn_emp_sal( empno) ���� ");
	sql.append(", fn_emp_tax( empno, 0.04 ) ���� ");
	sql.append(", fn_emp_sal( empno) - fn_emp_tax( empno, 0.04 )  �Ǽ��ɾ� ");
	sql.append(" from emp order by �Ǽ��ɾ� desc ");
	stmt = conn.prepareStatement(sql.toString());
	rs = stmt.executeQuery();
	while( rs.next() ) {
%>
		<tr>
			<td><%=rs.getString("ename")%></td>
			<td><%=rs.getInt("����")%></td>
			<td><%=rs.getInt("����")%></td>
			<td><%=rs.getInt("�Ǽ��ɾ�")%></td>
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





