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
<title>게 시 판</title>
<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css" />

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
	.selectFiled {border:1px solid; border-color:#666666; background-color:#ffffff; font-family:굴림; font-size:9pt;}
	.btn {font-size: 9pt; color:rgb(0,0,0); border:1px solid; border-color:#AAAAAA; background-color:rgb(255, 255, 255); padding:0px 7px 3px 7px; font-family: 나눔고딕, 맑은 고딕, 굴림;}
</style>

<script type="text/javascript">
function searchList() {
	
}
</script>

</head>

<body>

<div class="layoutMain">
		<div class="layoutHeader">
			<jsp:include page="/layout/header.jsp"></jsp:include>
		</div>

<table width="650" border="0" cellspacing="0" cellpadding="0" style="margin: 0px auto;">
<tr height="40">
	<td align="left" class="title">
		<img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />게시판
	</td>
</tr>
</table>

<br/>

<table width="650" cellspacing="0" cellpadding="0" style="margin: 0px auto;">
   <tr height="30">
      <td align="left" width="50%">
          
      </td>
      <td align="right">&nbsp;</td>
   </tr>
</table>

<table width="650" border="0" cellspacing="1" cellpadding="0"
   bgcolor="#cccccc" style="margin: 0px auto;">
  <tr align="center" bgcolor="#e6e4e6" height="25"> 
      <td width="50">번호</td>
      <td width="390">제목</td>
      <td width="90">작성자</td>
      <td width="70">작성일</td>
      <td width="50">조회수</td>
  </tr>
 
  <tr align="center" bgcolor="#ffffff" height="25"> 
      <td align="center">1</td>
      <td align="left" style="padding-left: 10px;">테스트</td>
      <td align="center">홍길동</td>
      <td align="center">2000-10-10</td>
      <td align="center">10</td>
  </tr>
 
 </table>
<table width="650" cellspacing="0" cellpadding="0" style="margin: 0px auto;">
   <tr height="30">
      <td align="left" width="50%">&nbsp;</td>
      <td align="right">
           <input type="image" src="<%=cp%>/data/images/btn_write.gif"
             onclick="javascript:location.href='<%=cp%>/notice/created.do';"  />
      </td>
   </tr>
</table>




<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>


</body>
</html>