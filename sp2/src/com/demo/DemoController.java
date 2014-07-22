package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

// MultiActionController : ���� �׼��� ó��
public class DemoController extends MultiActionController {
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		req.setAttribute("msg", "�氡 �氡");
		return new ModelAndView("demo/list");

	}

	public ModelAndView writeForm(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		req.setAttribute("msg", "�氡 �氡");
		return new ModelAndView("demo/write");
	}

	public ModelAndView writeSubmit(HttpServletRequest req,
			HttpServletResponse resp, Demo demo) throws Exception {
		ModelAndView mav = new ModelAndView();

		String s = demo.getName() + "�� �ȳ�...";
		mav.setViewName("demo/result");
		mav.addObject("msg", s);
		mav.addObject("dto", demo);

		return mav;

	}
}
