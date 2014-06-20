package exam;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GuestbookDao;
import model.GuestbookDaoImpl;
import model.GuestbookDto;

public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dao 객체 생성
		GuestbookDao dao = new GuestbookDaoImpl();
		// guestbook 테이블의 내용을 리스트로 리턴받음
		List<GuestbookDto> list = dao.gbList();
		// request 객체에 리스트를 저장시킴
		request.setAttribute("list", list);
		// 페이지 이동 및 데이터 전달
		String url = "/guestbook/gb_list.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}






