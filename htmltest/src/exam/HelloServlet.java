package exam;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet(서블릿, 서버에서 실행되는 자바 클래스)
// jsp 페이지도 내부적으로 서블릿으로 변환되어 실행됨
// 어노테이션
// @SuppressWarnings 경고를 무시함
//@WebServlet("/hello")
// web.xml 파일을 WebContent/WEB-INF에 복사
public class HelloServlet extends HttpServlet {
	// 객체 직렬화에 필요한 클래스의 고유 아이디
	private static final long serialVersionUID = 1L;
// get 방식으로 호출했을 때
// request - 클라이언트의 요청을 처리하는 객체
// response	- 서버의 응답을 처리하는 객체 
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		//콘솔창에 출력됨
		System.out.println("hello");
		//웹브라우저에 출력되는 내용
//response.getWriter() => PrintWriter 객체 생성
// html 코드를 생성하는 객체 		
// 클라이언트에 출력할 html 소스에 대한 한글 처리		
		response.setContentType("text/html; charset=utf-8");
		//System.out.println(response.getContentType());
		PrintWriter out = response.getWriter();
		out.println("hello servlet<br>");
		out.println("안녕하세요.");
	}
// post 방식으로 호출했을 때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
