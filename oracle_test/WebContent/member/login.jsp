<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- login.jsp -->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	var userid = document.getElementById("userid");
	if( userid.value == "" ) {  //���̸�
		alert("���̵� �Է��ϼ���");
		userid.focus(); //�±�.focus() �±׿� �Է���Ŀ�� ����
		return;  //�Լ��� �����Ŵ
	}
	//����ǥ����(regular expression)
	
	var exp1 = /^[A-Za-z0-9]{4,10}$/;
	if( !exp1.test(userid.value) ) {
		alert("���̵�� ������ 4~10�ڸ��� �Է°����մϴ�.");
		userid.focus();
		return;
	}
	
	document.getElementById("form1").submit();
}
</script>
</head>
<body>
<!-- �� : ������ �ڷḦ �����ϱ� ���� �Է¾�� -->
<form method="get" action="login_check2.jsp" id="form1"> <!-- �ڷḦ ���� �ּ� -->
	���̵� <input type="text" name="userid" id="userid"><br>
	��� <input type="password" name="passwd"><br>
	<input type="button" value="�α���" onclick="check()"> <!-- ���۹�ư -->
</form>

</body>
</html>






