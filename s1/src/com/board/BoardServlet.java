package com.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
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

		HttpSession session = req.getSession();

		BoardDAO dao = new BoardDAO();
		
		

		// 페이지 처리
		MyUtil util = new MyUtil();

		// 로그인하지 않은 상태는 로그인 페이지로
		SessionInfo info = (SessionInfo) session.getAttribute("session");

		if (info == null) {
			String path = "/WEB-INF/views/member/login.jsp";
			forward(req, resp, path);
			return;
		}

		if (uri.indexOf("list.do") != -1) {
			

			String pageNum = req.getParameter("pageNum");

			int current_page = 1;
			if (pageNum != null && pageNum.length() != 0) {
				current_page = Integer.parseInt(pageNum);
			}

			String category = req.getParameter("gategory");
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");

			if (category == null)
				category = "";

			if (searchKey == null || searchKey.length() == 0) {
				searchKey = "subject";
				searchValue = "";
			}

			if (req.getMethod().equalsIgnoreCase("get")) {
				category = URLDecoder.decode(category, "utf-8");
				searchValue = URLDecoder.decode(searchValue, "utf-8");
			}

			int numPerPage = 2;
			int dataCount = dao.dataCount(category, searchKey, searchValue);

			int total_page = util.getPageCount(numPerPage, dataCount);

			if (current_page > total_page)
				current_page = total_page;

			int start = (current_page - 1) * numPerPage + 1;
			int end = current_page * numPerPage;

			List<BoardDTO> list = dao.listBoard(start, end, category,
					searchKey, searchValue);

			for (BoardDTO dto : list) {
				dto.setContent(dto.getContent().replace("\n", "<br/>"));
			}

			String params = "";
			if (category.length() != 0) {
				params = "?category=" + URLEncoder.encode(category, "utf-8");
			}

			if (searchValue.length() != 0) {
				if (params.length() == 0)
					params = "?";
				else
					params = "&";

				params += "searchKey=" + searchKey + "&searchValue="
						+ URLEncoder.encode(searchValue, "utf-8");
			}

			String listUrl = cp + "/board/list.do" + params;
			String pageIndexList = util.pageIndexList(current_page, total_page,
					listUrl);

			req.setAttribute("category", category);
			req.setAttribute("list", list);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("pageNum", current_page);
			req.setAttribute("pageIndexList", pageIndexList);

			String path = "/WEB-INF/views/board/list.jsp";
			forward(req, resp, path);
			
		} else if (uri.indexOf("created.do") != -1) {

			req.setAttribute("mode", "created");
			String path = "/WEB-INF/views/board/created.jsp";
			forward(req, resp, path);

		} else if (uri.indexOf("created_ok.do") != -1) {

			String root = session.getServletContext().getRealPath("/");
			String pathname = root + "uploads" + File.separator + "board";

			// 폴더가 존재하지 않으면 작성
			File f = new File(pathname);
			if (!f.exists())
				f.mkdirs();

			// 파일용량 5메가
			String encType = "utf-8";
			int maxFilesize = 5 * 1024 * 1024;

			try {
				
				BoardDTO dto = new BoardDTO();
				
				MultipartRequest mreq = new MultipartRequest(req, pathname,
						maxFilesize, encType, new DefaultFileRenamePolicy());

				dto.setUserId(info.getUserId());

				dto.setSubject(mreq.getParameter("subject"));
				dto.setContent(mreq.getParameter("content"));

				String files = mreq.getFilesystemName("upload");
				if (files != null && files.length() != 0) {
					String fileExt = files.substring(files.lastIndexOf("."));

					String nfiles = String.format(
							"%1$tY%1$tm%1$td%1$tH%1$tM%1$tS",
							Calendar.getInstance());
					nfiles += System.nanoTime();
					nfiles += fileExt;

					File f1 = new File(pathname + File.separator + files);
					File f2 = new File(pathname + File.separator + nfiles);
					f1.renameTo(f2);

					dto.setSaveFileName(mreq.getFilesystemName("upload"));
					dto.setOriginalFileName(nfiles);
				}

				dao.insertBoard(dto);

			} catch (Exception e) {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				pw.print("<script>alert('파일 업로드가 실패했습니다. !!!');history.back();</script>");
				return;
			}

			resp.sendRedirect(cp + "/board/list.do");

		}

	}
}
