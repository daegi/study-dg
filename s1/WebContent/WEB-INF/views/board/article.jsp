<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
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
		<jsp:include page="/layout/header.jsp"></jsp:include>
	</div>
	
	<div class="layoutBody">
		<div style="width:100%;	height: 40px;  line-height:40px;clear: both; border-top: 1px solid #DAD9FF;border-bottom: 1px solid #DAD9FF;">
		    <div style="width:600px; height:30px; line-height:30px; margin:5px auto;">
		        <img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />
		        <span style="font-weight: bold;font-size:13pt;font-family: 나눔고딕, 맑은 고딕, 굴림;">답변형 게시판</span>
		    </div>
		</div>

		<div id="bbs">
			<div id="bbsArticle">
				<div id="bbsArticle_header">
					   <c:if test="${dto.depth != 0}">
				           [Re]
				       </c:if>
						${dto.subject}
				</div>
				<div class="bbsArticle_bottomLine">
					<dl>
						<dt>작성자</dt>
						<dd>${dto.userName}</dd>
						<dt>줄수</dt>
						<dd>${linesu}</dd>
					</dl>
				</div>
				<div class="bbsArticle_bottomLine" style="border-bottom-color: #507CD1;">
					<dl>
						<dt>등록일</dt>
						<dd>${dto.created}</dd>
						<dt>조회수</dt>
						<dd>${dto.hitCount}</dd>
					</dl>
				</div>
				<div id="bbsArticle_content">${dto.content}</div>
				<div class="bbsArticle_bottomLine">
					첨부 : 
					<c:if test="${not empty dto.saveFileName}">
					  <a href="<%=cp%>/board/download.do?num=${dto.num}">${dto.originalFileName}</a>
					</c:if>
				</div>
				<div class="bbsArticle_bottomLine">
					이전글 : 작업중
				</div>
				<div class="bbsArticle_noLine">
					다음글 : 작업중
				</div>
			</div>
			
			<div id="bbsArticle_footer" style="margin-top: 8px;">
				<div id="leftFooter">
					   <input type="image" src="<%=cp%>/data/images/btn_reply.gif" onclick="javascript:location.href='<%=cp%>/board/reply.do?num=${dto.num}&pageNum=${pageNum}';"/>
					   <input type="image" src="<%=cp%>/data/images/btn_modify.gif" onclick="javascript:location.href='<%=cp%>/board/modify.do?"/>
					   <input type="image" src="<%=cp%>/data/images/btn_delete.gif" onclick="javascript:location.href='<%=cp%>/board/delete.do?"/>
				</div>
				<div id="rightFooter">
					   <input type="image" src="<%=cp%>/data/images/btn_list.gif" onclick="javascript:location.href='<%=cp%>/board/list.do?${params}';"/>
				</div>
			</div>

		</div>

		<br/>&nbsp;<br/>
    </div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>