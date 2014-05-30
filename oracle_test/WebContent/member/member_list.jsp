<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- page import="클래스" -->
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
		Context context = null; //context.xml 파일을 분석
// DataBase Connection Pool (데이터베이스 연결 풀)		
		DataSource ds = null; // DBCP 정보를 분석
		Connection conn = null; // DB에 접속처리
		PreparedStatement stmt = null; // SQL 문장 실행
		ResultSet rs = null; // select 쿼리의 결과를 처리
	%>
	<table border="1" width="600px">
		<!-- 가로길이 600픽셀 -->
		<tr>  <!-- Table Row 테이블의 행 -->
			<td>아이디</td> <!-- Table Division 테이블의 셀 -->
			<td>이름</td>
			<td>비번</td>
		</tr>
		<%
			try {
				// 다형성 - 우변에 있는 클래스의 메소드가 실행됨
				context = new InitialContext();
				
				ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append(" select * from member order by name ");
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("userid")%></td>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("passwd")%></td>
		</tr>
		<%
			}
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
	</table>
</body>
</html>





