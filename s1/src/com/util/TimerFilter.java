package com.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class TimerFilter implements Filter {
	private FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		// request 필터(servlet 또는 jsp 실행전
		long b = System.currentTimeMillis();

		// 다음필터 또는 해당 서블릿/jsp 실행
		chain.doFilter(req, resp);

		// response 필터(클라이언트에게 전송 하기전
		long a = System.currentTimeMillis();

		if (req instanceof HttpServletRequest) {
			HttpServletRequest hreq = (HttpServletRequest) req;
			String uri = hreq.getRequestURI();

			String s = uri +":"+ (a-b) + "ms";

			// 로그기록
			config.getServletContext().log(s);
			// 실무에서는 로그를 기록하고 아래처럼하면 무식
			System.out.println(s);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
