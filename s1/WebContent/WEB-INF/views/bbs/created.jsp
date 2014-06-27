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

	    str = f.name.value;
        if(!str) {
            alert("\n이름을 입력하세요. ");
            f.name.focus();
            return false;
        }
		/*
        if(!isValidKorean(str))  {
            alert("\n이름을 정확히 입력하세요");
            f.name.focus();
            return false;
        }
		*/
	    f.name.value = str;

        /* if(f.email.value) {
	    	if(!isValidEmail(f.email.value)) {
                alert("\n정상적인 E-Mail을 입력하세요. ");
                f.email.focus();
                return false;
	    	}
        } */

    	str = f.content.value;
        if(!str) {
            alert("내용을 입력하세요. ");
            f.content.focus();
            return false;
        }
    	f.content.value = str;

    	str = f.pwd.value;
        if(!str) {
            alert("\n패스워드를 입력하세요. ");
            f.pwd.focus();
            return false;
        }
    	f.pwd.value = str;
    	
        f.action = "<%=cp%>/bbs/created_ok.do";
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
		        <span style="font-weight: bold;font-size:13pt;font-family: 나눔고딕, 맑은 고딕, 굴림;">게시판</span>
		    </div>
		</div>
	
		<div id="bbs">
			<form name="boardForm" method="post" action="" onsubmit="return sendBoard();">
			<div id="bbsCreated">
				<div class="bbsCreated_bottomLine">
					<dl>
						<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
						<dd>
							  <input type="text" name="subject" size="74" maxlength="100"  class="boxTF" />
						</dd>
					</dl>
				</div>

				<div class="bbsCreated_bottomLine">
					<dl>
						<dt>작성자</dt>
						<dd>
							  <input type="text" name="name" size="35" maxlength="20" class="boxTF" />
						</dd>
					</dl>
				</div>

				<!-- <div class="bbsCreated_bottomLine">
					<dl>
						<dt>E-Mail</dt>
						<dd>
							  <input type="text" name="email" size="35" maxlength="50" class="boxTF" />
						</dd>
					</dl>
				</div> -->

				<div id="bbsCreated_content">
					<dl>
						<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
						<dd>
							  <textarea name="content" cols="72" rows="12" class="boxTA"></textarea>
						</dd>
					</dl>
				</div>

				<div class="bbsCreated_noLine">
					<dl>
						<dt>패스워드</dt>
						<dd>
							  <input type="password" name="pwd" size="35" maxlength="7" class="boxTF" />&nbsp;(게시물 수정 및 삭제시 필요 !!!)
						</dd>
					</dl>
				</div>
			</div>

			<div id="bbsCreated_footer">
				<input type="image" src="<%=cp%>/data/images/btn_submit.gif" />
        		<a href="javascript:location.href='<%=cp%>/bbs/list.do';"><img src="<%=cp%>/data/images/btn_cancel.gif" border="0"></a>
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