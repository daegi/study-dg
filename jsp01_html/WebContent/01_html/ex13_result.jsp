
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8"); //한글 처리
		// 값이 한 개인 경우 - request.getParameter("태그의 name");
		// 값이 배열인 경우 - request.getParameterValues("배열 이름");
		String job = request.getParameter("job");
// job == "1"으로 하면 잘못된 결과가 나올 수 있음, equals method 사용 권장		
		if( job.equals("1") ) {   // A.equals(B)  문자열의 내용 비교
			job = "학생";
		}else if( job.equals("2") ) {
			job = "사무직";
		}else if( job.equals("3") ) {
			job = "전문직";
		}else if( job.equals("4") ) {
			job = "교사";
		}else if( job.equals("5") ) {
			job = "공무원";
		} 
		// hobby의 name이 복수개이므로 배열로 저장해야 함
		String[] hobby = request.getParameterValues("hobby");
		String memo = request.getParameter("memo");
		//줄바꿈 처리
		memo = memo.replace("\n", "<br>"); //줄바꿈 문자를 <br>태그로 변환
		// 공백 처리
		memo = memo.replace(" ", "&nbsp;"); // &nbsp; 스페이스 한칸
	%>
	직업 :
	<%=job%><br> 취미 :
	<%
		if (hobby != null) {
			for (int i = 0; i < hobby.length; i++) {
				out.println(hobby[i] + " ");
			}
		}
	%>
	<br> 메모 :
	<%=memo%>
</body>
</html>










