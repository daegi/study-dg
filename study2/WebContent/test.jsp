<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function SetEmailTail(emailValue) {
	  var email = document.all("email1");    // 사용자 입력
	  var emailTail = document.all("email2"); // Select box
	  
	  if ( emailValue == "notSelected" )
	   return;
	  else if ( emailValue == "etc" ) {
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

	<input type="text" name="email1" value="" /> @
	<input type="text" name="email2" value="" ReadOnly="readonly" />
	<select name="emailCheck"
		onchange="SetEmailTail(emailCheck.options[this.selectedIndex].value)">
		<option value="notSelected">::선택하세요::</option>
		<option value="etc">직접입력</option>
		<option value="naver.com">naver.com</option>
		<option value="nate.com">nate.com</option>
		<option value="empal.com">empal.com</option>
		<option value="hotmail.com">hotmail.com</option>
		<option value="lycos.co.kr">lycos.co.kr</option>
		<option value="msn.com">msn.com</option>
		<option value="hanmail.net">hanmail.net</option>
		<option value="yahoo.com">yahoo.com</option>
		<option value="korea.com">korea.com</option>
		<option value="kornet.net">kornet.net</option>
		<option value="yahoo.co.kr">yahoo.co.kr</option>
		<option value="kebi.com">kebi.com</option>
		<option value="orgio.net">orgio.net</option>
		<option value="paran.com">paran.com</option>
		<option value="gmail.com">gmail.com</option>
	</select>

</body>
</html>