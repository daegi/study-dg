package com.svt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Calendar cal = Calendar.getInstance();
		String s = String.format("%tF %tT", cal, cal);

		resp.setContentType("text/htme; charset= utf-8");

		PrintWriter out = resp.getWriter();

		out.println("<html><body>");
		out.println("방가방가^^<br>");
		out.println("현제시간은:" + s);
		out.println("</body></html>");
	}
}