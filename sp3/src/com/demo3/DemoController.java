package com.demo3;

import java.util.List;

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
	public String submit() throws Exception {

		// 리스트로 받는다.

		Demo3 demo3 = new Demo3();

		demo3.getAge();
		demo3.getBirth();
		demo3.getBobby();
		demo3.getFavor();
		demo3.getGender();
		demo3.getName();

		
	}
}