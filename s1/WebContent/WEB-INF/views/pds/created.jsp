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
function pdsSend() {
	var f=document.pdsForm;
	var mode="${mode}";
	var str;
	
	if(! f.category.value) {
        alert("\n카테고리를 입력하세요. ");
        f.category.focus();
        return false;
	}

	if(! f.gubun.value) {
        alert("\n공개여부를 입력하세요. ");
        f.gubun.focus();
        return false;
	}

	str = f.os.value;
    if(!str) {
        alert("\n운영체제를 입력하세요. ");
        f.os.focus();
        return false;
    }
	
	str = f.subject.value;
    if(!str) {
        alert("\n제목을 입력하세요. ");
        f.subject.focus();
        return false;
    }
	
	str=f.content.value;
	if(!str) {
		alert("파일 설명을 입력 하세요. ");
		f.content.focus();
		return false;
	}
	
    str = f.image.value;
    if(!str && mode=="created") {
        alert("\n이미지 파일을 선택 하세요. ");
        f.image.focus();
        return false;
    }
    
    if(str!="" && !/(\.gif|\.jpg|\.jpeg|\.png)$/i.test(str)) {
        alert("\n이미지 파일을 선택 하세요. ");
        f.image.focus();
        return false;
     }
    
	if(!f.upload.value && mode=="created") {
		alert("등록할 파일을 선택 하세요. !!!");
		f.upload.focus();
		return false;
	}
	
	if(mode=="created")
       f.action="<%=cp%>/pds/created_ok.do";
    else if(mode=="update")
       f.action="<%=cp%>/pds/update_ok.do";

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

		<form name="pdsForm" method="post" enctype="multipart/form-data" action="">
			<table width="600" cellpadding="0" cellspacing="0" style="margin: 0px auto;">
			  <tr height="2" bgcolor="#507CD1"><td colspan="2"></td></tr>
			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  카테고리
				  </td>
				  <td align="left" style="padding-left: 5px;">
					 <select name="category" class="selectField">
						  <option value=""> == 선택 == </option>
						  <option value="유틸리티" ${dto.category=="유틸리티"?"selected='selected'":"" }>유틸리티</option>
						  <option value="멀티미디어" ${dto.category=="멀티미디어"?"selected='selected'":"" }>멀티미디어</option>
						  <option value="게임" ${dto.category=="게임"?"selected='selected'":"" }>게임</option>
						  <option value="인터넷" ${dto.category=="인터넷"?"selected='selected'":"" }>인터넷</option>
						  <option value="드라이버" ${dto.category=="드라이버"?"selected='selected'":"" }>드라이버</option>
						  <option value="데스크탑" ${dto.category=="데스크탑"?"selected='selected'":"" }>데스크탑</option>
						  <option value="기타" ${dto.category=="기타"?"selected='selected'":"" }>기타</option>
					 </select>
				  </td>
			  </tr>
			  <tr height="1" bgcolor="#cccccc"><td colspan="2"></td></tr>

			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  공개여부
				  </td>
				  <td align="left" style="padding-left: 5px;">
					 <select name="gubun" class="selectField">
						  <option value=""> == 선택 == </option>
						  <option value="프리웨어" ${dto.gubun=="프리웨어"?"selected='selected'":"" }>프리웨어</option>
						  <option value="쉐어웨어" ${dto.gubun=="쉐어웨어"?"selected='selected'":"" }>쉐어웨어</option>
						  <option value="애드웨어" ${dto.gubun=="애드웨어"?"selected='selected'":"" }>애드웨어</option>
						  <option value="기타" ${dto.gubun=="기타"?"selected='selected'":"" }>기타</option>
					 </select>
				  </td>
			  </tr>
			  <tr height="1" bgcolor="#cccccc"><td colspan="2"></td></tr>

			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  지원 운영체제
				  </td>
				  <td align="left" style="padding-left: 5px;">
					 <input type="text" name="os" size="77" maxlength="100"  class="boxTF" value="${dto.os}"/>
				  </td>
			  </tr>
			  <tr height="1" bgcolor="#cccccc"><td colspan="2"></td></tr>

			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  제목
				  </td>
				  <td align="left" style="padding-left: 5px;">
					 <input type="text" name="subject" size="77" maxlength="100"  class="boxTF" value="${dto.subject}"/>
				  </td>
			  </tr>
			  <tr height="1" bgcolor="#cccccc"><td colspan="2"></td></tr>

			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  등록인
				  </td>
				  <td align="left" style="padding-left: 5px;">
					 ${sessionScope.session.userName}
				  </td>
			  </tr>
			  <tr height="1" bgcolor="#cccccc"><td colspan="2"></td></tr>
			  
			  <tr height="50">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  파일 설명
				  </td>
				  <td align="left" style="padding-left: 5px;">
					  <textarea rows="10" cols="75" name="content" class="boxTA" style="height: 70px;">${dto.content}</textarea>
				  </td>
			  </tr>
			  <tr height="1" bgcolor="#cccccc"><td colspan="2"></td></tr>
			  
			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  이미지
				  </td>
				  <td align="left" style="padding-left: 5px;">
					  <input type="file" name="image" class="boxTF" size="60" style="height: 20px"/>
				  </td>
			  </tr>
			  <tr height="1" bgcolor="#cccccc"><td colspan="2"></td></tr>

			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  파일
				  </td>
				  <td align="left" style="padding-left: 5px;">
					  <input type="file" name="upload" class="boxTF" size="60" style="height: 20px"/>
				  </td>
			  </tr>
			  <tr height="2" bgcolor="#507CD1"><td colspan="2"></td></tr>
			  
			  <c:if test="${mode=='update'}">
			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  업로드이미지
				  </td>
				  <td align="left" style="padding-left: 5px;">
					  ${dto.imageFileName}
				  </td>
			  </tr>
			  <tr height="1" bgcolor="#cccccc"><td colspan="2"></td></tr>
			  
			  <tr height="30">
				  <td width="100" align="center" bgcolor="#E4E4E4">
					  업로드파일
				  </td>
				  <td align="left" style="padding-left: 5px;">
					  ${dto.originalFileName}
				  </td>
			  </tr>
			  <tr height="2" bgcolor="#507CD1"><td colspan="2"></td></tr>
			  </c:if>
			  
			  <tr height="50">
				<td colspan="2" align="center">
				   <c:if test="${mode=='update'}">
					   <input type="hidden" name="num" value="${dto.num}"/>
					   <input type="hidden" name="pageNum" value="${pageNum}"/>
					   <input type="hidden" name="imageFileName" value="${dto.imageFileName}"/>
					   <input type="hidden" name="originalFileName" value="${dto.originalFileName}"/>
					   <input type="hidden" name="saveFileName" value="${dto.saveFileName}"/>
					   <input type="hidden" name="fileSize" value="${dto.fileSize}"/>
					</c:if>
					
					<input type="button" value="등록하기" class="btn" onclick="pdsSend();"/>
					<input type="reset" value="다시입력" class="btn"/>
					<input type="button" value="등록취소" class="btn" onclick="javascript:location.href='<%=cp%>/pds/list.do';" />
				</td>
			  </tr>
			</table>
		</form>
	
		</div>

		<br/>&nbsp;<br/>
    </div>
	
	<div class="layoutFooter">
		<jsp:include page="/layout/footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>