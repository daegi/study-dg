<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="register.css">
<script type="text/javascript">
	function userid_check() {
		window.open("userid_check.jsp", "", "width=300, height=200");
	}

	function zipcode_search() {
		window.open("zipcode_search.jsp", "",
				"width=600, height=500, scrollbars=yes");
	}

	function setEmail(emailValue) {
		var emailTail = document.all("email2");

		if (emailValue == "")
			return;
		else if (emailValue == "etc") {
			emailTail.readOnly = false;
			emailTail.value = "";
			emailTail.focus();
		} else {
			emailTail.readOnly = true;
			emailTail.value = emailValue;
		}
	}

</script>

</head>
<body>
	<form name="form1" id="form1" method="post">
		<table align="center">
			<tr id="register_top1">
				<td colspan="2">회원가입</td>
			</tr>

			<tr>
				<td></td>
			</tr>

			<tr id="register_top2">
				<td id="c1">아이디</td>
				<td><input type="text" name="userid" id="userid"
					readonly="readonly" onclick="userid_check()"></td>
			</tr>

			<tr>
				<td id="c1">패스워드</td>
				<td><input type="password" name="userpwd1" id="userpwd1"></td>
			</tr>
			<tr>
				<td id="c1">패드워드 확인</td>
				<td><input type="password" name="userpwd2" id="userpwd2"></td>
			</tr>
			<tr>
				<td id="c1">이름</td>
				<td><input type="text" name="username" id="username">
			</tr>
			<tr>
				<td id="c1">생년월일</td>
				<td><input type="text" name="birth" id="birth"></td>
			</tr>
			<tr>
				<td id="c1">이메일</td>
				<td><input type="text" name="email1" id="email1">@<input
					type="text" name="email2" id="email2" readonly="readonly">
					<select name="email3" onchange="SetEmail(email3.options.value)">

						<option value="">선택</option>
						<option value="naver.com">네이버</option>
						<option value="nate.com">네이트</option>
						<option value="daum.net">다음</option>
						<option value="etc">직접입력</option>
				</select></td>
			</tr>
			<tr>
				<td id="c1">전화번호</td>
				<td><select name="tel1" id="tel1">
						<option value="">선택</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
				</select> <input type="text" name="tel2" id="tel2">- <input
					type="text" name="tel3" id="tel3"></td>
			</tr>
			<tr>
				<td id="c1">질문</td>
				<td><select name="question" id="question">
						<option value="">선택</option>
						<option value="q1">질문1</option>
						<option value="q2">질문2</option>
						<option value="q3">질문3</option>
				</select></td>
			</tr>
			<tr>
				<td id="c1">답변</td>
				<td><input type="text" name="answer" id="answer"></td>
			</tr>
			<tr>
				<td id="c1">직업</td>
				<td><input type="text" name="job" id="job"></td>
			</tr>
			<tr>
				<td id="c1">우편번호</td>
				<td><input type="text" name="zip1" id="zip1"
					readonly="readonly" onclick="zipcode_search()"> <input
					type="submit" name="zip2" id="zip2" onclick="zipcode_search();"
					value="우편번호 검색"></td>
			</tr>
			<tr id="register_bottom1">
				<td id="c1">주소</td>
				<td><input type="text" name="addr1" id="addr1"
					readonly="readonly" size="40"><br> <input type="text"
					name="addr2" id="addr2" size="40"></td>
			</tr>


		</table>

		<p align="center">
			<input type="button" value="회원가입" onclick="register_check()"><input
				type="reset" value="다시입력"><input type="button" value="가입취소"
				onclick="history.back()">
	</form>
</body>
</html>





