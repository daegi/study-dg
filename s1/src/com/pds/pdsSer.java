package com.pds;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.SessionInfo;
import com.util.MyUtil;

public class pdsSer extends HttpServlet {
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

		req.setCharacterEncoding("utf-8");

		String uri = req.getRequestURI();
		String cp = req.getContextPath();
		HttpSession session = req.getSession();

		MyUtil util = new MyUtil();

		PdsDAO dao = new PdsDAO();

		// 로그인하지 않은 상태는 로그인 페이지로
		SessionInfo info = (SessionInfo) session.getAttribute("session");

		if (info == null) {
			String path = "/WEB-INF/views/member/login.jsp";
			forward(req, resp, path);
			return;
		}

		// 자료실
		if (uri.indexOf("list.do") != -1) {
			// 리스트
			String pageNum = req.getParameter("pageNum");
			int current_page = 1;
			if (pageNum != null && pageNum.length() !=0	){
				current_page= Integer.parseInt(pageNum);
			}
			String category = req.getParameter("category");
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(category == null)
				category = "";
			if(searchKey == null || searchKey.length() == 0	){
				searchKey = "subject";
				searchValue = "";
			}
			
			if(req.getMethod().equalsIgnoreCase("get")){
				category= URLDecoder.decode(category, "utf-8");
				sear
			}
				
			

		}

	}

}
