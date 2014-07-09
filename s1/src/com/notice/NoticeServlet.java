package com.notice;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbs.BoardDTO;
import com.member.SessionInfo;
import com.util.MyUtil;

@WebServlet("/notice/*")
public class NoticeServlet extends HttpServlet {
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

		NoticDAO dao = new NoticDAO();
		MyUtil util = new MyUtil();

		HttpSession session = req.getSession();
		SessionInfo info = (SessionInfo) session.getAttribute("session");

		if (info == null && uri.indexOf("list.do") == -1) {
			String path = "/WEB-INF/views/member/login.jsp";
			forward(req, resp, path);
			return;
		}

		if (uri.indexOf("list.do") != -1) {

			/*int current_page = 1;
			String pageNum = req.getParameter("pageNum");
			if (pageNum != null)
				current_page = Integer.parseInt(pageNum);


			// 전체페이지수
			int numPerPage = 2;
			int total_page = util.getPageCount(numPerPage, dataCount);

			if (current_page > total_page)
				current_page = total_page;

			// 게시물 가져올 시작과 끝 위치
			int start = (current_page - 1) * numPerPage + 1;
			int end = current_page * numPerPage;

			// 게시물 가져오기
			List<NoticeDTO> list = dao.getListNotice(start, end);

			String listUrl = cp + "/notice/list.do";
			// String articleUrl=cp+"/notice/article.do?pageNum="+current_page;

			// 페이징
			String pager = util
					.pageIndexList(current_page, total_page, listUrl);

			// 포워딩 페이지에 값 전달하기
			req.setAttribute("pageNum", current_page);
			req.setAttribute("list", list);
			// req.setAttribute("articleUrl", articleUrl);
			req.setAttribute("pager", pager);
*/
			String path = "/WEB-INF/views/notice/list.jsp";
			forward(req, resp, path);

		} else if (uri.indexOf("created.do") != -1) {

			req.setAttribute("mode", "created");

			String path = "/WEB-INF/views/notice/created.jsp";
			forward(req, resp, path);

		} else if (uri.indexOf("created_ok.do") != -1) {

			NoticeDTO dto = new NoticeDTO();

			dto.setSubject(req.getParameter("subject"));
			dto.setContent(req.getParameter("content"));

			dto.setUserId(info.getUserId());

			dto.setHitCount(0);

			dao.insertNotice(dto);

			resp.sendRedirect(cp + "/notice/list.do");
		}
	}
}
