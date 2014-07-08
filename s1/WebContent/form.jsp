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

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css"/>

<style type="text/css">
body {
	border: #ff0000 dotted 1px;
}

#layoutBody {
	text-align: center;
}

</style>
</head>
<body>
	<div class="layoutMain">
		<div class="layoutHeader">
			<jsp:include page="/layout/header.jsp"></jsp:include>
		</div>
		<div class="layoutBody">
			<div id="noticeList">
				<div id="noticList_subject">
					<div>
						<div>
							<div>
								<div></div>
							</div>
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