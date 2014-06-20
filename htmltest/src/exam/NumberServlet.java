package exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NumberDao;
import model.NumberDaoImpl;

// sum.do => NumberServlet.java
public class NumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 입력한 값을 숫자로 변환
		int num = Integer.parseInt(request.getParameter("num"));
		NumberDao dao = new NumberDaoImpl();
		int sum = dao.getSum(num);
/*		int sum=0;
		for(int i=1; i<=num; i++){
			sum += i;
		}*/
//		PrintWriter out = response.getWriter();
//		out.println("sum:"+ sum);
		String url = "/07_servlet/ex01_result.jsp";
		// request 객체에 출력할 값을 미리 저장함
		request.setAttribute("sum", sum);
		// url의 정보 분석 객체
		RequestDispatcher rd=  request.getRequestDispatcher(url);
		// 지정된 주소로 페이지와 데이터를 이동시킴
		rd.forward(request, response);
	}
}








