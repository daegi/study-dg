<%@page import="com.bbs.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String cp=request.getContextPath();
	
	BoardDAO dao=new BoardDAO();
%>
<jsp:useBean id="dto" class="com.bbs.BoardDTO"/>
<jsp:setProperty property="*" name="dto"/>

<%
	dao.updateBoard(dto);
	
	String pageNum=request.getParameter("pageNum");
	// response.sendRedirect(cp+	"/bbs/list.jsp?pageNum="+pageNum);
	response.sendRedirect(
			cp+	"/bbs/article.jsp?pageNum="+pageNum
			+"&num="+dto.getNum());
%>


