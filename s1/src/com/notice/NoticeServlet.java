package com.notice;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
		MyUtil myUtil = new MyUtil();

		HttpSession session = req.getSession();
		SessionInfo info = (SessionInfo) session.getAttribute("session");

		if (info == null && uri.indexOf("list.do") == -1) {
			String path = "/WEB-INF/views/member/login.jsp";
			forward(req, resp, path);
			return;
		}

		if (uri.indexOf("list.do") != -1) {

			// 넘어온 페이지 번호
			String pageNum = req.getParameter("pageNum");
			int current_page = 1;
			if (pageNum != null && pageNum.length() != 0) // 넘어온 페이지가 있으면
				current_page = Integer.parseInt(pageNum);

			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			if (searchKey == null) {
				searchKey = "subject";
				searchValue = "";
			}
			if (req.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue, "utf-8");
			}

			// 전체 데이터 개수 구하기
			int dataCount;
			dataCount = dao.dataCount(searchKey, searchValue);

			// 전체 페이지수 구하기
			int numPerPage = 10; // 한페이지 표시할 데이터 개수
			int total_page = myUtil.getPageCount(numPerPage, dataCount);

			// 전체 페이지 보다 표시할 페이지가 큰경우 전체 페이지로
			if (current_page > total_page)
				current_page = total_page;

			// 테이블에서 가져올 시작과 끝 위치
			int start = (current_page - 1) * numPerPage + 1;
			int end = current_page * numPerPage;

			// 테이블의 데이터를 가져 온다.
			List<NoticeDTO> list;
			list = dao.getListBoard(start, end, searchKey, searchValue);

			String params = "";
			if (searchValue != null && searchValue.length() != 0) {
				searchValue = URLEncoder.encode(searchValue, "utf-8");
				params = "searchKey=" + searchKey + "&searchValue="
						+ searchValue;
			}

			// 페이징처리
			String listUrl = cp + "/notice/list.do";
			String articleUrl = cp + "/notice/article.do?pageNum="
					+ current_page;
			if (params.length() != 0) {
				listUrl += "?" + params;
				articleUrl = articleUrl + "&" + params;
			}

			String pageIndexList = myUtil.pageIndexList(current_page,
					total_page, listUrl);

			// list.jsp 파일에 데이터를 넘겨 준다.
			req.setAttribute("list", list); // 데이터
			req.setAttribute("pageIndexList", pageIndexList); // 페이지리스트
			req.setAttribute("pageNum", current_page); // 현페이지
			req.setAttribute("dataCount", dataCount); // 전체개수
			req.setAttribute("articleUrl", articleUrl);

			// jsp로 포워딩
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

			// dto.setUserId(info.getUserId());
			dto.setUserName(dto.getUserName());

			dto.setHitCount(0);

			dao.insertNotice(dto);

			resp.sendRedirect(cp + "/notice/list.do");
		} else if (uri.indexOf("article.do") != -1) {

			String pageNum = req.getParameter("pageNum");
			int num = Integer.parseInt(req.getParameter("num"));

			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			if (searchKey == null) {
				searchKey = "subject";
				searchValue = "";
			}

			if (req.getMethod().equalsIgnoreCase("get")) {
				searchValue = URLDecoder.decode(searchValue, "utf-8");
			}

			dao.updateHitCount(num);

			NoticeDTO dto = dao.readNotice(num);
			if (dto == null) {
				resp.sendRedirect(cp + "/notice/list.do?pageNum=" + pageNum);
				return;
			}

			// 줄수
			int linesu = dto.getContent().split("\n").length;

			// 엔터를 <br/>로
			dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));

			// 글보기에서 글리스트로 갈때 넘길 파라미터
			String params = "pageNum=" + pageNum;
			if (searchValue.length() != 0) {
				params += "&searchKey=" + searchKey;
				params += "&searchValue="
						+ URLEncoder.encode(searchValue, "UTF-8");
			}

			// 포워딩 페이지에 값 넘기기
			req.setAttribute("dto", dto);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("linesu", linesu);
			req.setAttribute("params", params);

			// 포워딩
			String path = "/WEB-INF/views/notice/article.jsp";
			forward(req, resp, path);

		} else if (uri.indexOf("article_ok.do") != -1) {

			// 파라미터 받기
			NoticeDTO dto = new NoticeDTO();
			dto.setSubject(req.getParameter("subject"));
			dto.setContent(req.getParameter("content"));

			dto.setHitCount(0);

			// 저장하기
			dao.insertNotice(dto);

			resp.sendRedirect(cp + "/notice/list.do");
		} else if (uri.indexOf("update.do") != -1) {
			

		} else if (uri.indexOf("update.do") != -1) {

			resp.sendRedirect(cp + "/notice/list.do?pageNum=pageNum");
		} else if (uri.indexOf("delete_ok.do") != -1) {
			
			resp.sendRedirect(cp + "/notice/list.do");
		}
	}
}
