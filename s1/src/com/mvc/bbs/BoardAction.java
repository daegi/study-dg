package com.mvc.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.MyAction;

public class BoardAction extends MyAction {

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resq)
			throws ServletException, IOException {

		String method = req.getParameter("method");
		if (method == null || method.equals("list")) {

			
			String path = "/WEB-INF/mvc/bbs/list.jsp";
			forward(req, resq, path);
		} else if (method.equals("created")) {

			
			String path = "/WEB-INF/mvc/bbs/created.jsp";
			forward(req, resq, path);
		}
	}

}
