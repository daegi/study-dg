<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--     emp_dept_list.jsp
    emp_dept_view를 활용하여
    
    사번 / 이름 / 부서코드 / 부서이름   출력 -->
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
<a href="emp_write.jsp">사원등록</a>
<table border="1" width="600px"> 
	<tr>
		<td>사번</td>
		<td>이름</td>
		<td>부서코드</td>
		<td>부서이름</td>
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
// 사번, 이름, 급여, 부서코드 입력 폼 작성	
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
}finally{  // rs -> stmt -> conn 순으로 닫아줌
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






