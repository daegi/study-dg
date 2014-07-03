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
		        <span style="font-weight: bold;font-size:13pt;font-family: 나눔고딕, 맑은 고딕, 굴림;">답변형 게시판</span>
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
					</select>
					<input type="text" name="searchValue" class="boxTF"/>
					<input type="button" value=" 검 색 " class="btn" onclick=""/>
				  </form>
				</div>
				<div id="rightHeader">
					<input type="image" src="<%=cp%>/data/images/btn_write.gif" onclick="javascript:location.href='<%=cp%>/board/created.do';"/>
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
					<dl>
						<dd class="num">1</dd>
						<dd class="subject">스타일 마추기 힘들다......</dd>
						<dd class="name">홍길동</dd>
						<dd class="created">2000-10-10</dd>
						<dd class="hitCount">10</dd>
					</dl>

				</div>
				<div id="pageIndexList">
					<p>
						<a href="#">1</a>
						<a href="#">2</a>
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