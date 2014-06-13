<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function zipcode_copy( zipcode, address ) {
	// opener 팝업창을 오픈한 부모창(메인창)
opener.document.getElementById("zipcode").value= zipcode;
opener.document.getElementById("address1").value= address;
window.close(); //현재 창을 닫음
}
</script>
</head>
<body>
	<h2>우편번호 찾기</h2>
	<%
		request.setCharacterEncoding("utf-8");  //한글 처리
		String dong = request.getParameter("dong");
		if (dong == null)
			dong = "";
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	%>
	<form id="form1" method="post">
		동을 입력하세요 
		<input type="text" name="dong" value="<%=dong%>"> 
		<input type="submit" value="확인">
	</form>
	<%
		if (!dong.equals("")) { //빈값이 아니면 검색
			try {
				context = new InitialContext();
				ds = (DataSource) context
						.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append(" select * from zipcode where dong like ? ");
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, dong + "%");
				rs = stmt.executeQuery();
	%>
	<table border="1" width="550px">
		<tr>
			<td>우편번호</td>
			<td>주소</td>
		</tr>
		<%
			while (rs.next()) {
						String zipcode = rs.getString("zipcode");
						String address = rs.getString("sido") + " "
								+ rs.getString("gugun") + " "
								+ rs.getString("dong") + " "
								+ rs.getString("bunji");
						String address2 = rs.getString("sido") + " "
								+ rs.getString("gugun") + " "
								+ rs.getString("dong") ;				
		%>
		<tr>
			<td><%=zipcode%></td>
			<td>
<!-- href="#" 널링크 - 페이지가 이동되지 않도록 처리 -->
				<a href="#" 
onclick="zipcode_copy('<%=zipcode%>','<%=address2%>')"><%=address%></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
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
		}
	%>
</body>
</html>









