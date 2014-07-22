package com.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {
	private HelloService helloService;

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resq) throws Exception {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("hello/hello");
		mav.addObject("msg", helloService.getMessage());

		return mav;
	}

}
