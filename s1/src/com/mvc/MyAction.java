package com.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyAction {
	protected abstract void execute(HttpServletRequest req,
			HttpServletResponse resq) throws ServletException, IOException;

	protected void forward(HttpServletRequest req, HttpServletResponse resq,
			String path) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resq);

	}
}
