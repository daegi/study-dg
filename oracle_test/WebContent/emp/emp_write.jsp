<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Ŭ���� import -->
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>������</h2>
	<form action="emp_insert.jsp" method="post" name="form1">
		<table border="1">
			<tr>
				<td>���</td>
				<!-- window.open('�ּ�','������ ���̵�','�ɼ�') -->
				<td><input type="text" name="empno"> <input
					type="button" value="���Ȯ��"
					onclick="window.open('empno_search.jsp','','width=300,height=300')">
				</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<td>�μ��ڵ�</td>
				<td>
					<!-- <option value="������ ���޵Ǵ� �ڵ尪">ȭ���ؽ�Ʈ</option>--> <select
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
				<td colspan="2"><input type="submit" value="Ȯ��"> <input
					type="reset" value="���"></td>
			</tr>
		</table>
	</form>
</body>
</html>




