package com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}

	protected void forward(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String uri=req.getRequestURI();
		String cp=req.getContextPath();
		MemberDAO dao=new MemberDAO();
		
		if(uri.indexOf("login.do")!=-1) {
			// 로그인 폼
			
			String path="/WEB-INF/views/member/login.jsp";
			forward(req, resp, path);
			
		} else if(uri.indexOf("login_ok.do")!=-1) {
			String userId=req.getParameter("userId");
			String userPwd=req.getParameter("userPwd");
			
			// userId의 정보를 가져옴
			MemberDTO dto=dao.readMember(userId);
			if(dto!=null) {
				// 아이디의 데이터가 존재하면
				// 패스워드가 일치하는지를 검사한다.
				if(dto.getUserPwd().equals(userPwd)) {
					// 로그인 정보를 세션에 저장한다.
					HttpSession session=req.getSession();
					
					// 세션유지시간을 20분으로 설정
					session.setMaxInactiveInterval(20*60);
					
					// 세션에 저장할 SessionInfo 객체 설정
					SessionInfo info=new SessionInfo();
					info.setUserId(dto.getUserId());
					info.setUserName(dto.getUserName());
					
					// 세션에 저장하기(session 이라는 이름으로 저장)
					session.setAttribute("session", info);
					
					// 메인화면으로
					resp.sendRedirect(cp);
					return;
				}
			}
			
			// 아이디 또는 패스워드가 잘못 된 경우
			String msg="아이디 또는 패스워드가 일치하지 않습니다.";
			req.setAttribute("message", msg);
			// 다시 로그인 화면으로 포워딩한다.
			String path="/WEB-INF/views/member/login.jsp";
			forward(req, resp, path);
			
		} else if(uri.indexOf("logout.do")!=-1) {
			// 세션에 저장된 값 지우기
			HttpSession session=req.getSession();
			session.removeAttribute("session");
			
			// 세션초기화(세션에 저장된 모든값 지워짐)
			session.invalidate();
			
			resp.sendRedirect(cp);
		} 
	}
}
