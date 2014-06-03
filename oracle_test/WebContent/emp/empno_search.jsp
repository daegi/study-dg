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
		// operner : 부모창
		opener.document.form1.empno.value = from1.empno.value;
		window.close();//현재 창을 닫음
	}
</script>



</head>
<body>
	<h2>사번 조회</h2>
	<!-- action 생략 => 현재 페이지가 reloading됨 -->
	<%
		//request.getParameter("변수명")
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
				count = rs.getInt(1); //컬럼 인덱스(1부터)
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
	<form method="post" name="from1">
		사번을 입력하세요 <input type="text" name="empno" value="<%=empno%>">
		<input type="submit" value="확인">
	</form>
	<%
		if (!empno.equals("")) {
			if (count == 0) {
	%>
	사용가능한 사번입니다.
	<input type="button" value="사번입력" onclick="empno_input()">
	<%
		} else {
	%>
	사용할 수 없는 사번입니다.
	<%
		}
		}
	%>
</body>
</html>








