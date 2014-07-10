package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
/*
 * 서블릿작성 방법
 *   1. GenericServlet 상속받는다.
 *   2. HttpServlet 상속받는다.
 */
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TestServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	private int count;

	@Override
	public void destroy() {
		System.out.println("서블릿이 저세상으로....");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("서블릿이 처음 실행될때 한번만...");
		count = 100;
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		// 클라이언트들이 요청해 들어올때마다 실행

		// 다운캐스팅
		HttpServletRequest hreq = (HttpServletRequest) req;
		String method = hreq.getMethod();

		count++;

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.println("method :" + method + "<br/>");
		out.println("count:" + count + "<br/>");

	}
}
