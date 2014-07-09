<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin: 0px;
padding: 0px;
}

body {
	font-family: 돋움;
	font-size: 9pt;
}

.boxTF{
border: 1px solid #0000ff; 
height: 22px


}

</style>

</head>
<body>

<table width="600" border="1" style="margin: 20px auto;" cellspacing="0">
<tr height="50">
   <td align="center">게시판</td>
</tr>
</table>

<br/>
<table border="0" width="600" style="margin: 0px auto;"
    cellspacing="0" cellpadding="0">
    
<tr height="1"><td colspan="2" bgcolor="#0000ff"></td></tr>

<tr height="30">
	<td width="120" bgcolor="#dedede" align="center">
	제목
	</td>
	<td width="480" style="padding-left:5px;">
	<input type="text" name="subject" class="boxTF" style="width: 250px;">
	</td>
</tr>
<tr height="1"><td colspan="2" bgcolor="#0000ff"></td></tr>

<tr height="30">
	<td width="120" bgcolor="#dedede" align="center">
	이름
	</td>
	<td width="480" style="padding-left:5px;">
	<input type="text" name="subject" class="boxTF" style="width: 250px;">
	</td>
</tr>
<tr height="1"><td colspan="2" bgcolor="#0000ff"></td></tr>


</table>



</body>
</html>