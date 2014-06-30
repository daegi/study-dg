package com.bbs;

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

import com.util.MyUtil;

@WebServlet("/bbs/*")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// GET 방식 처리
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Post 방식 처리
		process(req, resp);
	}
	
	// 다른 페이지로 포워딩하는 메소드
	//   url : 포워딩할 대상
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// /context path/bbs/list.do
		String uri=req.getRequestURI();
		
		BoardDAO dao=new BoardDAO();
		MyUtil util=new MyUtil();

		if(uri.indexOf("list.do")!=-1) {
			// 글 리스트
			
			// 페이지번호
			int current_page=1;
			String pageNum=req.getParameter("pageNum");
			if(pageNum!=null)
				current_page=Integer.parseInt(pageNum);
			
			// 검색컬럼 및 검색 값 받기
			String searchKey=req.getParameter("searchKey");
			String searchValue=req.getParameter("searchValue");
			if(searchKey==null) {
				searchKey="subject";
				searchValue="";
			}

			// GET 방식인 경우(검색값 디코딩)
			if(req.getMethod().equalsIgnoreCase("GET")) {
				searchValue=URLDecoder.decode(
						searchValue, "UTF-8");
			}
			
			// 전체데이터개수
			int dataCount=dao.dataCount(searchKey, searchValue);
			
			// 전체페이지수
			int numPerPage=2;
			int total_page=util.getPageCount(numPerPage, dataCount);
			
			if(current_page>total_page)
				current_page=total_page;
			
			// 게시물 가져올 시작과 끝 위치
			int start=(current_page-1)*numPerPage+1;
			int end=current_page*numPerPage;
			
			// 게시물 가져오기
			List<BoardDTO> list=dao.listBoard(start, end, searchKey, searchValue);
			
			String cp=req.getContextPath();
			String listUrl=cp+"/bbs/list.do";
			String articleUrl=cp+"/bbs/article.do?pageNum="+current_page;
			
			// 검색값 인코딩
			searchValue=URLEncoder.encode(
					searchValue, "UTF-8");
			// 검색값이 존재하는 경우
			if(searchValue.length()!=0) {
				String s="searchKey="+searchKey+
						"&searchValue="+searchValue;
				listUrl+="?"+s;
				articleUrl+="&"+s;
			}
			
			// 페이징
			String pager=util.pageIndexList(
					current_page, total_page, listUrl);
			
			// 포워딩 페이지에 값 전달하기
			req.setAttribute("pageNum", current_page);
			req.setAttribute("list", list);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("articleUrl", articleUrl);
			req.setAttribute("pager", pager);
			
			// jsp로 포워딩
			String path="/WEB-INF/views/bbs/list.jsp";
			forward(req, resp, path);
			
		} else if(uri.indexOf("created.do")!=-1) {
			// 글쓰기 폼
			
			// 추가인지 수정인지 판단하기 위한 값
			req.setAttribute("mode", "created");
			
			String path="/WEB-INF/views/bbs/created.jsp";
			forward(req, resp, path);
			
		} else if(uri.indexOf("created_ok.do")!=-1) {
			// 파라미터 받기
			BoardDTO dto=new BoardDTO();
			dto.setName(req.getParameter("name"));
			dto.setSubject(req.getParameter("subject"));
			dto.setContent(req.getParameter("content"));
			dto.setPwd(req.getParameter("pwd"));
			
			// IP
			dto.setIpAddr(req.getRemoteAddr());
			
			dto.setHitCount(0);
			
			// 저장하기
			dao.insertBoard(dto);
			
			// 리스트로 리다이렉트
			String cp=req.getContextPath();
			resp.sendRedirect(cp+"/bbs/list.do");
			
		} else if(uri.indexOf("article.do")!=-1) {
			// 글보기
			
			// 글번호, 페이지번호 받기
			int num=Integer.parseInt(req.getParameter("num"));
			String pageNum=req.getParameter("pageNum");
			
			// 검색키값받기
			String searchKey=req.getParameter("searchKey");
			String searchValue=req.getParameter("searchValue");
			if(searchKey==null) {
				searchKey="subject";
				searchValue="";
			}
			// 디코딩
			searchValue=URLDecoder.decode(
					searchValue, "UTF-8");
			
			
			String cp=req.getContextPath();
			
			// 조회수 변경
			dao.updateHitCount(num);
			
			// 글가져오기
			BoardDTO dto=dao.readBoard(num);
			if(dto==null) { // 다른사람에의해 삭제된 경우
				resp.sendRedirect(cp+
						"/bbs/list.do?pageNum="+pageNum);
				return;
			}
			
			// 줄수
			int linesu=dto.getContent().split("\n").length;
			
			// 엔터를 <br/>로
			dto.setContent(
					dto.getContent().replaceAll("\n", "<br/>"));
			
			// 글보기에서 글리스트로 갈때 넘길 파라미터
			String params="pageNum="+pageNum;
			if(searchValue.length()!=0) {
				params+="&searchKey="+searchKey;
				params+="&searchValue="+
				   URLEncoder.encode(searchValue, "UTF-8");
			}
			
			// 포워딩 페이지에 값 넘기기
			req.setAttribute("dto", dto);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("linesu", linesu);
			req.setAttribute("params", params);
			
			// 포워딩
			String path="/WEB-INF/views/bbs/article.jsp";
			forward(req, resp, path);
		} else if(uri.indexOf("pwd.do")!=-1) {
			// 글번호, 페이지번호, mode(수정인지 삭제인지)
			int num=Integer.parseInt(req.getParameter("num"));
			String pageNum=req.getParameter("pageNum");
			String mode=req.getParameter("mode");
			
			String title;
			if(mode.equals("update"))
				title="수정";
			else
				title="삭제";
			
			// 포워딩 페이지에 넘길 데이터
			req.setAttribute("num", num);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("mode", mode);
			req.setAttribute("title", title);
			
			// 포워딩
			String path="/WEB-INF/views/bbs/pwd.jsp";
			forward(req, resp, path);
			
		} else if(uri.indexOf("pwd_ok.do")!=-1) {
			// 번호,패스워드,페이지,mode
			int num=Integer.parseInt(req.getParameter("num"));
			String pwd=req.getParameter("pwd");
			String pageNum=req.getParameter("pageNum");
			String mode=req.getParameter("mode");
			
			// 게시물가져오기
			BoardDTO dto=dao.readBoard(num);
			String cp=req.getContextPath();
			
			if(dto==null) {
				resp.sendRedirect(cp+
						"/bbs/list.do?pageNum="+pageNum);
				return;
			}
			
			// 패스워드가 일치하지 않은 경우
			if(! dto.getPwd().equals(pwd)) {
				// 다시 pwd.jsp로 포워딩
				
				String title="수정";
				if(mode.equals("delete"))
					title="삭제";
				
				req.setAttribute("num", num);
				req.setAttribute("pageNum", pageNum);
				req.setAttribute("mode", mode);
				req.setAttribute("title", title);
				req.setAttribute("message", "패스워드가 일치하지 않습니다.");
				
				String path="/WEB-INF/views/bbs/pwd.jsp";
				forward(req, resp, path);
				return;
			}
			
			if(mode.equals("delete")) {
				// 삭제인 경우
				dao.deleteBoard(num);

				resp.sendRedirect(cp+
						"/bbs/list.do?pageNum="+pageNum);				
				return;
			}
			
			// 수정인 경우
			req.setAttribute("mode", "update");
			req.setAttribute("dto", dto);
			req.setAttribute("pageNum", pageNum);
			
			String path="/WEB-INF/views/bbs/created.jsp";
			forward(req, resp, path);
			
		} else if(uri.indexOf("update_ok.do")!=-1) {
			// 파라미터 받기
			BoardDTO dto=new BoardDTO();
			dto.setNum(
					Integer.parseInt(req.getParameter("num")));
			dto.setName(req.getParameter("name"));
			dto.setSubject(req.getParameter("subject"));
			dto.setContent(req.getParameter("content"));
			dto.setPwd(req.getParameter("pwd"));
			String pageNum=req.getParameter("pageNum");
			
			dao.updateBoard(dto);
			
			String cp=req.getContextPath();
			resp.sendRedirect(cp+"/bbs/list.do?pageNum="+
						pageNum);
		}
		
		
	}

	
}
