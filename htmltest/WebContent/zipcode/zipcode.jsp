
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
</head>
<body>
	<h2>우편번호 찾기</h2>
	<!-- 폼에 액션을 지정하지 않으면 현재 페이지로 submit  -->
	<form name="form1" id="form1" method="post">
		<%
			request.setCharacterEncoding("utf-8"); //한글 인코딩 방식 설정

			//시도 select 태그의 선택값이 있으면 받아옴
			String p_sido = "";
			if (request.getParameter("sido") != null) {
				p_sido = request.getParameter("sido");
			}
			//구군 select 태그의 선택값이 있으면 받아옴
			String p_gugun = "";
			if (request.getParameter("gugun") != null) {
				p_gugun = request.getParameter("gugun");
			}
			//동면리 select 태그의 선택값이 있으면 받아옴
			String p_dong = "";
			if (request.getParameter("dong") != null) {
				p_dong = request.getParameter("dong");
			}

			DataSource ds = null;
			Connection conn = null;
			// sql 구문 1개당 PreparedStatement와 ResultSet 객체를 별도로 
			// 만들어주는 것이 정확한 결과를 얻을 수 있음.
			PreparedStatement pstmt = null, pstmt_gugun = null, pstmt_dong = null;
			PreparedStatement pstmt_list = null;
			ResultSet rs = null, rs_gugun = null, rs_dong = null, rs_list = null;

			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
				conn = ds.getConnection();
				String sql = "select distinct sido from zipcode order by sido";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
		%>
		<!-- onchange  ==> select 태그의 선택값이 바뀔 때 -->
		<select name="sido" id="sido" onchange="form1.submit();">
			<option value="">==시도==</option>
			<%
				while (rs.next()) {
						String sido = rs.getString("sido");
						String selected = p_sido.equals(sido) ? "selected" : "";
			%>
			<option value="<%=sido%>" <%=selected%>><%=sido%></option>
			<%
				}
			%>
		</select>
		<%
			String sql_gugun = "select distinct gugun from zipcode "
						+ " where sido=? order by gugun";
				//out.println(sql_gugun);
				//out.println(request.getParameter("sido"));
		%>
		<select name="gugun" id="gugun" onchange="form1.submit();">
			<option value="">==구군==</option>
			<%
				pstmt_gugun = conn.prepareStatement(sql_gugun);

					pstmt_gugun.setString(1, p_sido); //첫번째 물음표에 대입될 값
					rs_gugun = pstmt_gugun.executeQuery();
					while (rs_gugun.next()) {
						String gugun = rs_gugun.getString("gugun");
						String selected = p_gugun.equals(gugun) ? "selected" : "";
			%>
			<option value="<%=gugun%>" <%=selected%>><%=gugun%></option>
			<%
				}
			%>
		</select> <select name="dong" id="dong" onchange="form1.submit();">
			<option value="">==동면리==</option>
			<%
				String sql_dong = "select distinct dong from zipcode "
							+ " where sido=? and gugun=?  order by dong";
					pstmt_dong = conn.prepareStatement(sql_dong);
					pstmt_dong.setString(1, p_sido);
					pstmt_dong.setString(2, p_gugun);
					rs_dong = pstmt_dong.executeQuery();
					while (rs_dong.next()) {
						String dong = rs_dong.getString("dong");
						String selected = p_dong.equals(dong) ? "selected" : "";
			%>
			<option value="<%=dong%>" <%=selected%>><%=dong%></option>
			<%
				}
			%>
		</select> <br> <br>
		<table border="1" style="width: 650px">
			<tr style="text-align: center; background-color: aqua;">
				<td>우편번호</td>
				<td>시도</td>
				<td>구군</td>
				<td>동면리</td>
				<td>번지</td>
			</tr>
			<%
				String sql_list = "select * from zipcode "
							+ " where sido=? and gugun=?  and dong=? ";
					pstmt_list = conn.prepareStatement(sql_list);
					pstmt_list.setString(1, p_sido);
					pstmt_list.setString(2, p_gugun);
					pstmt_list.setString(3, p_dong);
					rs_list = pstmt_list.executeQuery();
					int count = 0;
					while (rs_list.next()) {
						count++;
						String zipcode = rs_list.getString("zipcode");
						String sido = rs_list.getString("sido");
						String gugun = rs_list.getString("gugun");
						String dong = rs_list.getString("dong");
						String bunji = rs_list.getString("bunji");
			%>
			<tr>
				<td><%=zipcode%></td>
				<td><%=sido%></td>
				<td><%=gugun%></td>
				<td><%=dong%></td>
				<td><%=bunji%>&nbsp;</td>
			</tr>
			<%
				}//while의 끝
					if (count == 0) {
			%>
			<tr align="center">
				<td colspan="5">검색된 내용이 없습니다.</td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (rs_gugun != null)
						rs_gugun.close();
					if (rs_dong != null)
						rs_dong.close();
					if (rs_list != null)
						rs_list.close();
					if (pstmt != null)
						pstmt.close();
					if (pstmt_gugun != null)
						pstmt_gugun.close();
					if (pstmt_dong != null)
						pstmt_dong.close();
					if (pstmt_list != null)
						pstmt_list.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		%>

	</form>
</body>
</html>












