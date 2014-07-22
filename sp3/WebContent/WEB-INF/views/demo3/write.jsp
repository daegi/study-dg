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
</head>
<body>

	<form action="<%=cp%>/demo3/write.action" method="post">
		<table>

			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth"></td>
			</tr>
			
			<tr>
				<td>성별</td>
				<td>
				<input type="radio" name="gender" value="남자">남자
				<input type="radio" name="gender" value="여자">여자
				</td>
			</tr>
			
			<tr>
				<td>취미</td>
				<td>
				<input type="checkbox" name="hobby" value="게임">게임
				<input type="checkbox" name="hobby" value="독서">독서
				<input type="checkbox" name="hobby" value="영화감상">영화감상
				<input type="checkbox" name="hobby" value="음악감상">음악감상
				</td>
			</tr>
			
			<tr>
				<td>이상형</td>
				<td>
				<input type="checkbox" name="favor" value="수지">수지
				<input type="checkbox" name="favor" value="오나미">오나미
				<input type="checkbox" name="favor" value="헤미">혜미
				<input type="checkbox" name="favor" value="유진">유진
				</td>
			</tr>
			
			<tr>
			<td><input type="submit" value="보내기"></td>
			</tr>
			
		</table>

	</form>

</body>
</html>