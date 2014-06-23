<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="exam03_ok.jsp" method="post">
이름 : <input type="text" name="name"><br/>
소개 : <textarea name="memo" rows="3" cols="40"></textarea><br/>
취미 : 
<input type="checkbox" name="hobby" value="잠">잠자기<br/>
<input type="checkbox" name="hobby" value="영화">영화보기<br/>
<input type="checkbox" name="hobby" value="게임">게임하기<br/>
<input type="checkbox" name="hobby" value="운동">운동하기<br/>
<input type="submit" value="보내기">
</form>





</body>
</html>