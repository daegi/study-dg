<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>공지</title>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>
<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css" />

<script type="text/javascript">





</script>

<style type="text/css">
*{
	margin: 0px; padding: 0px;
}
body {
	font-size: 9pt; font-family: 돋움;
}
td {
	font-size: 9pt;
}
a{
    color: #000000;
	text-decoration: none;
}
a:active, a:hover {
	text-decoration: underline;
	color: tomato;
}
.title {
	font-weight: bold;
	font-size:13pt;
	margin-bottom:10px;
	font-family: 나눔고딕, 맑은 고딕, 굴림;
}
.boxTF { border:1px solid; height:15px; margin-top:3px; padding:2px 2px 2px 2px; border-color:#666666; background-color:#ffffff; font-family:"굴림"; font-size:9pt; }
.boxTA { border:1px solid; height:150px; margin-top:3px; padding:2px 2px 2px 2px; border-color:#666666; background-color:#ffffff; font-family:"굴림"; font-size:9pt; }
.selectFiled {border:1px solid; border-color:#666666; background-color:#ffffff; font-family:굴림; font-size:9pt;}
.btn {font-size: 9pt; color:rgb(0,0,0); border:1px solid; border-color: #AAAAAA; background-color:rgb(255, 255, 255); padding:0px 7px 3px 7px; font-family: 나눔고딕, 맑은 고딕, 굴림;}
</style>

<script type="text/javascript">

</script>
</head>

<body>

	<div class="layoutMain">
		<div class="layoutHeader">
			<jsp:include page="/layout/header.jsp"></jsp:include>
		</div>
	</div>


<table width="560" border="0" cellspacing="0" cellpadding="0" style="margin: 0px auto;">
<tr height="40"> 
	<td align="left" class="title">
		<img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />게시판
	</td>
</tr>
</table>

<br/>

	<table width="560" cellspacing="0" cellpadding="0"
		style="table-layout: fixed; word-break: break-all; margin: 0px auto;">
		<tr>
			<td colspan="4" height="3" bgcolor="#507CD1"></td>
		</tr>

		<tr>
			<td height="35" colspan="4" align="center">${dto.subject}</td>
		</tr>
		<tr>
			<td colspan="4" height="2" bgcolor="#507CD1"></td>
		</tr>

		<tr>
			<td width="60" height="30" bgcolor="#EEEEEE" align="center">작성자</td>
			<td width="220" align="left" style="padding-left: 10px;">
				${dto.userName}</td>
			<td width="60" height="30" bgcolor="#EEEEEE" align="center">줄&nbsp;&nbsp;수</td>
			<td width="220" align="left" style="padding-left: 10px;">
				${linesu}</td>
		</tr>
		<tr>
			<td colspan="4" height="1" bgcolor="#DBDBDB"></td>
		</tr>

		<tr>
			<td width="60" height="30" bgcolor="#EEEEEE" align="center">등록일</td>
			<td width="220" align="left" style="padding-left: 10px;">
				${dto.created}</td>
			<td width="60" height="30" bgcolor="#EEEEEE" align="center">조회수</td>
			<td width="220" align="left" style="padding-left: 10px;">
				${dto.hitCount}</td>
		</tr>
		<tr>
			<td colspan="4" height="1" bgcolor="#507CD1"></td>
		</tr>

		<tr>
			<td colspan="4" align="left" style="padding: 20px 80px 20px 62px;"
				valign="top" height="200">${dto.content}</td>
		</tr>
	<!-- 	<tr>
			<td colspan="4" height="2" bgcolor="#507CD1"></td>
		</tr>

		<tr>
			<td width="60" height="30" bgcolor="#EEEEEE" align="center">이전글</td>
			<td width="220" align="left" style="padding-left: 10px;" colspan="3">
				이전글 입니다.</td>
		</tr>
		<tr>
			<td colspan="4" height="1" bgcolor="#DBDBDB"></td>
		</tr>

		<tr>
			<td width="60" height="30" bgcolor="#EEEEEE" align="center">다음글</td>
			<td width="220" align="left" style="padding-left: 10px;" colspan="3">
				다음글 입니다.</td>
		</tr> -->
		<tr>
			<td colspan="4" height="3" bgcolor="#507CD1" align="center"></td>
		</tr>
	</table>

	<table width="560" border="0" style="margin: 0px auto;">
<tr height="30">
    <td width="300" align="left">
    	<input type="image" src="<%=cp%>/data/images/btn_modify.gif" />
    	<input type="image" src="<%=cp%>/data/images/btn_delete.gif" />
    </td>

    <td align="right">
    	<input type="image" src="<%=cp%>/data/images/btn_list.gif"
    	     onclick="javascript:location.href='<%=cp%>/notice/list.do?${params}';"/>
    </td>
</tr>
</table>

<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>


</body>
</html>
