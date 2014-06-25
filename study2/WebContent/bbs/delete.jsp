<%@page import="com.bbs.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String cp=request.getContextPath();
	
	int num=Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");
	
	BoardDAO dao=new BoardDAO();
	dao.deleteBoard(num);
	
	response.sendRedirect(cp+
			"/bbs/list.jsp?pageNum="+pageNum);
%>