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
<title>study</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css"/>
</head>

<body>
<div class="layoutMain">
	<div class="layoutHeader">
		<jsp:include page="/layout/header.jsp"></jsp:include>
	</div>
	
	<div class="layoutBody">
		    <div style="margin-top: 30px">
		    <table width="300" border="0" cellspacing="0" cellpadding="0" style="margin: 0px auto;">
	    		<tr align="left">
	      			<td height="40" bgcolor="white">
	          			<img src="<%=cp%>/data//images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />
	          			<span style="font-weight: bold;font-size:13pt;font-family: 나눔고딕, 맑은 고딕, 굴림;">게시판</span>
	      			</td>
	    		</tr>
			</table>
	    </div>
		
		<div style="margin: 10px auto; margin-bottom: 150px;">
			<form method="post" action="<%=cp%>/bbs/pwd_ok.do">
			   <table width="300" border="0" cellspacing="1" cellpadding="0" bgcolor="#cccccc" style="margin: 0px auto;">
			    <tr align="center">
			      <td height="40" bgcolor="#E6E4E6">
			          <b>게시물 ${title}</b>
			      </td>
			    </tr>
			
			    <tr align="center">
			      <td bgcolor="white" height="50">
			       <input type="hidden" name="mode" value="${mode}"/>
			       <input type="hidden" name="num" value="${num}">
			       <input type="hidden" name="pageNum" value="${pageNum}">
			       
			         패스워드 &nbsp;:&nbsp;
			         <input type="password" name="pwd" size="10" maxlength="10" class="boxTF"/>
			      </td>
			    </tr>
			  </table>
			   <br/>
			  <div align="center">
			    <p>
			      <input type="submit" value=" 확  인 " class="btn"/>&nbsp;&nbsp;
			      <input type="button" name="cancel" value=" 취  소 " class="btn"
			           onclick="javascript:location.href='<%=cp%>/bbs/list.do?pageNum=${pageNum}';"/>
			    </p>
			  </div>
			</form>
			
			<br/>
			<table border="0" width="300" cellspacing="0" cellpadding="0" style="margin: 0px auto;">
			    <tr align="center" height="30">
			      <td><font color='red'>${message}</font></td>
			    </tr>
			</table>
		</div>

    </div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>