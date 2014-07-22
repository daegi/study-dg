<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send() {

		var f = document.forms[0];

		f.submit();
	}
</script>

</head>
<body>

	<form action="<%=cp%>/demo1/cal.action" method="post">
		<input type="text" name="num1" value="${num1}"> 
		<select	name="oper">
			<option value="+" ${oper == "+"? "selected='selected'":"" }>더하기</option>
			<option value="-" ${oper == "-"? "selected='selected'":"" }>빼기</option>
			<option value="*" ${oper == "*"? "selected='selected'":"" }>곱하기</option>
			<option value="/" ${oper == "/"? "selected='selected'":"" }>나누기</option>
		</select> 
		<input type="text" name="num2" value="${num2}"> 
		<input type="button" value="=" onclick="send()">
	</form>

	${result}

</body>
</html>