
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<%
String cur_page = "";
if( request.getParameter("cur_page") != null ){
	cur_page = request.getParameter("cur_page");
}
%>
<script type="text/javascript">
function check(){
	var form1 = document.getElementById("form1");
	form1.action = "board_edit.jsp";
	form1.submit();
}
//댓글 작성 페이지로 이동시키는 함수
function comment_write() {
	var form2 = document.getElementById("form2");
	var name = document.getElementById("name");
	var content = document.getElementById("content");
	if( name.value == "" ) {
		alert("이름을 입력하세요");
		name.focus();
		return;
	}
	if( content.value == "" ) {
		alert("내용을 입력하세요");
		content.focus();
		return;
	}	
	form2.action =	"board_comment_insert.jsp?idx="
			+<%=request.getParameter("idx")%>;
	form2.submit();
}
</script>
</head>
<body>
<h2>게시판</h2>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>   
<%
request.setCharacterEncoding("utf-8"); //한글 인코딩 방식 설정
DataSource ds=null;
Connection conn=null;
PreparedStatement pstmt = null, pstmt_view=null;
ResultSet rs = null;
//댓글 목록 출력을 위한 객체 선언
PreparedStatement pstmt_count=null, pstmt_list=null;
ResultSet rs_count=null, rs_list=null;

int hit = 0;
String name="", subject="", post_date="", content="";
try{
	Context context = new InitialContext();
	ds = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	//조회수 증가 쿼리 실행
	String sql = "update board set hit=hit+1 where idx=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, request.getParameter("idx"));
	pstmt.executeUpdate();
	// select query
	sql = "select * from board where idx=?";
	pstmt_view = conn.prepareStatement(sql);
	pstmt_view.setString(1, request.getParameter("idx"));
	rs = pstmt_view.executeQuery();
	if( rs.next() ) {
		name = rs.getString("name");
		subject = rs.getString("subject");
		hit = rs.getInt("hit");
		content = rs.getString("content");
		post_date = rs.getString("post_date");
		// 태그 문자 변환
		name = name.replace("<", "&lt;");
		name = name.replace(">", "&gt;");
		subject = subject.replace("<", "&lt;");
		subject = subject.replace(">", "&gt;");		
		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");	
		// 공백 문자 처리( 스페이스한칸 ==> &nbsp; )
		name = name.replace(" ", "&nbsp;");
		subject = subject.replace(" ", "&nbsp;");		
		content = content.replace(" ", "&nbsp;");
		// 줄바꿈 처리( \n ==> <br> )
		content = content.replace("\n", "<br>");
%>
<form name="form1" id="form1" action="board_edit.jsp" method="post">
<!-- 게시물 번호 -->
<input type="hidden" name="idx" id="idx" 
	value="<%=request.getParameter("idx")%>" />
<input type="hidden" name="cur_page" value="<%=cur_page%>" />
<table border="1" style="width:600px">
	<tr>
		<td style="text-align:center;" width="20%">No</td>
		<td width="10%"><%=request.getParameter("idx")%></td>
		<td style="text-align:center;" width="10%">날짜</td>
		<td width="30%"><%=post_date%></td>
		<td style="text-align:center;" width="15%">조회수</td>
		<td width="15%"><%=hit%></td>
	</tr>
	<tr>
		<td style="text-align:center;">이름</td>
		<td colspan="5"><%=name%></td>
	</tr>
	<tr>
		<td style="text-align:center;">제목</td>
		<td colspan="5"><%=subject%></td>
	</tr>
	<tr>
		<td style="text-align:center;">본문</td>
		<td colspan="5"><%=content%></td>
	</tr>
	<tr>
		<td colspan="6" style="text-align:center;">
			<input type="button" value="수정/삭제" onclick="javascript:check();" />
			<input type="button" value="목록" 
				onclick="javascript:location.href='board_list.jsp?cur_page=<%=cur_page%>';" />
		</td>
	</tr>
</table>
</form>
<%		
	}//if의 끝
%>
<!-- 댓글 입력폼 -->
<form name="form2" id="form2" method="post">
<input type="hidden" name="cur_page" value="<%=cur_page%>" />
<table border="1" style="width:600px">
	<tr>
		<td>이름</td>
		<td colspan="2"><input type="text" name="name" id="name" /></td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="content" id="content" rows="3" cols="55"></textarea>
		</td>
		<td><input type="button" value="확인"  
					onclick="javascript:comment_write();"/></td>
	</tr>	
</table>
</form>
<%
sql = "select count(*) from board_comment where board_idx=?";
pstmt_count = conn.prepareStatement(sql);
pstmt_count.setString(1, request.getParameter("idx"));
rs_count = pstmt_count.executeQuery();
int count=0;
if( rs_count.next() ) {
	count = rs_count.getInt(1);
}
if( count > 0 ){ //댓글 갯수가 0보다 크면 댓글 목록을 출력함
%>
<table border="1" style="width:600px">
	<tr>
		<td>이름</td>
		<td>내용</td>
		<td>날짜</td>
	</tr>
<%	
	//댓글 목록 출력
	sql = "select * from board_comment 	where board_idx=? "
			+" order by idx desc";
	pstmt_list = conn.prepareStatement(sql);
	pstmt_list.setString(1, request.getParameter("idx"));
	rs_list = pstmt_list.executeQuery(); 
	//댓글 목록
	while( rs_list.next() ) {
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
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if( rs != null ) rs.close();
		if( rs_count != null ) rs_count.close();
		if( rs_list != null ) rs_list.close();
		if( pstmt_count != null ) pstmt_count.close();
		if( pstmt_list != null ) pstmt_list.close();
		if( pstmt_view != null ) pstmt_view.close();
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>


</body>
</html>