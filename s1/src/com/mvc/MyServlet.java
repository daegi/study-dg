package com.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 생성된 MyAction 하위 클래스의 객체를 저장할 맵
	private Map<String, Object> map = new Hashtable<String, Object>();

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

	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		MyAction action = null;

		try {
			String uri = req.getRequestURI();
			// System.out.println("1" + uri);
			if (uri.indexOf(req.getContextPath()) == 0)
				uri = uri.substring(req.getContextPath().length());

			// System.out.println("2" + uri);

			action = (MyAction) map.get(uri);
			action.execute(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// 서블릿이 실행될때 최초 한번만 실행

		// web.xml에서 init-param 값 읽어 들임
		ServletContext context = config.getServletContext();

		// config라는 이름의 init-param 값 읽어 들임
		String pathname = config.getInitParameter("config");
		if (pathname == null) {
			return;
		}

		// 해당파일의 실제 경로 구하기
		pathname = context.getRealPath(pathname);

		// uri와 매핑정보를 저장할 객체
		Properties p = new Properties();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(pathname);

			// 파일의 내용을 읽어 Properties에 저장
			p.load(fis);

		} catch (Exception e) {
			System.out.println(e.toString());

			// 예외를 던짐
			throw new ServletException(e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e2) {

				}
			}
		}
		// Properties의 저장된 클래스의 객체를 생성하여 map 저장
		Iterator<Object> it = p.keySet().iterator();
		while (it.hasNext()) {
			String k = (String) it.next();
			String className = p.getProperty(k).trim();

			try {
				Class<?> cls = Class.forName(className);
				Object o = cls.newInstance();

			} catch (Exception e) {
				throw new ServletException();
			}
		}

	}
}
