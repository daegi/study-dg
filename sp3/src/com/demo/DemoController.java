package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@RequestMapping(value = "/demo/list")
	public ModelAndView writeForm() throws Exception {
		return new ModelAndView("demo/list");
	}

	@RequestMapping(value = "/demo/deleteChk", method = RequestMethod.POST)
	public ModelAndView writeSubmit(String[] chk) throws Exception {
		String s = "선택항목:";
		if (chk != null) {
			for (String n : chk)
				s += n + ":";
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("demo/result");
		mav.addObject("s",s);
		return mav;
	}
}
