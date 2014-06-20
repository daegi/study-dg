<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="oracle.jdbc.*"%>
<%@ page import="java.math.BigDecimal"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		DataSource ds = null;
		Connection conn = null;
		//PreparedStatement pstmt = null, pstmt_view=null;
		CallableStatement pstmt = null;
		ResultSet rs = null;
		//댓글 목록 출력을 위한 객체 선언
		//PreparedStatement pstmt_count=null, pstmt_list=null;
		CallableStatement pstmt_count = null;
		//PreparedStatement pstmt_list=null;
		CallableStatement pstmt_list = null;
		ResultSet rs_count = null, rs_list = null;

		int hit = 0;
		String name = "", subject = "", post_date = "", content = "";
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			String sql = "{call comment_count(?,?)}";
			pstmt_count = conn.prepareCall(sql);
			//pstmt_count.setString(1, request.getParameter("idx"));
			pstmt_count.setInt(1,
					Integer.parseInt(request.getParameter("idx")));
			pstmt_count.registerOutParameter(2, OracleTypes.NUMBER);
			pstmt_count.execute();
			// Number => 10의 38승
			BigDecimal temp = (BigDecimal) pstmt_count.getObject(2);
			// BigDecimal => int로 변환
			int count = temp.intValue();

			if (count > 0) { //댓글 갯수가 0보다 크면 댓글 목록을 출력함
	%>
	<table border="1" style="width: 600px">
		<tr>
			<td>이름</td>
			<td>내용</td>
			<td>날짜</td>
		</tr>
		<%
			//댓글 목록 출력
					/* 	sql = "select * from board_comment 	where board_idx=? "
						+" order by idx desc"; */
					sql = "{call comment_list(?,?)}";
					//pstmt_list = conn.prepareStatement(sql);
					pstmt_list = conn.prepareCall(sql);
					pstmt_list.setString(1, request.getParameter("idx"));
					pstmt_list.registerOutParameter(2, OracleTypes.CURSOR);
					//rs_list = pstmt_list.executeQuery();
					pstmt_list.execute();
					rs_list = (ResultSet) pstmt_list.getObject(2);
					//댓글 목록
					while (rs_list.next()) {
						int c_idx = rs_list.getInt("idx");
						String c_name = rs_list.getString("name");
						String c_content = rs_list.getString("content");
						String c_post_date = rs_list.getString("post_date");
						// 태그 문자 변환
						c_name = c_name.replace("<", "&lt;");
						c_name = c_name.replace(">", "&gt;");
						c_content = c_content.replace("<", "&lt;");
						c_content = c_content.replace(">", "&gt;");
						// 공백 문자 처리( 스페이스한칸 ==> &nbsp; )
						c_name = c_name.replace(" ", "&nbsp;");
						c_content = c_content.replace(" ", "&nbsp;");
						// 줄바꿈 처리( \n ==> <br> )
						c_content = c_content.replace("\n", "<br>");
		%>
		<tr>
			<td><%=c_name%></td>
			<td><%=c_content%></td>
			<td><%=c_post_date%></td>
		</tr>
		<%
			}//while의 끝
		%>
	</table>
	<%
		}//if의 끝
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs_count != null)
					rs_count.close();
				if (rs_list != null)
					rs_list.close();
				if (pstmt_count != null)
					pstmt_count.close();
				if (pstmt_list != null)
					pstmt_list.close();
				//if( pstmt_view != null ) pstmt_view.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>









