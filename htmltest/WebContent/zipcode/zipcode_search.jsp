
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
function zipcode_copy( zipcode, address ) {
// opener - 팝업창을 오픈한 부모창	
	opener.form1.zipcode.value = zipcode;
	opener.form1.address1.value = address;
	window.close(); //현재 창을 닫음
}
</script>
<script type="text/javascript">
	function post_search() {
		var form1 = document.getElementById("form1");
		var dong = document.getElementById("dong");
		if (dong.value != "") { //동이 빈값이 아니면 전송(액션이 없으므로 현재페이지로 전송)
			form1.submit();
		}
	}
</script>
</head>
<body>
	<h2>우편번호 찾기</h2>
	<form name="form1" id="form1" method="post">
		동면리를 입력하세요 <input type="text" name="dong" id="dong" /> <input
			type="button" value="찾기" onclick="javascript:post_search();" />
	</form>
	<%
		request.setCharacterEncoding("utf-8"); //한글 인코딩 방식 설정
		//동면리 select 태그의 선택값이 있으면 받아옴
		String p_dong = "";
		if (request.getParameter("dong") != null) {
			p_dong = request.getParameter("dong");
		}
		// 문자열.trim() ==> 문자열의 좌우 공백 제거
		if (!p_dong.trim().equals("")) { // 동면리가 빈 값이 아니면 쿼리 실행

			DataSource ds = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				Context context = new InitialContext();
				ds = (DataSource) context
						.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
				String sql = "select * from zipcode	where dong like ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, p_dong + "%");
				rs = pstmt.executeQuery();
	%>
	<table border="1" style="width:600px">
		<tr>
			<td width="20%">우편번호</td>
			<td width="80%">주소</td>
		</tr>
		<%
			while (rs.next()) {
						String zipcode = rs.getString("zipcode");
						String sido = rs.getString("sido");
						String gugun = rs.getString("gugun");
						String dong = rs.getString("dong");
						String bunji = rs.getString("bunji");
						String address = sido + " " + gugun + " " + dong + " "
								+ bunji;
						String address2 = sido + " " + gugun + " " + dong ;
		%>
		<tr>
			<td><%=zipcode%></td>
			<td>
<a href="javascript:zipcode_copy('<%=zipcode%>','<%=address2%>')">
	<%=address%>
</a>
			</td>
		</tr>
		<%
			} //while의 끝
		%>
	</table>
	<%
		} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
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












