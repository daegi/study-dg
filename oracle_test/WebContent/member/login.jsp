<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- login.jsp -->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	var userid = document.getElementById("userid");
	if( userid.value == "" ) {  //빈값이면
		alert("아이디를 입력하세요");
		userid.focus(); //태그.focus() 태그에 입력포커스 설정
		return;  //함수를 종료시킴
	}
	//정규표현식(regular expression)
	
	var exp1 = /^[A-Za-z0-9]{4,10}$/;
	if( !exp1.test(userid.value) ) {
		alert("아이디는 영숫자 4~10자리만 입력가능합니다.");
		userid.focus();
		return;
	}
	
	document.getElementById("form1").submit();
}
</script>
</head>
<body>
<!-- 폼 : 서버에 자료를 전달하기 위한 입력양식 -->
<form method="get" action="login_check2.jsp" id="form1"> <!-- 자료를 받을 주소 -->
	아이디 <input type="text" name="userid" id="userid"><br>
	비번 <input type="password" name="passwd"><br>
	<input type="button" value="로그인" onclick="check()"> <!-- 전송버튼 -->
</form>

</body>
</html>






