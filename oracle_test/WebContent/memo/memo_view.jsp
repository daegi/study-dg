<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!-- j2se의 jdbc 기본라이브러리 -->
<!-- 톰캣의 dbcp(DataBase Connection Pool) 라이브러리 -->
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
	function memo_update() {
		var form1 = document.getElementById("form1");
		var writer = document.getElementById("writer");
		var memo = document.getElementById("memo");
		if (writer.value == "") {
			alert("이름을 입력하세요");
			writer.focus();
			return;
		}
		if (memo.value == "") {
			alert("메모를 입력하세요");
			memo.focus();
			return;
		}
		form1.action = "memo_update.jsp";
		form1.submit();
	}
	function memo_delete() {
		if (confirm("삭제하시겠습니까?")) { //확인 버튼을 클릭하면 true
			var form1 = document.getElementById("form1");
			form1.action = "memo_delete.jsp";
			form1.submit();
		}
	}
</script>
</head>
<body>
	<h2>메모 수정</h2>
	<%
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String writer = "";
		String memo = "";
// memo_view.jsp?idx=32   ( get방식 )
// 클릭하면 request 객체가 idx 변수에 32를 저장시킴
// request.getParameter("idx") => 32값을 꺼냄
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			String sql = " select * from memo where idx = ? ";
			pstmt = conn.prepareStatement(sql);
			// request.getParameter("idx") ==> String이므로 정수로 변환해야 함	
			pstmt.setInt(
				1, Integer.parseInt(request.getParameter("idx")));
			//	pstmt.setString(1, request.getParameter("idx"));
			rs = pstmt.executeQuery();
			if (rs.next()) { //레코드가 1건이므로 while 대신 if 사용
				writer = rs.getString("writer");
				memo = rs.getString("memo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != conn)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	%>
	<form name="form1" id="form1" method="post">
		<table border="1" style="width:550px">
			<tr>
				<td>이름</td>
				<!-- input 태그의 value 속성==> 태그에 표시되는 기본값 -->
				<td><input type="text" name="writer" id="writer"
					value="<%=writer%>" /></td>
			</tr>
			<tr>
				<td>메모</td>
				<td><input type="text" name="memo" id="memo" size="60"
					value="<%=memo%>"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<!-- 수정,삭제할 때 idx가 꼭 필요할 경우 hidden 태그에 저장 --> <input type="hidden"
					name="idx" id="idx" value="<%=request.getParameter("idx")%>" /> <input
					type="button" value="수정" onclick="javascript:memo_update();" /> <input
					type="button" value="삭제" onclick="javascript:memo_delete();" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>











