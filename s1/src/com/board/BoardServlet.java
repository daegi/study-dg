package com.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.member.SessionInfo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.MyUtil;

@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
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
		BoardDAO dao = new BoardDAO();
		MyUtil myUtil = new MyUtil();

		HttpSession session = req.getSession();
		SessionInfo info = (SessionInfo) session.getAttribute("session");
		if (info == null) {
			String path = "/WEB-INF/views/member/login.jsp";
			forward(req, resp, path);
			return;
		}

		String root = session.getServletContext().getRealPath("/");
		String pathname = root + "uploads" + File.separator + "board";

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
			List<BoardDTO> list;
			list = dao.getListBoard(start, end, searchKey, searchValue);

			// 리스트의 번호
			int listNum, n = 0;
			Iterator<BoardDTO> it = list.listIterator();
			while (it.hasNext()) {
				BoardDTO dto = (BoardDTO) it.next();
				listNum = dataCount - (start + n - 1);
				dto.setListNum(listNum);
				n++;
			}

			String params = "";
			if (searchValue != null && searchValue.length() != 0) {
				searchValue = URLEncoder.encode(searchValue, "utf-8");
				params = "searchKey=" + searchKey + "&searchValue="
						+ searchValue;
			}

			// 페이징처리
			String listUrl = cp + "/board/list.do";
			String articleUrl = cp + "/board/article.do?pageNum="
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

			String path = "/WEB-INF/views/board/list.jsp";
			forward(req, resp, path);
		} else if (uri.indexOf("created.do") != -1) {

			req.setAttribute("mode", "created");
			String path = "/WEB-INF/views/board/created.jsp";
			forward(req, resp, path);

		} else if (uri.indexOf("created_ok.do") != -1) {
			File dir = new File(pathname);
			if (!dir.exists())
				dir.mkdirs();
			String encType = "UTF-8";
			int maxSize = 5 * 1024 * 1024;

			try {
				MultipartRequest mreq = new MultipartRequest(req, pathname,
						maxSize, encType, new DefaultFileRenamePolicy());

				BoardDTO dto = new BoardDTO();

				dto.setUserId(info.getUserId());
				dto.setSubject(mreq.getParameter("subject"));
				dto.setContent(mreq.getParameter("content"));

				dto.setDepth(0);
				dto.setOrderNo(0);
				dto.setParent(0);

				if (mreq.getFilesystemName("upload") != null
						&& mreq.getFilesystemName("upload").length() != 0) {
					dto.setOriginalFileName(mreq.getOriginalFileName("upload"));
					dto.setSaveFileName(mreq.getFilesystemName("upload"));
				}

				dao.insertBoard(dto, "created");
			} catch (Exception e) {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				pw.print("<script>alert('파일용량은 최대 5MB입니다. !!!');history.back();</script>");
				return;
			}

			resp.sendRedirect(cp + "/board/list.do");

		} else if (uri.indexOf("article.do") != -1) {
			// 글보기
			String pageNum = req.getParameter("pageNum");
			int num = Integer.parseInt(req.getParameter("num"));

			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			if (searchKey == null) {
				searchKey = "subject";
				searchValue = "";
			}

			if (req.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue, "utf-8");
			}

			// 조회수 증가
			dao.updateHitCount(num);

			// 게시물 읽기
			BoardDTO dto = dao.readBoard(num);
			if (dto == null) {
				resp.sendRedirect(cp + "/board/list.do?pageNum=" + pageNum);
				return;
			}

			int linesu = dto.getContent().split("\r\n").length;
			dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));

			// 이전글/다음글

			String params = "pageNum=" + pageNum;
			if (!searchValue.equals("")) {
				searchValue = URLEncoder.encode(searchValue, "utf-8");
				params += "&searchKey=" + searchKey + "&searchValue="
						+ searchValue;
			}

			req.setAttribute("pageNum", pageNum);
			req.setAttribute("dto", dto);
			req.setAttribute("linesu", linesu);
			req.setAttribute("params", params);

			forward(req, resp, "/WEB-INF/views/board/article.jsp");

		} else if (uri.indexOf("reply.do") != -1) {

			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");

			BoardDTO dto = dao.readBoard(num);
			if (dto == null) { // 게싶물이 없으면 리스트로
				resp.sendRedirect(cp + "/board/list.do?pageNum=pageNum");
				return;
			}

			// 답변폼으로 포워딩
			dto.setContent(dto.getSubject() + "답변입니다. \n");

			req.setAttribute("mode", "reply");
			req.setAttribute("dto", dto);
			req.setAttribute("pageNum", pageNum);

			String path = "/WEB-INF/views/board/created.jsp";
			forward(req, resp, path);

		} else if (uri.indexOf("reply_ok.do") != -1) {
			// 답글 저장
			
			String pageNum = "1";
			try {
				MultipartRequest mreq = new MultipartRequest(req, pathname,
						maxSize, encType, new DefaultFileRenamePolicy());

				
				pageNum = mreq.getParameter("pageNum");
				
				BoardDTO dto = new BoardDTO();

				dto.setUserId(info.getUserId());
				dto.setSubject(mreq.getParameter("subject"));
				dto.setContent(mreq.getParameter("content"));
				
				int groupNum = Integer.parseInt(mreq.getParameter("groupNum"));
				int depth = Integer.parseInt(mreq.getParameter("depth"));
				int orderNo = Integer.parseInt(mreq.getParameter("orderNo"));
				int parent = Integer.parseInt(mreq.getParameter("parent"));
				
				//orderNo 변경
				
				dao.updateOrderNo(groupNum, orderNo);
				
				dto.setGroupNum(groupNum); //부모의 그룹
				dto.setDepth(depth+1);	//부모보다 1큼
				dto.setOrderNo(orderNo+1);	//부모보다 1큼
				dto.setParent(parent);	
								

				if (mreq.getFilesystemName("upload") != null
						&& mreq.getFilesystemName("upload").length() != 0) {
					dto.setOriginalFileName(mreq.getOriginalFileName("upload"));
					dto.setSaveFileName(mreq.getFilesystemName("upload"));
				}

				dao.insertBoard(dto, "reply");
			} catch (Exception e) {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				pw.print("<script>alert('파일용량은 최대 5MB입니다. !!!');history.back();</script>");
				return;
			}
			
			
			
			resp.sendRedirect(cp + "/board/list.do?pageNum="+pageNum);

		}

	}

}
