<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- h1 ~ h6 ���� �±� -->
<h2>���� ����</h2>
<form action="gb_insert.jsp" method="post">
<table border="1">
	<tr>  <!-- Table Row , ���̺��� �� -->
		<td>�̸�</td>
		<td><input type="text" name="name"></td>
	</tr> <!-- Table Division ���̺��� �� -->
	<tr>
		<td>�̸���</td>
		<td><input type="text" name="email"></td>
	</tr> 
	<tr> <!-- colspan="���� ����" -->
		<td colspan="2">
			<textarea rows="5" cols="60" name="content"></textarea>
		</td>
	</tr>
	<tr align="center"> <!-- ������� -->
		<td colspan="2">
		<!-- �ڷ����۹�ư -->
			<input type="submit" value="Ȯ��">
		<!-- �Էµ� ������ ���� --> 
			<input type="reset" value="���"> 
		</td>
	</tr>
</table>
</form>
</body>
</html>




