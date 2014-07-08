<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css"
	type="text/css" />

<style type="text/css">

#noticeList {
	width:690px;
	margin:30px auto;
	text-align:left;
}

#noticeList_header #leftHeader{
	float:left;
	width:345px;
	text-align:left;
}
#noticeList_header #rightHeader{
	float:right;
	width:345px;
	text-align:right;
	margin-top: 8px;
}



</style>
</head>
<body>
	<div class="layoutMain">
		<div class="layoutHeader">
			<jsp:include page="/layout/header.jsp"></jsp:include>
		</div>


		<div class="layoutBody">
			<h2>공지사항</h2>
			<div id="noticList">
				<div id="notic_Hearder">
					<div id="leftHeader">검색</div>
					<div id="rightHeader">
						<input type="image" src="<%=cp%>/data/images/btn_write.gif"
							onclick="javascript:location.href='<%=cp%>/notice/created.do';" />
					</div>
					<div id="noticlist_list">
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
								<dd class="num"></dd>
								<dd class="subject"></dd>
								<dd class="name"></dd>
								<dd class="created"></dd>
								<dd class="hitCount"></dd>
							</dl>
						</div>
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