package com.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("demo2.demoController")
public class DemoController {

	// get, post 동시 처리
	@RequestMapping(value = "/demo2/write")
	public ModelAndView execute(
			@RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "name", defaultValue = "") String irum,
			@RequestParam(value = "age", defaultValue = "0") int age)
			throws Exception {

		ModelAndView mav = new ModelAndView();

		if (mode == null) {
			mav.setViewName("demo2/write");
		} else {
			mav.setViewName("demo2/result");

			String s;
			s = irum + ":" + age;
			mav.addObject("result", s);

		}

		return mav;

	}

}
