<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ex01_background.jsp -->
<%@ page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Random rand = new Random(); // 랜덤 객체
		// 랜덤.nextInt(숫자)  0 ~ 숫자-1 사이의 난수 발생
		int n1 = rand.nextInt(300);
		int n2 = rand.nextInt(300);
		int n3 = rand.nextInt(300);
	%>
	<script type="text/javascript">
// top - 부모문서(iframe의 메인페이지)
top.document.getElementById("item1").style.width
	="<%=n1%>px";
top.document.getElementById("item2").style.width
	="<%=n2%>px";
top.document.getElementById("item3").style.width
	="<%=n3%>px";
	
	//타이머 설정, 1초에 한번씩 iframe을 새로고침
	//location.reload() 현재 페이지를 새로고침
	setTimeout("location.reload()", 1000);
	
	</script>
</body>
</html>









