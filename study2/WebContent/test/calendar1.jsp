<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Calendar" %>

<%
	request.setCharacterEncoding("utf-8");
	Calendar cal=Calendar.getInstance();
	
	int y=cal.get(Calendar.YEAR);
	int m=cal.get(Calendar.MONTH)+1;
	
	String _year=request.getParameter("year");
	String _month=request.getParameter("month");
	
	if(_year!=null){
		y=Integer.parseInt(_year);
		m=Integer.parseInt(_month);
	}

	cal.set(y,m-1,1);
	y=cal.get(Calendar.YEAR);
	m=cal.get(Calendar.MONTH)+1;
	
 	// y년 m월 1일 요일(1~7)
	int w=cal.get(Calendar.DAY_OF_WEEK);
 	// y년 m월의 마지막 날짜
	int days=cal.getActualMaximum(Calendar.DATE);
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
*{
	margin: 0px;
	padding: 0px;
	font-family: 나눔고딕,돋움;
	font-size: 9pt;
}
</style>

<script type="text/javascript">
function send() {
	var f=document.forms[0];
	f.submit();
}
</script>

</head>
<body>

<br/>

<form action="calendar1.jsp" method="post">
<table width="210" style="margin: 0px auto;">
<tr height="25">
	<td align="center">
		<select name="year" onchange="send();">
			<%for(int i=y-5; i<=y-1;  i++) { %>
			    <option value="<%=i%>"> <%=i%>년 </option>
			<%} %>
			<option value="<%=y%>" selected="selected"> <%=y%>년 </option>
			<%for(int i=y+1; i<=y+5;  i++) { %>
			    <option value="<%=i%>"> <%=i%>년 </option>
			<%} %>
		</select>
		&nbsp;&nbsp;
		<select name="month"  onchange="send();">
		  <%for(int i=1; i<=12; i++) { %>
				<option value="<%=i%>" <%=m==i?"selected='selected' ":"" %>> <%=i%>월 </option>		  
		  <%} %>
		</select>
	</td>
</tr>
</table>
</form>

<table width="210" style="margin: 5px auto;" cellspacing="1" bgcolor="black">
<tr height="25" bgcolor="#FFFFFF">
	<td align="center" width="30" style="color: red">일</td>
	<td align="center" width="30">월</td>
	<td align="center" width="30">화</td>
	<td align="center" width="30">수</td>
	<td align="center" width="30">목</td>
	<td align="center" width="30">금</td>
	<td align="center" width="30" style="color: blue;">토</td>
</tr>

<%
	int cols=0;
	
	// 1일 앞의 공백 처리
	out.print("<tr height='25' bgcolor='#FFFFFF'>");
	for(int i=1; i<w; i++) {
		out.print("<td>&nbsp;</td>");
		cols++;
	}
	
	// 1~days(마지막날짜 까지 출력)
	String forcolor;
	for(int i=1; i<=days; i++) {
		if(cols==0)
			forcolor="red";
		else if(cols==6)
			forcolor="blue";
		else
			forcolor="black";
		
		out.print("<td align='center' style='color:"+forcolor+"'>");
		out.print(i);
		out.print("</td>");
		
		if(++cols == 7 && i!=days) {
			out.print("</tr>");
			out.print("<tr height='25' bgcolor='#FFFFFF'>");
			cols=0;
		}
	}
	
	while(cols>0&&cols<7){
		out.print("<td>&nbsp;</td>");
		cols++;
	}
	out.print("</tr>");
%>

</table>	




</body>
</html>