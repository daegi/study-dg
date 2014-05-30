
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
function board_update(){
	var form1 = document.getElementById("form1");
	var name = document.getElementById("name");
	var subject = document.getElementById("subject");
	var content = document.getElementById("content");
	var passwd = document.getElementById("passwd");
	if( name.value == "" ) {
		alert("이름을 입력하세요");
		name.focus();
		return;
	}
	if( subject.value == "" ) {
		alert("제목을 입력하세요");
		subject.focus();
		return;
	}
	if( content.value == "" ) {
		alert("본문을 입력하세요");
		content.focus();
		return;
	}
	form1.action = "board_update.jsp";
	form1.submit();
}
function board_delete(){
	//사용자의 확인을 받고 board_delete.jsp로 submit
	var yn = confirm("삭제할까요?");
	if( yn ) {
		var form1 = document.getElementById("form1");
		form1.action = "board_delete.jsp";
		form1.submit();
	}
}
</script>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>   
<%
request.setCharacterEncoding("utf-8"); //한글 인코딩 방식 설정
DataSource ds=null;
Connection conn=null;
PreparedStatement pstmt_view=null;
ResultSet rs = null;
int hit = 0;
String name="", subject="", post_date="", content="", passwd="";
try{
	Context context = new InitialContext();
	ds = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	// select query
	String sql = "select * from board where idx=?";
	pstmt_view = conn.prepareStatement(sql);
	pstmt_view.setString(1, request.getParameter("idx"));
	rs = pstmt_view.executeQuery();
	if( rs.next() ) {
		name = rs.getString("name");
		subject = rs.getString("subject");
		hit = rs.getInt("hit");
		content = rs.getString("content");
		post_date = rs.getString("post_date");
		passwd = rs.getString("passwd");
	}
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if( rs != null ) rs.close();
		if( pstmt_view != null ) pstmt_view.close();
		if( conn != null ) conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
<h2>게시판 수정/삭제</h2>
<form name="form1" id="form1" method="post">
<input type="hidden" name="idx" id="idx" 
	value="<%=request.getParameter("idx") %>" />
<input type="hidden" name="cur_page" 
	value="<%=request.getParameter("cur_page")%>" />	
<table border="1" style="width:600px">
	<tr>
		<td style="text-align:center;">이름</td>
		<td><input type="text" name="name" id="name" 
			value="<%=name%>" /></td>
	</tr>
	<tr>
		<td style="text-align:center;">제목</td>
		<td><input type="text" name="subject" id="subject"  
			value="<%=subject%>"  size="60" /></td>
	</tr>
	<tr>
		<td style="text-align:center;">본문</td>
		<td><textarea name="content" id="content" 
				rows="5" cols="60" ><%=content%></textarea></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="button" value="수정" 
				onclick="javascript:board_update();" />
			<input type="button" value="삭제" 
				onclick="javascript:board_delete();" />
			<input type="button" value="목록" 
				onclick="javascript:location.href='board_list.jsp'; " />
		</td>
	</tr>
</table>
</form>
</body>
</html>


