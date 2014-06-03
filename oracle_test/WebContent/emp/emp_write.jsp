<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 클래스 import -->
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>사원등록</h2>
	<form action="emp_insert.jsp" method="post" name="form1">
		<table border="1">
			<tr>
				<td>사번</td>
				<!-- window.open('주소','윈도우 아이디','옵션') -->
				<td><input type="text" name="empno"> <input
					type="button" value="사번확인"
					onclick="window.open('empno_search.jsp','','width=300,height=300')">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<td>부서코드</td>
				<td>
					<!-- <option value="서버에 전달되는 코드값">화면텍스트</option>--> <select
					name="deptno">
						<option value="10">ACCOUNTING</option>
						<option value="20">RESEARCH</option>
						<option value="30">SALES</option>
						<option value="40">OPERATIONS</option>
						<%-- <%
while ( rs.next() ) {
%>
						<option value=""></option>
<%	
}
%> 		 --%>
				</select>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="확인"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>




