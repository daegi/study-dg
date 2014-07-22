<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String cp=request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>study</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/data/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/data/css/layout.css" type="text/css"/>

<script type="text/javascript">
function pdsDelete(num) {
	if(confirm("삭제 하시 겠습니까 ? ")) {
		var url="<%=cp%>/pds/delete.do?num="+num+"&pageNum=${pageNum}";
		location.href=url;
	}
}


function categoryChange() {
	var f=document.categoryForm;
	
	f.action="<%=cp%>/pds/list.do";
	
	f.submit();
}

function searchList() {
	var f=document.searchForm;
	
	f.action="<%=cp%>/pds/list.do";
	
	f.submit();
}
</script>

</head>

<body>
<div class="layoutMain">
	<div class="layoutHeader">
		<jsp:include page="/layout/header.jsp"></jsp:include>
	</div>
	
	<div class="layoutBody">
		<div style="width:100%;	height: 40px;  line-height:40px;clear: both; border-top: 1px solid #DAD9FF;border-bottom: 1px solid #DAD9FF;">
		    <div style="width:600px; height:30px; line-height:30px; margin:5px auto;">
		        <img src="<%=cp%>/data/images/arrow.gif" width="11" height="11" alt="" style="padding-left: 5px; padding-right: 5px;" />
		        <span style="font-weight: bold;font-size:13pt;font-family: 나눔고딕, 맑은 고딕, 굴림;">자료실</span>
		    </div>
		</div>
		
		<div style="margin: 10px auto; margin-top: 30px;">

		<table width="600" cellpadding="0" cellspacing="0" style="margin: 0px auto;">
		   <tr height="30" bgcolor="#FFFFFF">
				<td width="400" align="left">
				  <form name="categoryForm" method="post">
					<select id="category" name="category" class="selectField" onchange="categoryChange();">
						  <option value="">전체 리스트</option>
						  <option value="유틸리티" ${category=="유틸리티"?"selected='selected'":"" }>유틸리티</option>
						  <option value="멀티미디어" ${category=="멀티미디어"?"selected='selected'":"" }>멀티미디어</option>
						  <option value="게임" ${category=="게임"?"selected='selected'":"" }>게임</option>
						  <option value="인터넷" ${category=="인터넷"?"selected='selected'":"" }>인터넷</option>
						  <option value="드라이버" ${category=="드라이버"?"selected='selected'":"" }>드라이버</option>
						  <option value="데스크탑" ${category=="데스크탑"?"selected='selected'":"" }>데스크탑</option>
						  <option value="기타" ${category=="기타"?"selected='selected'":"" }>기타</option>
					</select>
					</form>
				</td>
				<td align="right">
					<input type="button" value=" 등록하기 " class="btn" onclick="javascript:location.href='<%=cp%>/pds/created.do';">
				</td>
		   </tr>
		</table>	   		
		
		<table width="600" border="0" cellpadding="0" cellspacing="0" style="margin: 0px auto;">
		   <tr height="3" bgcolor="#507CD1"><td colspan="3"></td></tr>
		   
		   
		   
		   <!-- 내용 표현 -->

       <c:forEach var="dto" items="${list }">

			 <tr height="30">
			   <td colspan="3" align="center">
				   ${dto.subject}
			   </td>
			 </tr>
			 <tr height="1" bgcolor="#CCCCCC"><td colspan="3"></td></tr>
		 
		   <tr height="25">
			   <td width="160" align="center" rowspan="5">
				   <img src="<%=cp%>/uploads/${dto.originalFileName}" border="0" width="140" height="100"/>
			   </td>
			   <td width="220" align="left">
				   카테고리 | ${dto.category}
			   </td>
			   <td width="220" align="left">
				  공개여부 | ${dto.gubun}
			   </td>
		   </tr>

		   <tr height="25">
			   <td width="220" align="left">
				 운영체제 | ${dto.os}
			   </td>
			   <td width="220" align="left">
				  다운횟수 | ${dto.downCount}
			   </td>
		   </tr>

		   <tr height="25">
			   <td width="220" align="left">
				 파일이름 | ${dto.originalFileName}
			   </td>
			   <td width="220" align="left">
				  파일크기 | ${dto.fileSize} bytes.
			   </td>
		   </tr>
		   
		   <tr height="25">
			   <td width="220" align="left">
				 자료등록 | ${dto.userName}
			   </td>
			   <td width="220" align="left">
				  등록일자 | ${dto.created}
			   </td>
		   </tr>
		   
		   <tr height="25">
			   <td width="220" align="left">
					 <a href="<%=cp%>/pds/down.do?num=${dto.num}">다운로드</a>     
			   </td>
			   <td width="220" align="right">
					  <a href="<%=cp%>">수정</a>
					  <a href="javascript:pdsDelete('${dto.num}');">삭제</a>
			   </td>
		   </tr>
		   <tr height="1" bgcolor="#CCCCCC"><td colspan="3"></td></tr>
							   
		   <tr height="30">
			   <td align="left" colspan="3">파일설명</td>
			</tr>
		   <tr height="1" bgcolor="#CCCCCC"><td colspan="3"></td></tr>
							   
		   <tr height="50" valign="top">
			   <td align="left" colspan="3" style="padding-top: 5px;">${dto.content}</td>
			</tr>

		   <tr height="3" bgcolor="#507CD1"><td colspan="3"></td></tr>

		</c:forEach>
		  
		  <c:if test="${dataCount==0 }">
			<tr height="30">
			   <td align="center" colspan="3">
					등록된 자료가 없습니다.
			   </td>
			</tr>
			 <tr height="3" bgcolor="#507CD1"><td colspan="3"></td></tr>
		  </c:if>

		  <c:if test="${dataCount!=0 }">
			 <tr height="35">
			   <td align="left" colspan="3">
				  <form name="searchForm" method="post" action="">
					<select name="searchKey" class="selectField">
					   <option value="subject">제목</option>
					   <option value="userName">작성자</option>
					   <option value="content">파일설명</option>
					</select>
					<input type="hidden" name="category" value="${category}"/>
					<input type="text" name="searchValue" class="boxTF"/>
					<input type="button" value=" 검 색 " class="btn" onclick="searchList();"/>
				 </form>
			   </td>
			 </tr>
			 
			 <tr height="30">
			   <td align="center" colspan="3">
				  ${pageIndexList}
			   </td>
			 </tr>
		  </c:if>
		</table>
		
		</div>

		<br/>&nbsp;<br/>
    </div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>