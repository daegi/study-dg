package com.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("demo3.demoController")
public class DemoController {

	@RequestMapping(value = "/demo3/write", method = RequestMethod.GET)
	public String form() throws Exception {

		return ("demo3/write");
	}

	@RequestMapping(value = "/demo3/result", method = RequestMethod.POST)
	public ModelAndView submit(Demo3 d3) throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("demo3/result");

		return mav;

	}
}