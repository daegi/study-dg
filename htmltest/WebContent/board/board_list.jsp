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
	<%
		//검색키, 검색어 설정
		String searchkey = "name";
		String search = "";
		if (request.getParameter("searchkey") != null) {
			searchkey = request.getParameter("searchkey");
		}
		if (request.getParameter("search") != null) {
			search = request.getParameter("search");
		}

		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pstmt = null, pstmt_count = null;
		ResultSet rs = null, rs_count = null;
		int count = 0;
		int cur_page = 1;
		int block_start = 0, block_end = 0;
		int cur_block = 0;
		int block_size = 5;
		int tot_page = 0;
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			//1.게시판의 레코드 갯수 계산
			String sql_count = "select count(*) from board where "
					+ searchkey + " like ? ";
			System.out.println(sql_count);
			pstmt_count = conn.prepareStatement(sql_count);
			pstmt_count.setString(1, "%" + search + "%");
			rs_count = pstmt_count.executeQuery();
			if (rs_count.next()) {
				count = rs_count.getInt(1);
			}
			System.out.println(count);
			//2. 전체 페이지 갯수 계산
			int page_size = 10; //페이지당 게시물수 10개
			tot_page = (int) Math.ceil(count * 1.0 / page_size);
			//out.println("전체 페이지 갯수:"+tot_page);
			//3. 현재 페이지 구하기
			if (request.getParameter("cur_page") != null) {
				cur_page = Integer.parseInt(request
						.getParameter("cur_page"));
			}
	%>
	<input type="button" value="글쓰기"
		onclick="javascript:location.href='board_write.jsp';" />
	<%
		//4. 현재 페이지의 시작번호, 끝번호 계산(between A and B)
			int start = (cur_page - 1) * page_size + 1;
			int end = (start + page_size) - 1;
			System.out.println(start + "," + end);
			//5. 전체 페이지 블록 갯수(한 페이지에 표시할 페이지의 갯수)

			//	int tot_block =	(tot_page % block_size == 0 ) ? 
			//			tot_page / block_size : tot_page/block_size+1;
			int tot_block = (int) Math.ceil(tot_page * 1.0 / block_size);
			//6. 현재 페이지가 몇번째 블록에 속하는지 계산
			cur_block = (int) Math.ceil((cur_page - 1) / block_size) + 1;
			//7. 현재 블록의 시작페이지번호와 끝페이지번호 계산
			block_start = (cur_block - 1) * block_size + 1;
			block_end = block_start + block_size - 1;
			if (block_end > tot_page)
				block_end = tot_page;

			//out.println("전체 블록:"+ tot_block);
			//out.println("현재 블록:"+ cur_block);
	%>
	등록된 게시물수 :
	<%=count%>개
	<table border="1" style="width: 700px">
		<tr style="text-align: center; background-color: yellow">
			<td>No</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회</td>
		</tr>
		<!-- 반복문 -->
		<%
			String sql = "select * from board_view where rn between ? and ? ";
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int idx = rs.getInt("idx");
					String name = rs.getString("name");
					String subject = rs.getString("subject");
					String post_date = rs.getString("post_date");
					int hit = rs.getInt("hit");
					// 태그 문자 변환
					name = name.replace("<", "&lt;");
					name = name.replace(">", "&gt;");
					subject = subject.replace("<", "&lt;");
					subject = subject.replace(">", "&gt;");
					// 공백 문자 처리( 스페이스한칸 ==> &nbsp; )
					name = name.replace(" ", "&nbsp;");
					subject = subject.replace(" ", "&nbsp;");

					int cnt = rs.getInt("cnt");
		%>
		<tr>
			<td><%=idx%></td>
			<td><%=name%></td>
			<td><a href="board_view.jsp?idx=<%=idx%>&cur_page=<%=cur_page%>">
					<%=subject%></a> <%
 	if (cnt > 0) {
 %> <font color="red">(<%=cnt%>)
			</font> <%
 	}
 %></td>
			<td><%=post_date%></td>
			<td><%=hit%></td>
		</tr>
		<%
			} //while의 끝
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
		%>
	</table>
	<!-- 페이지 네비게이션 출력 -->
	<div style="width: 700px; text-align: center;">
		<%
			if (cur_block > 1) { //첫번째 블록에서는 [이전] 링크가 없음.
				//블록 인덱스를 감소시킴, 블록의 시작페이지 번호를 현재 페이지로 설정
				int prev_block = cur_block - 1;
				int prev_page = (prev_block - 1) * block_size + 1;
		%>
		<!-- [이전] 블록 링크  -->
		<a href="board_list.jsp?cur_page=<%=prev_page%>">[이전]</a>
		<%
			}
			for (int i = block_start; i <= block_end; i++) {
				if (i == cur_page) { //현재 페이지이면
		%>
		<font color="red"><b><%=i%></b></font>&nbsp;
		<%
			} else { //현재 페이지가 아니면
		%>
		<a
			href="board.jsp?cur_page=<%=i%>&searchkey=<%=searchkey%>&search=<%=search%>"><%=i%></a>&nbsp;
		<%
			}
			}
			if (cur_page < tot_page) {
				//블록 인덱스를 증가시킴, 블록의 시작페이지 번호를 현재 페이지로 설정
				int next_block = cur_block + 1;
				int next_page = (next_block - 1) * block_size + 1;
		%>
		<!-- [다음] 블록 링크  -->
		<a href="board.jsp?cur_page=<%=next_page%>">[다음]</a>
		<%
			}
		%>
	</div>
</body>
</html>












