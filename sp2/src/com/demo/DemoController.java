package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

// MultiActionController : 여러 액션을 처리
public class DemoController extends MultiActionController {
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		req.setAttribute("msg", "방가 방가");
		return new ModelAndView("demo/list");

	}

	public ModelAndView writeForm(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		req.setAttribute("msg", "방가 방가");
		return new ModelAndView("demo/write");
	}

	public ModelAndView writeSubmit(HttpServletRequest req,
			HttpServletResponse resp, Demo demo) throws Exception {
		ModelAndView mav = new ModelAndView();

		String s = demo.getName() + "님 안녕...";
		mav.setViewName("demo/result");
		mav.addObject("msg", s);
		mav.addObject("dto", demo);

		return mav;

	}
}
