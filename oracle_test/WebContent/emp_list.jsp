<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<!-- 클래스 임포트 -->
<!-- WebContent/WEB-INF/lib 폴더에 ojdbc6.jar 복사
WebContent/WEB-INF/lib 폴더 : 외부라이브러리 전용 폴더
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<!-- 테이블 테두리를 1로 설정 -->
		<tr>
			<!-- Table Row 테이블의 행 -->
			<td>사번</td>
			<!-- Table Division 테이블의 셀 -->
			<td>이름</td>
			<td>부서</td>
		</tr>
		<%
			// 자바코드 영역, scriptlet(스크립틀릿) 
			String driver = "oracle.jdbc.driver.OracleDriver";
			// 오라클 연결 문자열 jdbc:oracle:thin:@서버주소:포트:DB이름
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr"; // 오라클 사용자계정
			String pwd = "hr"; // 사용자계정의 비밀번호
			// DB접속을 처리하는 인터페이스
			Connection conn = null; // java.sql.Connection
			Statement stmt = null; // java.sql.Statement
			ResultSet rs = null;
			// DB관련 작업은 반드시 예외처리를 해야 함
			try {
				Class.forName(driver); // jdbc 드라이버 클래스 로드
				conn = DriverManager.getConnection(url, id, pwd); // 오라클에 접속
				// System.out.println("오라클에 접속되었습니다.");
				// sql 쿼리 작성
				String sql = 
"select "
+" employee_id, first_name, department_name, e.department_id "
+" from employees e, departments d "   
+" where e.department_id = d.department_id";
				// Statement객체 = 커넥션.createStatement() : 쿼리실행객체 생성
				stmt = conn.createStatement();
				// 결과셋 = Statement객체.executeQuery( 쿼리문 ) 쿼리 실행
				rs = stmt.executeQuery(sql);
				while (rs.next()) { // 다음 레코드가 존재하면				
					// 결과셋.get자료형("컬럼")
					// System.out.println() 톰캣 콘솔창에 출력(서버관리자용)
					// out.println() 웹브라우저에 출력			
					//				out.println(rs.getInt("eno") + "\t" + rs.getString("ename")
					//						+ "\t" + rs.getInt("salary")+"<br>");
		%>
		<tr>
			<td><%=rs.getInt("employee_id")%></td>
			<td><%=rs.getString("first_name")%></td>
			<td><%=rs.getString("department_name")%></td>
		</tr>
		<%
			} //while의 끝 
			} catch (Exception e) {
				e.printStackTrace();
			} finally { // 오픈한 역순으로 닫아줌
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				} // try
			} // while
		%>
	</table>
</body>
</html>








