<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		var f = document.forms[0];

		if (!/^[0-9]+$/g.test(!f.num1.value)) {
			alert("숫자를 입력하세요!!");
			f.num1.focus();
			return false;
		}
		return true;
	}
</script>

</head>
<body>
	<form action="exam02_ok.jsp" method="post" onsubmit="return check();">
		<input type="text" name="num1"> <select name="oper">
			<option value="합">합구하기</option>
			<option value="차">차구하기</option>
			<option value="곱">곱구하기</option>
			<option value="몫">몫구하기</option>
		</select> <input type="text" name="num2"> <input type="submit"
			value="결과">
	</form>
</body>
</html>
