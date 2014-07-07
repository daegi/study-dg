<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/member/login.css" type="text/css"/>

<script type="text/javascript">
	function loginOk() {
		f = document.loginForm;
		if(!f.userId.value) {
			f.userId.focus();
			return;
		}
		
		if(!f.userPwd.value) {
			f.userPwd.focus();
			return;
		}

		f.action="<%=cp%>/login/login_ok.do";
		f.submit();
	}
</script>

</head>
<body>

<div id="memberLogin">
	<div id="memberLogin_comp">
	   <p style="margin: 2px; font-size: 14px;">
        <a href="<%=cp%>" style="text-decoration: none;">
             <span 
                 style="width: 200px; height: 70; position: relative; left: 0; top:5px; color: #2984ff; filter: mask(color=red) shadow(direction=135) chroma(color=red);font-style: italic; font-family: arial black; font-size: 40px; font-weight: bold;">ABLE</span>
        </a>
        </p>
	</div>
	
	<div id="memberLoginLayout">
		<div id="memberLogin_title">
		ABLE 회원 로그인
		</div>

		<div id="memberLoginBox">
			<div id="leftLoginBox">
				<form name="loginForm" action="" method="post" >
				<div id="memberLoginForm">
				  <dl>
					<dt>아 이 디</dt>
					<dd>
					      <input type="text" name="userId" size="15" maxlength="10"  class="boxTF"	/>
					      <input type="checkbox" name="saveUserId" value="y" class="boxCH" onclick=""/>아이디 저장
					</dd>
				  </dl>
		          
				  <dl>
					<dt>패스워드</dt>
					<dd>
					      <input type="hidden" name="mode" value="login"/>
					      <input type="password" name="userPwd" size="15" maxlength="10"  class="boxTF"	/>
					      <input type="button" value="로그인" class="btn" onclick="loginOk();"/>
					</dd>
				  </dl>
			  </div>
	          </form>
	          <br/>&nbsp;<br/>
	          <div id="memberLoginSearch">
	          		<a href="">아이디 찾기</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="">비밀번호 찾기</a>
	          </div>

	          <div id="memberLoginMessage">
	          		<font color="blue">${message}</font>
	          </div>

	          <div id="memberLoginRegister">
	          	   <dl>
	          		<dt>아이디가 없으면 지금 가입 하십시오</dt>
	          		<dt><a href="<%=cp%>/member/member.do">ABLE 회원가입</a></dt>
	          	   </dl>
	          </div>
	          
			</div>
			
			<div id="rightLoginBox">
				<div id="rightLoginBoby">
					<img src="<%=cp%>/data/images/gg.jpg" border="0" align="bottom" vspace="100" height="250" width="250"/>
				</div>
			</div>
		</div>
		
		<div id="memberLoginBody">
			<div id="memberLoginBody_msg">
			  <p>ABLE 회원의 특별한 서비스</p><br/>
	          <p>ABLE에는 최고의 서비스들이 있습니다. 다양하고 멋진 서비스로, ABLE 회원만의 특권을 누려보세요!!</p><br/>
	          <p>카페, 메일, 블로그, 검색, 유익한 정보등 멋진 서비스가 가득합니다.</p>
	          
			</div>
		</div>
		
	</div>
</div>

</body>
</html>