package com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/*")
public class MemberServlet extends HttpServlet{
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
		
		MemberDAO dao=new MemberDAO();
		String cp=req.getContextPath();
		String uri=req.getRequestURI();
		
		if(uri.indexOf("member.do")!=-1) {
			// 회원 가입폼
			req.setAttribute("mode", "created");

			String path="/WEB-INF/views/member/member.jsp";
			forward(req, resp, path);
		} else if(uri.indexOf("member_ok.do")!=-1) {
			// 회원 가입
			MemberDTO dto=new MemberDTO();
			
			dto.setUserId(req.getParameter("userId"));
			dto.setUserPwd(req.getParameter("userPwd"));
			dto.setUserName(req.getParameter("userName"));
			dto.setBirth(req.getParameter("birth"));
			String email1=req.getParameter("email1");
			String email2=req.getParameter("email2");
			if(email1!=null&&email1.length()!=0&&email2!=null&&email2.length()!=0) {
				dto.setEmail(email1+"@"+email2);
			}
			String tel1=req.getParameter("tel1");
			String tel2=req.getParameter("tel2");
			String tel3=req.getParameter("tel3");
			if(tel1!=null&&tel1.length()!=0&&tel2!=null&&tel2.length()!=0&&tel3!=null&&tel3.length()!=0) {
				dto.setTel(tel1+"-"+tel2+"-"+tel3);
			}
			dto.setJob(req.getParameter("job"));
			dto.setQuestion(req.getParameter("question"));
			dto.setAnswer(req.getParameter("answer"));
			dto.setZip(req.getParameter("zip"));
			dto.setAddr1(req.getParameter("addr1"));
			dto.setAddr2(req.getParameter("addr2"));
			
			int result=dao.insertMember(dto);
			if(result!=1) {
				String message="회원 가입을 실패 했습니다.";

				req.setAttribute("mode", "created");
				req.setAttribute("message", message);
				forward(req, resp, "/WEB-INF/views/member/member.jsp");
				return;
			}
			
			// resp.sendRedirect(cp); // 가입후 메인으로
			StringBuffer sb=new StringBuffer();
			sb.append("<b>"+dto.getUserName()+ "</b>님의 회원가입이 정상적으로 처리되었습니다.<br/>");
			sb.append("메인화면으로 이동하시어 로그인 하시기 바랍니다.<br/>");
			
			req.setAttribute("title", "회원가입");
			req.setAttribute("message", sb.toString());
			
			forward(req, resp, "/WEB-INF/views/member/complete.jsp");
			
		} else if(uri.indexOf("update.do")!=-1) {
			// 수정 폼
			HttpSession session=req.getSession();
			SessionInfo info=(SessionInfo)session.getAttribute("session");
			if(info==null) {
				forward(req, resp, "/WEB-INF/views/member/login.jsp");
				return;
			}
			
			MemberDTO dto=dao.readMember(info.getUserId());
			if(dto==null) {
				session.invalidate();
				resp.sendRedirect(cp);
				return;
			}
			
			// 이메일과 전화번호 분리
			if(dto.getEmail()!=null) {
				String ss[]=dto.getEmail().split("@");
				if(ss.length==2) {
					dto.setEmail1(ss[0]);
					dto.setEmail2(ss[1]);
				}
			}
			
			if(dto.getTel()!=null) {
				String ss[] = dto.getTel().split("-");
				if(ss.length==3) {
					dto.setTel1(ss[0]);
					dto.setTel2(ss[1]);
					dto.setTel3(ss[2]);
				}
			}
			
			req.setAttribute("dto", dto);
			req.setAttribute("mode", "update");
			
			forward(req, resp, "/WEB-INF/views/member/member.jsp");
			
		} else if(uri.indexOf("update_ok.do")!=-1) {
			// 수정 완료
			HttpSession session=req.getSession();
			SessionInfo info=(SessionInfo)session.getAttribute("session");
			if(info==null) {
				forward(req, resp, "/WEB-INF/views/member/login.jsp");
				return;
			}
			
			MemberDTO dto=new MemberDTO();
			
			dto.setUserId(info.getUserId());
			dto.setUserPwd(req.getParameter("userPwd"));
			dto.setBirth(req.getParameter("birth"));
			String email1=req.getParameter("email1");
			String email2=req.getParameter("email2");
			if(email1!=null&&email1.length()!=0&&email2!=null&&email2.length()!=0) {
				dto.setEmail(email1+"@"+email2);
			}
			String tel1=req.getParameter("tel1");
			String tel2=req.getParameter("tel2");
			String tel3=req.getParameter("tel3");
			if(tel1!=null&&tel1.length()!=0&&tel2!=null&&tel2.length()!=0&&tel3!=null&&tel3.length()!=0) {
				dto.setTel(tel1+"-"+tel2+"-"+tel3);
			}
			dto.setJob(req.getParameter("job"));
			dto.setQuestion(req.getParameter("question"));
			dto.setAnswer(req.getParameter("answer"));
			dto.setZip(req.getParameter("zip"));
			dto.setAddr1(req.getParameter("addr1"));
			dto.setAddr2(req.getParameter("addr2"));
			
			dao.updateMember(dto);
			
			// resp.sendRedirect(cp);
			StringBuffer sb=new StringBuffer();
			sb.append("<b>"+info.getUserName()+ "</b>님의 회원정보 수정이 정상적으로 처리되었습니다.<br/>");
			sb.append("즐거운 하루 보내시기 바랍니다.<br/>");
			
			req.setAttribute("title", "회원정보수정");
			req.setAttribute("message", sb.toString());
			
			forward(req, resp, "/WEB-INF/views/member/complete.jsp");
		}
	}
}
