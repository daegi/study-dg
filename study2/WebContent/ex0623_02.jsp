<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//체크박스 모두 선택
	function checkAll() {
		for (var i = 1; i <= 5; i++) {
			box = eval("document.checkboxform.C" + i);
			if (box.checked == false)
				box.checked = true;
		}
	}

	function uncheckAll() {
		for (var i = 1; i <= 5; i++) {
			box = eval("document.checkboxform.C" + i);
			if (box.checked == true)
				box.checked = false;
		}
	}

	function switchAll() {
		for (var i = 1; i <= 5; i++) {
			box = eval("document.checkboxform.C" + i);
			box.checked = !box.checked;
		}
	}

	function send() {

	}
</script>
<style type="text/css">
li {
	border-bottom: 1px solid #666666;
	width: 200px;
}


</style>
</head>
<body>

	<form name="checkboxform" method="post">
		<div>
			<div>
				<ul>
					<li><input type="checkbox" name="C1">체크1</li>
					<li><input type="checkbox" name="C2">체크2</li>
					<li><input type="checkbox" name="C3">체크3</li>
					<li><input type="checkbox" name="C4">체크4</li>
					<li><input type="checkbox" name="C5">체크5</li>
				</ul>
			</div>
		</div>


		<input type="button" value="모두체크" onclick="checkAll();"> <input
			type="button" value="모두체크 해제" onclick="uncheckAll();"> <input
			type="button" value="체크 반전" onclick="switchAll();">
	</form>

</body>
</html>