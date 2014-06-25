<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.bbs.BoardDAO" %>
<%
	request.setCharacterEncoding("utf-8");
 	// 클라이언트가 입력한 데이터를 dto에 저장
%>
<jsp:useBean id="dto" class="com.bbs.BoardDTO"/>
<jsp:setProperty property="*" name="dto"/>

<%
	// 데이터베이스에 저장하기
	BoardDAO dao=new BoardDAO();
	
	// 클라이언트아이피
	dto.setIpAddr(request.getRemoteAddr());
	
	dao.insertBoard(dto);

	// 글리스트로 리다이렉트
	String cp=request.getContextPath();
	response.sendRedirect(cp+"/bbs/list.jsp");
%>

