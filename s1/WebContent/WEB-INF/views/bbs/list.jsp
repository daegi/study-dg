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
<link rel="stylesheet" href="<%=cp%>/data/css/board/list.css" type="text/css"/>
<script type="text/javascript">

function searchList() {
	var f = document.searchForm;
	
	f.action = "<%=cp%>/bbs/list.do";
	f.submit();
}
</script>

</head>

<body>
<div class="layoutMain">
	<div class="layoutHeader">
		<jsp:include page="/layout/header.jsp"></jsp:include>
	</div>
	
	<div class="layoutBody">
		<div style="width:100%;	height: 40px;  line-height:40px;clear: both; border-top: 1px solid #DAD9FF;border-bottom: 1px solid #DAD9FF;">
		    <div style="width:690px; height:30px; line-height:30px; margin:5px auto;">
		        <img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />
		        <span style="font-weight: bold;font-size:13pt;font-family: 나눔고딕, 맑은 고딕, 굴림;">게시판</span>
		    </div>
		</div>
	
		<div id="bbsList">
			<div id="bbsList_header">
				<div id="leftHeader">
				  <form name="searchForm" method="post" action="">
					<select name="searchKey" class="selectField">
						<option value="subject">제목</option>
						<option value="name">작성자</option>
						<option value="content">내용</option>
						<option value="created">등록일</option>
					</select>
					<input type="text" name="searchValue" class="boxTF"/>
					<input type="button" value=" 검 색 " class="btn2" onclick="searList();"/>
				  </form>
				</div>
				<div id="rightHeader">
					<input type="image" src="<%=cp%>/data/images/btn_write.gif" onclick="javascript:location.href='<%=cp%>/bbs/created.do';"/>
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
				
				<c:forEach var="dto" items="${list}">
					<dl>
						<dd class="num">${dto.num}</dd>
						<dd class="subject"><a href="${articleUrl}&num=${dto.num}">${dto.subject}</a></dd>
						<dd class="name">${dto.name}</dd>
						<dd class="created">${dto.created}</dd>
						<dd class="hitCount">${dto.hitCount}</dd>
					</dl>
				</c:forEach>
				
				</div>
				<div id="pageIndexList">
					<p>
						<c:if test="${dataCount==0}">
							등록된 게시물이 없습니다.
						</c:if>
						<c:if test="${dataCount!=0}">
							${pager}
						</c:if>
					</p>
				</div>
			</div>
		</div>	   
	</div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>