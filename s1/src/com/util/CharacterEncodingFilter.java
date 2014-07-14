package com.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//인코딩 필터
public class CharacterEncodingFilter implements Filter {
	private String charset;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resq,
			FilterChain chain) throws IOException, ServletException {

		if (req instanceof HttpServletRequest) {
			HttpServletRequest hreq = (HttpServletRequest) req;
			String uri = hreq.getRequestURI();

			// uri에 ajax.do가 존재하면
			if (uri.indexOf("ajax.do") != -1)
				hreq.setCharacterEncoding("utf-8");
			else
				hreq.setCharacterEncoding(charset);
		}

		chain.doFilter(req, resq);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		if (charset == null)
			charset = "utf-8";
	}
}
