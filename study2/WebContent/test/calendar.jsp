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

</head>
<body>

<br/>
<table width="210" style="margin: 0px auto;">
<tr height="25">
	<td align="center">
	    <a href="calendar.jsp?year=<%=y%>&month=<%=m-1%>">이전달</a>
	    <%=y%>년 <%=m%>월
	    <a href="calendar.jsp?year=<%=y%>&month=<%=m+1%>">다음달</a>
	</td>
</tr>
</table>

<table width="210" style="margin: 10px auto;" border="1">
<tr height="25">
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
	out.print("<tr height='25'>");
	for(int i=1; i<w; i++) {
		out.print("<td>&nbsp;</td>");
		cols++;
	}
	
	// 1~days(마지막날짜 까지 출력)
	for(int i=1; i<=days; i++) {
		out.print("<td align='center'>");
		out.print(i);
		out.print("</td>");
		
		if(++cols == 7 && i!=days) {
			out.print("</tr>");
			out.print("<tr height='25'>");
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