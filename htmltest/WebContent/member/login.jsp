<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- login.jsp -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="../include/jquery-2.1.1.js"></script>
<script type="text/javascript">
	//������ �ε��� �Ϸ�Ǹ� �ڵ����� ������ ��ɵ�
	$(docment).read(function() {
		//Ŭ�� �̺�Ʈ ���
		$("#btnLogin").click(function() {
			check();
		});
	});

	function check() {
		//var userid = document.getElementById("userid");

		var userid = $("#userid");

		//if (userid.value == "") { //���̸�
		if (userid.val() == "") { //�±�.val() �±׿� �Էµ� ��
			alert("���̵� �Է��ϼ���");
			userid.focus(); //�±�.focus() �±׿� �Է���Ŀ�� ����
			return; //�Լ��� �����Ŵ
		}
		var exp1 = /^[A-Za-z0-9]{3,10}$/;
		//if (!exp1.test(userid.value)) {
		if (!exp1.test(userid.val())) {
			alert("���̵�� ������ 4~10�ڸ��� �Է°����մϴ�.");
			userid.focus();
			return;
		}
		//document.getElementById("form1").submit();
		$("#form1").submit();
	}
</script>
</head>
<body>
	<!-- �� : ������ �ڷḦ �����ϱ� ���� �Է¾�� -->
	<form method="post" action="login_check.jsp" id="form1">
		<!-- �ڷḦ ���� �ּ� -->
		���̵� <input type="text" name="userid" id="userid"><br> ���
		<input type="password" name="passwd"><br> <input
			type="button" value="�α���" id="btnLogin">
		<!-- ���۹�ư -->
		<input type="button" value="ȸ������" onclick="location.href='join.jsp';">
	</form>

</body>
</html>






