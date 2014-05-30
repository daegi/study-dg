<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- h1 ~ h6 제목 태그 -->
<h2>방명록 쓰기</h2>
<form action="gb_insert.jsp" method="post">
<table border="1">
	<tr>  <!-- Table Row , 테이블의 행 -->
		<td>이름</td>
		<td><input type="text" name="name"></td>
	</tr> <!-- Table Division 테이블의 셀 -->
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
	</tr> 
	<tr> <!-- colspan="셀의 갯수" -->
		<td colspan="2">
			<textarea rows="5" cols="60" name="content"></textarea>
		</td>
	</tr>
	<tr align="center"> <!-- 가운데정렬 -->
		<td colspan="2">
		<!-- 자료전송버튼 -->
			<input type="submit" value="확인">
		<!-- 입력된 내용을 지움 --> 
			<input type="reset" value="취소"> 
		</td>
	</tr>
</table>
</form>
</body>
</html>




