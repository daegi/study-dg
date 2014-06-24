<%@page import="com.bbs.BoardDTO"%>
<%@page import="com.bbs.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String cp=request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	int num = Integer.parseInt(request.getParameter("num"));
	
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.readBoard(num);
	
	
	//다른 사람에 의해 삭제된 경우	
	if(dto == null){
		response.sendRedirect(cp+"/bbs/list.jsp");
		return;
	}
	
	//디자인 마추기 위해 줄수 구해서 찍음
	int linesu = dto.getContent().split("\n").length;
	//엔터를<br>로 바꾸어야 라인 넘어감
	
	dto.setContent(dto.getContent().replaceAll("\n", "<br>"));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>study</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/board/article.css" type="text/css"/>
</head>

<body>
<div class="layoutMain">
	<div class="layoutHeader">
		<jsp:include page="/layout/top.jsp"></jsp:include>
	</div>
	
	<div class="layoutBody">
		<div id="bbs">
			<div id="bbs_title">
			  <img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />게시판
			</div>
			<div id="bbsArticle">
				<div id="bbsArticle_header">
					<%=dto.getSubject() %>
				</div>
				<div class="bbsArticle_bottomLine">
					<dl>
						<dt>작성자</dt>
						<dd><%=dto.getName() %></dd>
						<dt><%=linesu %></dt>
						<dd>10</dd>
					</dl>
				</div>
				<div class="bbsArticle_bottomLine">
					<dl>
						<dt>등록일</dt>
						<dd><%=dto.getCreated() %></dd>
						<dt><%=dto.getHitCount() %></dt>
						<dd>10</dd>
					</dl>
				</div>
				<div id="bbsArticle_content"><%=dto.getContent() %></div>
				<div class="bbsArticle_bottomLine">
					이전글 : 작업중
				</div>
				<div class="bbsArticle_noLine">
					다음글 : 작업중
				</div>
			</div>
			<div class="bbsArticle_noLine" style="text-align:right">
					from : <%=dto.getIpAddr() %>
			</div>
			<div id="bbsArticle_footer">
				<div id="leftFooter">
					   <input type="button" value=" 수정 " class="btn2" onclick=""/>
					   <input type="button" value=" 삭제 " class="btn2" onclick=""/>
				</div>
				<div id="rightFooter">
					   <input type="button" value=" 리스트 " class="btn2" onclick="javascript:location.href='<%=cp%>';"/>
				</div>
			</div>

		</div>

		<br/>&nbsp;<br/>
    </div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/bottom.jsp"></jsp:include>
	</div>
</div>
</body>
</html>