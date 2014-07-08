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
<link rel="stylesheet" href="<%=cp%>/data/css/board/created.css" type="text/css"/>

<script type="text/javascript" src="<%=cp%>/data/js/util.js"></script>
<script type="text/javascript">
    function sendBoard() {
        var f = document.boardForm;

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
    	}else if(mode=="reply") {
           	f.action = "<%=cp%>/board/reply_ok.do";
    	}if(mode=="update") {
        	f.action = "<%=cp%>/board/update_ok.do";
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
		<div style="width:100%;	height: 40px;  line-height:40px;clear: both; border-top: 1px solid #DAD9FF;border-bottom: 1px solid #DAD9FF;">
		    <div style="width:600px; height:30px; line-height:30px; margin:5px auto;">
		        <img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />
		        <span style="font-weight: bold;font-size:13pt;font-family: 나눔고딕, 맑은 고딕, 굴림;">답변형 게시판</span>
		    </div>
		</div>
	
		<div id="bbs">
			<form name="boardForm" method="post" action="" onsubmit="return sendBoard();" enctype="multipart/form-data">
			<div id="bbsCreated">
				<div class="bbsCreated_bottomLine">
					<dl>
						<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
						<dd>
							  <input type="text" name="subject" size="74" maxlength="100"  class="boxTF" value="${dto.subject}"/>
						</dd>
					</dl>
				</div>

				<div class="bbsCreated_bottomLine">
					<dl>
						<dt>작성자</dt>
						<dd>
							  <c:if test="${mode=='created' || mode=='reply' }">
							        ${sessionScope.session.userName}
							  </c:if>
							  <c:if test="${mode=='update'}">
							        ${dto.userName}
							  </c:if>
						</dd>
					</dl>
				</div>

				<div id="bbsCreated_content">
					<dl>
						<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
						<dd>
							  <textarea name="content" cols="72" rows="12" class="boxTA">${dto.content}</textarea>
						</dd>
					</dl>
				</div>

				<div class="bbsCreated_noLine" style="height: 40px;">
					<dl>
						<dt style="height: 40px;">첨부파일</dt>
						<dd>
							  <input type="file" name="upload" size="58" style="height: 20px" class="boxTF" />
						</dd>
					</dl>
				</div>
			</div>

			<div id="bbsCreated_footer">
			    <c:if test="${mode=='reply'}">
			    	<input type="hidden" name="groupNum"
			    	           value="${dto.groupNum}"> 
			    	<input type="hidden" name="depth"
			    	           value="${dto.depth}"> 
			    	<input type="hidden" name="orderNo"
			    	           value="${dto.orderNo}"> 
			    	<input type="hidden" name="parent"
			    	           value="${dto.num}"> 
			    	<input type="hidden" name="pageNum"
			    	           value="${pageNum}"> 
			    </c:if>
			
				<input type="image" src="<%=cp%>/data/images/btn_submit.gif" />
        		<a href="javascript:location.href='<%=cp%>/board/list.do';"><img src="<%=cp%>/data/images/btn_cancel.gif" border="0"></a>
			</div>

			</form>
		</div>
    </div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>