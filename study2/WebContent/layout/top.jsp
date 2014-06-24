<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String cp=request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
	<div id="menu_header">
		<div id="menu_headerLeft" style="color: #ffffff;">
		&nbsp;|&nbsp;
		<a href="<%=cp%>" >메인</a>
		&nbsp;|&nbsp;
		<a href="<%=cp%>">방명록</a>
		&nbsp;|&nbsp;
		<a href="<%=cp%>">공지사항</a>
		&nbsp;|&nbsp;
		<a href="<%=cp%>/bbs/list.jsp">게시판</a>
		&nbsp;|&nbsp;
		<a href="<%=cp%>">QnA</a>
		&nbsp;|&nbsp;
		<a href="<%=cp%>">사진첩</a>
		&nbsp;|&nbsp;
		</div>

		<div id="menu_headerRight" style="color: #ffffff;">
			  <p style="380" align="right">
				&nbsp;
				<a href="<%=cp%>">로그인</a>
				&nbsp;|&nbsp;
				<a href="<%=cp%>">회원가입</a>
				&nbsp;|&nbsp;
				<a href="<%=cp%>">일정관리</a>
            </p>
		</div>
	</div>