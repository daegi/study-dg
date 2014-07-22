package com.demo1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("demo1.demoController")
public class DemoController {

	@RequestMapping(value = "/demo1/calc", method = RequestMethod.GET)
	public ModelAndView form() throws Exception {

		return new ModelAndView("demo1/write");
	}

	/*
	 * 방법1
	 * 
	 * @RequestMapping(value = "/demo1/calc", method = RequestMethod.POST)
	 * public ModelAndView submit(int num1, int num2, String oper) throws
	 * Exception {
	 * 
	 * int result; if (oper.equals("+")) result = num1 + num2; else if
	 * (oper.equals("-")) result = num1 - num2; else if (oper.equals("*"))
	 * result = num1 * num2; else result = num1 / num2;
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.setViewName("demo1/write");
	 * mav.addObject("result", result); mav.addObject("num1", num1);
	 * mav.addObject("num2", num2); mav.addObject("oper", oper);
	 * 
	 * return mav; }
	 */

	/*
	 * 방법2
	 * 
	 * @RequestMapping(value = "/demo1/calc", method = RequestMethod.POST)
	 * public String submit(HttpServletRequest req, int num1, int num2, String
	 * oper) throws Exception {
	 * 
	 * int result; if (oper.equals("+")) result = num1 + num2; else if
	 * (oper.equals("-")) result = num1 - num2; else if (oper.equals("*"))
	 * result = num1 * num2; else result = num1 / num2;
	 * 
	 * req.setAttribute("result", result); req.setAttribute("num1", num1);
	 * req.setAttribute("num2", num2); req.setAttribute("oper", oper);
	 * 
	 * return "demo1/write"; }
	 */

	@RequestMapping(value = "/demo1/calc", method = RequestMethod.POST)
	public String submit(HttpServletRequest req) throws Exception {

		try {
			String oper = req.getParameter("oper");
			int num1 = Integer.parseInt(req.getParameter("num1"));
			int num2 = Integer.parseInt(req.getParameter("num2"));

			int result;
			if (oper.equals("+"))
				result = num1 + num2;
			else if (oper.equals("-"))
				result = num1 - num2;
			else if (oper.equals("*"))
				result = num1 * num2;
			else
				result = num1 / num2;

			req.setAttribute("result", result);
			req.setAttribute("num1", num1);
			req.setAttribute("num2", num2);
			req.setAttribute("oper", oper);

		} catch (Exception e) {
			// 리다이렉트
			return "redirect:/demo1/error.action";
		}
		// /포워딩
		return "demo1/write";
	}

	@RequestMapping(value = "/demo1/error")
	public String error() {
		return "demo1/error";
	}
}