
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
	function idcheck() {
		var form1 = document.getElementById("form1");
		var userid = document.getElementById("userid");
		if (userid.value != "") { // 아이디가 빈값이 아니면 쿼리 실행 요청
			form1.submit();
		}
	}
	function use_id(){
		//아이디 사용 버튼 클릭
// 		$("#btnUse").click(function(){
// 			// 달러("태그", opener.document)    팝업창을 띄운 메인창의 태그를 선택함
// 			// 태그.val( 값 )		 태그에 값을 설정함
// 			$("#userid", opener.document).val( "${userid}" );
// 			window.close();  //현재 창을 닫음
// 		});		
		// 부모창(팝업창을 오픈한 창에 값을 넘겨줌)
		opener.form1.userid.value = form1.userid.value;
		opener.form1.idcheck.value = "Y"; // id check 값을 설정
		window.close(); //현재 창을 닫음
	}
</script>
</head>
<body>
	<h2>아이디 중복 확인</h2>
	<%
		String userid = "";
		if (request.getParameter("userid") != null) {
			userid = request.getParameter("userid");
		}		
	%>
	<form name="form1" id="form1" method="post">
		<input type="text" name="userid" id="userid" value="<%=userid%>" /> <input
			type="button" value="확인" onclick="javascript:idcheck();" /> <br>
		<%
			DataSource ds = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
				String sql = "select count(*) from member where userid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					count = rs.getInt(1); // 0이면 사용가능, 1이면 사용불가
				}
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

			if (!userid.equals("")) {
				if (count == 0) { // 아이디 사용가능
		%>
		<font color="blue"><b>사용가능한 아이디입니다.</b></font> <input type="button"
			value="아이디사용" onclick="javascript:use_id();" />
		<%
				} else { //아이디 사용 불가
		%>
		<font color="red"><b>사용할 수 없는 아이디입니다.</b></font>
		<%
				}
			}
		%>

	</form>
</body>
</html>










