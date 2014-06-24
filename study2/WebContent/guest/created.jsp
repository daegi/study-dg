<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>study</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css"
	type="text/css" />
<link rel="stylesheet" href="<%=cp%>/data/css/board/created.css"
	type="text/css" />

<script type="text/javascript" src="<%=cp%>/data/js/util.js"></script>
<script type="text/javascript">
    function sendIt() {
        var f = document.myForm;

    	/* var str = f.subject.value;
    	str = str.trim();
        if(!str) {
            alert("\n제목을 입력하세요. ");
            f.subject.focus();
            return false;
        } */
    	f.subject.value = str;

	    str = f.name.value;
    	str = str.trim();
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

/*         if(f.email.value) {
	    	if(!isValidEmail(f.email.value)) {
                alert("\n정상적인 E-Mail을 입력하세요. ");
                f.email.focus();
                return false;
	    	}
        } */

    	str = f.content.value;
	    str = str.trim();
        if(!str) {
            alert("내용을 입력하세요. ");
            f.content.focus();
            return false;
        }
    	f.content.value = str;

    	str = f.pwd.value;
	    str = str.trim();
        if(!str) {
            alert("\n패스워드를 입력하세요. ");
            f.pwd.focus();
            return false;
        }
    	f.pwd.value = str;
    	
        f.action = "<%=cp%>/bbs/created_ok.jsp";
        f.submit();
    }
</script>

</head>

<body>
	<div class="layoutMain">
		<div class="layoutHeader">
			<jsp:include page="/layout/top.jsp"></jsp:include>
		</div>

		<div class="layoutBody">

			<div id="guest">
				<div id="guest_title">
					<img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />방명록
				</div>

				<form action="" method="post" name="myForm">
					<div id="guestCreated">


						<div class="guestCreated_bottomLine">
							<dl>
								<dt>작성자</dt>
								<dd>
									<input type="text" class="boxTF" maxlength="20" size="35"
										name="name">
								</dd>
							</dl>
						</div>

						<div id="guestCreated_content">
							<dl>
								<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
								<dd>
									<textarea class="boxTA" rows="12" cols="72" name="content"></textarea>
								</dd>
							</dl>
						</div>

						<div class="guestCreated_noLine">
							<dl>
								<dt>패스워드</dt>
								<dd>
									<input type="password" class="boxTF" maxlength="7" size="35"
										name="pwd">&nbsp;(게시물 수정 및 삭제시 필요 !!!)
								</dd>
							</dl>
						</div>
					</div>

					<div id="guestCreated_footer">
						<input type="button" value=" 등록하기 " class="btn2" onclick="sendIt();"/>
						<input type="reset" value=" 다시입력 " class="btn2" onclick=""/>
						<input type="button" value=" 작성취소 " class="btn2" onclick="javascript:location.href='<%=cp%>/bbs/list.jsp';"/>
					</div>

				</form>
			</div>












		</div>

		<div class="layoutFooter">
			<jsp:include page="/layout/bottom.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>