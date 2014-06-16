<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- login.jsp -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="../include/jquery-2.1.1.js"></script>
<script type="text/javascript">
	//페이지 로딩이 완료되면 자동으로 실행할 명령들
	$(docment).read(function() {
		//클릭 이벤트 등록
		$("#btnLogin").click(function() {
			check();
		});
	});

	function check() {
		//var userid = document.getElementById("userid");

		var userid = $("#userid");

		//if (userid.value == "") { //빈값이면
		if (userid.val() == "") { //태그.val() 태그에 입력된 값
			alert("아이디를 입력하세요");
			userid.focus(); //태그.focus() 태그에 입력포커스 설정
			return; //함수를 종료시킴
		}
		var exp1 = /^[A-Za-z0-9]{3,10}$/;
		//if (!exp1.test(userid.value)) {
		if (!exp1.test(userid.val())) {
			alert("아이디는 영숫자 4~10자리만 입력가능합니다.");
			userid.focus();
			return;
		}
		//document.getElementById("form1").submit();
		$("#form1").submit();
	}
</script>
</head>
<body>
	<!-- 폼 : 서버에 자료를 전달하기 위한 입력양식 -->
	<form method="post" action="login_check.jsp" id="form1">
		<!-- 자료를 받을 주소 -->
		아이디 <input type="text" name="userid" id="userid"><br> 비번
		<input type="password" name="passwd"><br> <input
			type="button" value="로그인" id="btnLogin">
		<!-- 전송버튼 -->
		<input type="button" value="회원가입" onclick="location.href='join.jsp';">
	</form>

</body>
</html>






