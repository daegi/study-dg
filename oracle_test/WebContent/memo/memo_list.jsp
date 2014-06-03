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

		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		//Statement stmt=null;
		//PreparedStatement stmt=null;
		CallableStatement stmt = null;
		ResultSet rs = null;
	%>
	<!-- 메모입력폼 -->
	<!-- action="자료를 처리할 페이지의 주소" -->
	<form method="post" action="memo_insert.jsp">
		이름 <input type="text" name="writer"> 메모 <input type="text"
			name="memo" size="30"> <input type="submit" value="확인">
		<!-- 전송버튼 -->
	</form>

	<table border="1" width="600px">
		<!-- 가로길이 600픽셀 -->
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>메모</td>
			<td>날짜</td>
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
				// 1번 출력매개변수의 타입을 커서로 지정 
				stmt.registerOutParameter(1, OracleTypes.CURSOR);
				// 프로시저 실행
				stmt.execute();
				//rs = stmt.executeQuery();
				// 출력매개변수의 결과값을 ResultSet으로 변환
				rs = (ResultSet) stmt.getObject(1);
				while (rs.next()) {
					String writer = rs.getString("writer");
					// 스트링.replace(A,B)  A를 B로 변경
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






