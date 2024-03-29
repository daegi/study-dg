<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- login_check.jsp -->    
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
// request.getParameter("태그의 name속성값")
String userid = request.getParameter("userid");
String passwd= request.getParameter("passwd");
%>
아이디 : <%=userid%><br>
비번 : <%=passwd%><br>
<%
// Statment보다 PreparedStatement 사용을 권장함
// 코딩하기 쉬움
// SQL injection 공격에 안전함
// 쿼리 실행 속도가 빠름
/* where userid='kim' and passwd='1234'
where userid='park' and passwd='1234'
where userid='hong' and passwd='1234'
모두 다른 쿼리로 인식 : 컴파일, 실행계획, 실행
where userid=? and passwd=?
*/

Context context=null;
DataSource ds=null;
Connection conn=null;
//Statement stmt=null;
PreparedStatement stmt=null;
ResultSet rs=null;
try{
	context = new InitialContext();
	ds = (DataSource)context.lookup(
			"java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append(" select name from member ");
// userid='"+ 변수 +"'  	
	sql.append(" where userid=? ");
	sql.append(" and passwd=? ");
	stmt = conn.prepareStatement(sql.toString());
	stmt.setString(1, userid);
	stmt.setString(2, passwd);
	rs = stmt.executeQuery();
	if( rs.next() ) {
		out.println( rs.getString("name")+"님 반갑습니다.");		
	}else{
		out.println( "아이디 또는 비번이 일치하지 않습니다.");
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
</body>
</html>





