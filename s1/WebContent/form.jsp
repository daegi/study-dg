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
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css" />

<style type="text/css">



</style>

<script type="text/javascript" src="<%=cp%>/data/js/util.js"></script>
<script type="text/javascript">
    function sendNotice() {
        var f = document.noticeForm;

    	var str = f.subject.value;
        if(!str) {
            alert("\n제목을 입력하세요. ");
            f.subject.focus();
            return false;
        }
    	f.subject.value = str;

    	str = f.content.value;
        if(!str) {
            alert("내용을 입력하세요. ");
            f.content.focus();
            return false;
        }
    	f.content.value = str;
    	
    	var mode="${mode}";
    	
    	if(mode=="created") {
    		
        	f.action = "<%=cp%>/board/created_ok.do";
    	}else if(mode=="update") {
    		
        	f.action = "<%=cp%>	/board/update_ok.do";
		}

		// image 버튼, submit은 submit() 메소드 호출하면 두번전송
		return true;
	}
</script>

</head>
<body>
	<div class="layoutMain">
		<div class="layoutHeader">
			<jsp:include page="/layout/header.jsp"></jsp:include>
		</div>

		<div class="layoutBody">
			<h2>공지사항</h2>
			<div id="notice">
				<form name="noticeForm" method="post" onsubmit="return sendNotice();">
					<div class="noticCreated_bottomLine">
						<dl>
							<dt>제목</dt>
							<dd>
								<input type="text" name="subject" size="74" maxlength="100" class="boxTF"	value="">
							</dd>
						</dl>
					</div>

					<div class="noticeCreated_bottomLine">
						<dl>
							<dt>작성자</dt>
							<dd></dd>
						</dl>
					</div>

					<div id="bbsCreated_content">
						<dl>
							<dt>내용</dt>
							<dd>
								<textarea rows="12" cols="72" name="content" class="boxTA"></textarea>
							</dd>
						</dl>
					</div>

					<div class="bbsCreated_noLine" style="height: 40px">
						<dl>
							<dd></dd>
						</dl>
					</div>
					<div id="noticeCreated_footer">
						<input type="image" src="<%=cp%>/data/images/btn_submit.gif">
						<a href="javascript:location.href='<%=cp%>/notice/list.do';">
							<img src="<%=cp%>/data/images/btn_cancel.gif" border="0">
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>
</body>
</html>