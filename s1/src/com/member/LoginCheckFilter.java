package com.member;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resq,
			FilterChain chain) throws IOException, ServletException {
		if (req instanceof HttpServletRequest) {
			HttpServletRequest hreq = (HttpServletRequest) req;
			HttpSession session = hreq.getSession();
			String uri = hreq.getRequestURI();

			boolean b = false;
			String[] ss = { "/bbs/", "/board" };

			for (String s : ss) {
				if (uri.indexOf(s) != -1) {
					b = true;
					break;

				}
			}

			if (b) {
				SessionInfo info = (SessionInfo) session
						.getAttribute("session");
				if (info == null) {
					// 로그인 페이지로 포워딩
					String path = "/WEB-INF/views/member/login.jsp";

					RequestDispatcher rd = hreq.getRequestDispatcher(path);
					rd.forward(req, resq);
					return;

				}
			}

			chain.doFilter(req, resq);

		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
