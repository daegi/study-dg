package com.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.SessionInfo;

@WebServlet("/pds/*")
public class PdsServlet extends HttpServlet {
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

	protected void forward(HttpServletRequest req, HttpServletResponse resp,
			String path) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);

	}

	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String uri = req.getRequestURI();
		String cp = req.getContextPath();

		HttpSession session = req.getSession();

		req.setCharacterEncoding("utf-8");

		// 로그인 하지 않은 상태는 무조건 로그인 페이지로
		SessionInfo info = (SessionInfo) session.getAttribute("session");

		if (info == null) {
			String path = "/WEB-INF/views/member/login.jsp";
			forward(req, resp, path);
			return;
		}

		if (uri.indexOf("list.do") != -1) {
			String path = "/WEB-INF/views/pds/list.jsp";
			forward(req, resp, path);
		} else if (uri.indexOf("created.do") != -1) {

			String path = "/WEB-INF/views/pds/created.jsp";
			forward(req, resp, path);
		} else if (uri.indexOf("created_ok.do") != -1) {
			
			
			resp.sendRedirect(cp + "/pds/list.do");
		}

	}

}
