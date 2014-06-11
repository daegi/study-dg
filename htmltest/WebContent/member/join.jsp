
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
function zipcode_search(){
	// 우편번호 조회 페이지를 팝업창으로 오픈
// window.open( "url", "팝업창의 id", "옵션" )	
	window.open("../zipcode/zipcode_search.jsp", "", "width=600, height=500, scrollbars=yes");
}
function member_join(){
	var form1 = document.getElementById("form1");
	var name = document.getElementById("name");
	var userid = document.getElementById("userid");
	var passwd = document.getElementById("passwd");
	var passwd2 = document.getElementById("passwd2");
	var email = document.getElementById("email");
	var hp = document.getElementById("hp");
	var zipcode = document.getElementById("zipcode");
	var address1 = document.getElementById("address1");
	var address2 = document.getElementById("address2");
	var idcheck = document.getElementById("idcheck");
	//빈값 체크
	if( name.value == "" ){
		alert("이름을 입력하세요.");
		name.focus();
		return;
	}
	if( userid.value == "" ){
		alert("아이디를 입력하세요.");
		userid.focus();
		return;
	}
	if( passwd.value == "" ){
		alert("비밀번호를 입력하세요.");
		passwd.focus();
		return;
	}
	if( passwd2.value == "" ){
		alert("비밀번호를 다시 한번 입력하세요.");
		passwd2.focus();
		return;
	}	
	if( passwd.value != passwd2.value ) {
		alert("비밀번호가 일치하지 않습니다.");
		passwd2.focus();
		return;
	}
	if( email.value == "" ){
		alert("이메일주소를 입력하세요.");
		email.focus();
		return;
	}	
	if( hp.value == "" ){
		alert("핸드폰 번호를 입력하세요.");
		hp.focus();
		return;
	}	
	
	if( zipcode.value == "" ){
		alert("우편번호를 입력하세요.");
		zipcode.focus();
		return;
	}
	if( address1.value == "" ){
		alert("주소를 입력하세요.");
		address1.focus();
		return;
	}
	if( address2.value == "" ){
		alert("주소를 입력하세요.");
		address2.focus();
		return;
	}		
	//아이디 중복 확인 
	if( idcheck.value != "Y" ) {
		alert("아이디 중복 확인을 해주세요.");
		return;
	}
	form1.action = "member_insert.jsp";
	form1.submit();
}
function userid_check(){
	window.open( 
			"userid_check.jsp", "", "width=300, height=200");
}
</script>
</head>
<body>
<h2>회원가입</h2>
<form name="form1" id="form1" method="post">
<table border="1" style="width:500px">
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" id="name" /></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="userid" id="userid"  
				onclick="javascript:userid_check();"  readonly="readonly" />
			<input type="button" value="아이디 중복 확인" 
				onclick="javascript:userid_check();" />
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd" id="passwd" /></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td><input type="password" name="passwd2"  id="passwd2" /></td>
	</tr>	
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email"  id="email" /></td>
	</tr>	
	<tr>
		<td>핸드폰</td>
		<td><input type="text" name="hp"  id="hp" /></td>
	</tr>		
	<tr>
		<td>우편번호</td>
		<td>
			<input type="text" name="zipcode"  id="zipcode"  
				readonly="readonly"   onclick="javascript:zipcode_search();"    />
		</td>
	</tr>		
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="address1"  id="address1" size="40"  
			readonly="readonly"   onclick="javascript:zipcode_search();" 	/><br>
			<input type="text" name="address2"  id="address2"  size="40" />
		</td>
	</tr>		
	<tr align="center">
		<td colspan="2">
<!-- 화면에 표시하지 않지만 중요한 정보를 담고 있는 태그 -->		
			<input type="hidden" name="idcheck" id="idcheck" />
			<input type="button" value="회원 가입" 
				onclick="javascript:member_join();" /></td>
	</tr>
</table>
</form>
</body>
</html>












