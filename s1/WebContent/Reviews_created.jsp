<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reviews</title>

<link rel="stylesheet" href="<%=cp%>/css/reviews_created.css"
	type="text/css">

<style type="text/css">
</style>



</head>
<body>
	<!-- main -->
	<div class="layoutMain">


		<!-- header -->
		<div class="layoutHeader">
			<jsp:include page="/layout/header.jsp"></jsp:include>
		</div>


		<!-- body -->
		<div class="layoutBody">
			<form action="" method="post">
				<div id="reviews">
					<div class="created_Header">
						<h2>이용 후기</h2>
					</div>
					<div id="reviews_created">
						<div class="created_subject">
							<dl>
								<dt>제목</dt>
								<dd>
									<input type="text" name="subject" size="74" maxlength="100">
								</dd>
							</dl>
						</div>
						<div class="created_writer">
							<dl>
								<dt>작성자</dt>
								<dd>아몰라</dd>
							</dl>
						</div>
						<div class="created_content">
							<dl>
								<dt>내용</dt>
								<dd>
									<textarea rows="22" cols="72">냉무</textarea>
								</dd>
							</dl>
						</div>

						<div class="created_upload">
							<dl>
								<dt>이미지1</dt>
								<dd>
									<input type="file" name="upload">
								</dd>
							</dl>
						</div>

						<div class="created_footer">
							<input type="button" value="글올리기"> <input type="reset"
								value="다시쓰기"> <input type="button" value="취소">
						</div>
					</div>
				</div>
			</form>
		</div>

		<!-- footer -->
		<div class="layoutfooter">
			<jsp:include page="/layout/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>