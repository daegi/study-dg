<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String cp=request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>study</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/member/member.css" type="text/css"/>

<script type="text/javascript" src="<%=cp%>/data/js/util.js"></script>
<script type="text/javascript">
    function memberOk() {
        f = document.memberForm;

    	str = f.userId.value;
    	str = str.trim();
        if(!str) {
            alert("\n아이디를 입력하세요. ");
            f.userId.focus();
            return;
        }
		if(!/^[a-z][a-z0-9_]{4,9}$/i.test(str)) { 
			alert("아이디는 5~10자이며 첫글자는 영문자이어야 합니다.");
			f.userId.focus();
			return;
		}

	/*
		if(!/^((\w|[\_\!\$\#])+)$/.test(str)) {
			alert("\n아이디는 영숫자와 _ ! $ # %만 가능합니다. ");
			f.userId.focus();
			return;
		}
	*/    
		f.userId.value = str;

		str = f.userPwd.value;
		str = str.trim();
		if(!str) {
			alert("\n패스워드를 입력하세요. ");
			f.userPwd.focus();
			return;
		}
		if(!/^(?=.*[a-z])(?=.*[!@#$%^*+=-]|.*[0-9]).{5,10}$/i.test(str)) { 
			alert("패스워드는 5~10자이며 하나 이상 영문자와 숫자나 특수문자가 포함되어야 합니다.");
			f.userPwd.focus();
			return;
		}
		f.userPwd.value = str;
		
	    str = f.userName.value;
    	str = str.trim();
        if(!str) {
            alert("\n이름을 입력하세요. ");
            f.userName.focus();
            return;
        }
	    f.userName.value = str;

	    str = f.birth.value;
    	str = str.trim();
        if(!str || !isValidDateFormat(str)) {
            alert("\n생년월일를 입력하세요[YYYY-MM-DD]. ");
            f.birth.focus();
            return;
        }
        
	    str = f.tel1.value;
    	str = str.trim();
        if(!str) {
            alert("\n전화번호를 입력하세요. ");
            f.tel1.focus();
            return;
        }

	    str = f.tel2.value;
    	str = str.trim();
        if(!str) {
            alert("\n전화번호를 입력하세요. ");
            f.tel2.focus();
            return;
        }

	    str = f.tel3.value;
    	str = str.trim();
        if(!str) {
            alert("\n전화번호를 입력하세요. ");
            f.tel3.focus();
            return;
        }
        
	    str = f.email1.value;
    	str = str.trim();
        if(!str) {
            alert("\n이메일을 입력하세요. ");
            f.email1.focus();
            return;
        }

	    str = f.email2.value;
    	str = str.trim();
        if(!str) {
            alert("\n이메일을 입력하세요. ");
            f.email2.focus();
            return;
        }

    	str = f.question.value;
        if(!str) {
           alert("\n질문을 선택 하세요 !!!");
           f.question.focus();
           return;
        }

    	str = f.answer.value;
    	str = str.trim();
        if(!str) {
           alert("\n질문에 대한 답변을 입력 하세요 !!!");
           f.answer.focus();
           return;
        }
     	f.answer.value = str;
        
     	var mode="${mode}";
     	
     	if(mode=="created")
     		f.action = "<%=cp%>/member/member_ok.do";
  		else if(mode=="update")
     		f.action = "<%=cp%>/member/update_ok.do";
       		
        f.submit();
    }

    function changeEmail() {
        var f = document.memberForm;
        
     	var str = f.selectMail.value;
        if(str!="direct") {
             f.email2.value=str; 
             f.email2.readOnly = true;
             f.email1.focus(); 
        }
        else {
            f.email2.value="";
            f.email2.readOnly = false;
            f.email1.focus();
        }
    }

    function changeQuestion() {
        var f = document.memberForm;
        
     	str = f.question.value;
        if(!str) {
          f.answer.readOnly = true;
        }
        else {
          f.answer.readOnly = false;
          f.answer.focus();
        }
    }

    if(window.attachEvent) { // IE
    	window.attachEvent("onload", function(){
    		var ob=document.getElementsByTagName("input");
    		for(var i=0; i<ob.length; i++) {
    			if(ob[i].getAttribute("type")=="text" || ob[i].getAttribute("type")=="password") {
    				ob[i].onkeydown=function() { // IE만 가능
    			        if(event.keyCode==13){
    			        	event.keyCode=9; 
    			        	return event.keyCode;
    			        }
    				};
    				ob[i].onfocus=function() {
    					if(! this.getAttribute("readonly"))
    					   this.style.border="1px solid red";
    				};
    				ob[i].onblur=function() {
    					if(! this.getAttribute("readonly"))
    					  this.style.border="1px solid #666666";
    				};
    			}
    		}
    	});
    } else if(window.addEventListener) {
    	window.addEventListener("load", function(){
    		var ob=document.getElementsByTagName("input");
    		for(var i=0; i<ob.length; i++) {
    			if(ob[i].getAttribute("type")=="text" || ob[i].getAttribute("type")=="password") {
    				ob[i].onfocus=function() {
    					if(! this.getAttribute("readonly"))
    					  this.style.border="1px solid red";
    				};
    				ob[i].onblur=function() {
    					if(! this.getAttribute("readonly"))
    					  this.style.border="1px solid #666666";
    				};
    			}
    		}
    	});
    }    
</script>

</head>

<body>
<div class="layoutMain">
	<div class="layoutHeader">
		<jsp:include page="/layout/header.jsp"></jsp:include>
	</div>
	
	<div class="layoutBody" >
		<div style="width:100%;	height: 40px;  line-height:40px;clear: both; border-top: 1px solid #DAD9FF;border-bottom: 1px solid #DAD9FF;">
		    <div style="width:600px; height:30px; line-height:30px; margin:5px auto;">
		        <img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />
		        <span style="font-weight: bold;font-size:13pt;font-family: 나눔고딕, 맑은 고딕, 굴림;">회원가입</span>
		    </div>
		</div>

			<div id="member">
				<form name="memberForm" method="post" action="">
				<div class="memberCreated_noLine" >
					<ul style="margin:0px; padding:0px; list-style-type: square; margin-left: 20px;">
							<li> 회원정보 입력 </li>
					</ul>
				</div>
				
				<div id="memberCreated">
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>아 이 디</dt>
							<dd>
								  <input type="text" name="userId" id="userId"  size="25" maxlength="10"  class="boxTF" 
											value="${dto.userId}" ${mode=="update" ? "readonly='readonly'":""}/>
								  <span id="userIdState" style='display:none;'></span>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>패스워드</dt>
							<dd>
								  <input type="password" name="userPwd" id="userPwd" size="25" maxlength="10"  class="boxTF" 
											value="${dto.userPwd}"/>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>패스워드 확인</dt>
							<dd>
								  <input type="password" name="userPwd1" id="userPwd1" size="25" maxlength="10"  class="boxTF" 
											value="${dto.userPwd}"/>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>이 름</dt>
							<dd>
								  <input type="text" name="userName" size="25" maxlength="20"  class="boxTF" 
											value="${dto.userName}" ${mode=="update" ? "readonly='readonly'":""}/>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>생년월일</dt>
							<dd>
								  <input type="text" name="birth" size="25" maxlength="20"  class="boxTF" 
											value="${dto.birth}" />
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>전화번호</dt>
							<dd>
								  <select name="tel1">
										<option value="">선 택</option>
										<option value="010" ${dto.tel1=="010" ? "selected='selected'" : ""}>010</option>
										<option value="011" ${dto.tel1=="011" ? "selected='selected'" : ""}>011</option>
										<option value="016" ${dto.tel1=="016" ? "selected='selected'" : ""}>016</option>
										<option value="017" ${dto.tel1=="017" ? "selected='selected'" : ""}>017</option>
										<option value="018" ${dto.tel1=="018" ? "selected='selected'" : ""}>018</option>
										<option value="019" ${dto.tel1=="019" ? "selected='selected'" : ""}>019</option>
								  </select>
								  <input type="text" name="tel2" size="5" maxlength="4"  class="boxTF" 
											value="${dto.tel2}" onkeypress="onlyNum();"/> -
								  <input type="text" name="tel3" size="5" maxlength="4"  class="boxTF" 
											value="${dto.tel3}" onkeypress="onlyNum();"/>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>E-Mail</dt>
							<dd>
								  <select name="selectMail" onchange="changeEmail()">
										<option value="">선 택</option>
										<option value="naver.com" ${dto.email2=="naver.com" ? "selected='selected'" : ""}>naver.com</option>
										<option value="hanmail.net" ${dto.email2=="hanmail.net" ? "selected='selected'" : ""}>hanmail.net</option>
										<option value="hotmail.com" ${dto.email2=="hotmail.com" ? "selected='selected'" : ""}>hotmail.com</option>
										<option value="gmail.com" ${dto.email2=="gmail.com" ? "selected='selected'" : ""}>gmail.com</option>
										<option value="direct">직접입력</option>
								  </select>
								  <input type="text" name="email1" size="13" maxlength="30"  class="boxTF" 
											value="${dto.email1}"/> @ 
								  <input type="text" name="email2" size="13" maxlength="30"  class="boxTF" 
											value="${dto.email2}" readonly="readonly"/>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>질 문</dt>
							<dd>
								  <select name="question" style="margin-top:7px;" onchange="changeQuestion()">
										<option value="">질문을 선택 하세요 ...</option>
										<option value="1" ${dto.question=="1" ? "selected='selected'" : ""}>초등학교는 ?</option>
										<option value="2" ${dto.question=="2" ? "selected='selected'" : ""}>좋아하는 색깔 ?</option>
										<option value="3" ${dto.question=="3" ? "selected='selected'" : ""}>인생 좌우명 ?</option>
										<option value="4" ${dto.question=="4" ? "selected='selected'" : ""}>보물1호 ?</option>
										<option value="5" ${dto.question=="5" ? "selected='selected'" : ""}>존경하는 사람 ?</option>
								  </select>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>답 변</dt>
							<dd>
								  <input type="text" name="answer" size="25" maxlength="20"  class="boxTF" 
											value="${dto.answer}" readonly="readonly"/>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine">
						<dl>
							<dt>우편번호</dt>
							<dd>
								  <input type="text" name="zip" size="15" maxlength="10"  class="boxTF" 
										readonly="readonly"	value="${dto.zip}"/>
								  <input type="button" value="우편번호 검색" class="btn" onclick=""/>
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_bottomLine" style="height: 60px;">
						<dl>
							<dt style="height: 60px;">주 소</dt>
							<dd>
								  <input type="text" name="addr1" size="48" maxlength="50"  class="boxTF" 
											readonly="readonly" value="${dto.addr1}" /><br/>  
								  <input type="text" name="addr2" size="48" maxlength="50"  class="boxTF" 
											value="${dto.addr2}" />  
							</dd>
						</dl>
					</div>
	
					<div class="memberCreated_noLine">
						<dl>
							<dt>직 업</dt>
							<dd>
								  <input type="text" name="job" size="25" maxlength="20"  class="boxTF" 
											value="${dto.job}" />
							</dd>
						</dl>
					</div>
				</div>
	
				<div id="memberCreated_footer">
						
					<input type="hidden" name="mode" value="${mode}"/>
					
					<input type="button" value=" 회원가입 " class="btn" onclick="memberOk();"/>
					<input type="reset" value=" 다시입력 " class="btn" onclick="document.memberForm.userId"/>
					<input type="button" value=" 가입취소 " class="btn" onclick="javascript:location.href='<%=cp%>';"/>
					
				</div>
				<div id="memberCreated_message">
				  <font color="blue">${message}</font>
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