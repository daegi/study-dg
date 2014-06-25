<%@page import="com.util.MyUtil"%>
<%@page import="com.bbs.BoardDAO"%>
<%@page import="com.bbs.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String cp=request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	// 넘어온 페이지 번호 받기
	int current_page=1;
	String pageNum=request.getParameter("pageNum");
	if(pageNum!=null)
		current_page=Integer.parseInt(pageNum);
	
	BoardDAO dao=new BoardDAO();
	MyUtil util=new MyUtil();
	
	// 전체데이터 개수 구하기
	int dataCount=dao.dataCount();
	
	// 전체페이지수 구하기
	int numPerPage=2;
	int total_page=util.getPageCount(numPerPage, dataCount);
	
	// 전체페이지보다 현재 페이지가 큰경우
	if(current_page>total_page)
		current_page=total_page;
	
	// 게시물을 가져올 시작과 끝위치
	int start=(current_page-1)*numPerPage+1;
	int end=current_page*numPerPage;
	
	// 게시물 가져오기
	List<BoardDTO>  list=dao.listBoard(start, end);
	
	// 페이징처리
	String listUrl=cp+"/bbs/list.jsp";
	String pageIndexList=util.pageIndexList(
			current_page, total_page, listUrl);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>study</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/board/list.css" type="text/css"/>
</head>

<body>
<div class="layoutMain">
	<div class="layoutHeader">
		<jsp:include page="/layout/top.jsp"></jsp:include>
	</div>
	
	<div class="layoutBody">
		<div id="bbsList">
			<div id="bbsList_title">
			  <img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />게시판
			</div>

			<div id="bbsList_header">
				<div id="leftHeader">
				  <form name="searchForm" method="post" action="">
					<select name="searchKey" class="selectField">
						<option value="subject">제목</option>
						<option value="name">작성자</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchValue" class="boxTF"/>
					<input type="button" value=" 검 색 " class="btn2" onclick=""/>
				  </form>
				</div>
				<div id="rightHeader">
					<input type="button" value=" 글올리기 " class="btn2" onclick="javascript:location.href='<%=cp%>/bbs/created.jsp';"/>
				</div>
			</div>
			<div id="bbsList_list">
				<div id="title">
					<dl>
						<dt class="num">번호</dt>
						<dt class="subject">제목</dt>
						<dt class="name">작성자</dt>
						<dt class="created">작성일</dt>
						<dt class="hitCount">조회수</dt>
					</dl>
				</div>
				<div id="lists">
				  <% for(BoardDTO dto:list) { %>
					<dl>
						<dd class="num"><%=dto.getNum()%></dd>
						<dd class="subject"><a href="<%=cp%>/bbs/article.jsp?num=<%=dto.getNum()%>&pageNum=<%=current_page%>"><%=dto.getSubject() %></a></dd>
						<dd class="name"><%=dto.getName()%></dd>
						<dd class="created"><%=dto.getCreated()%></dd>
						<dd class="hitCount"><%=dto.getHitCount()%></dd>
					</dl>
					<%} %>

				</div>
				<div id="pageIndexList">
					<p>
						<%if(dataCount==0) {%>
						     등록된 게시물이 없습니다.
						 <%} else { %>
						     <%=pageIndexList%>
						 <%} %>
					</p>
				</div>
			</div>
		</div>	   
	</div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/bottom.jsp"></jsp:include>
	</div>
</div>
</body>
</html>