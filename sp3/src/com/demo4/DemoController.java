package com.demo4;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("demo4.demoController")
public class DemoController {

	@RequestMapping(value = "demo4/test")
	public ModelAndView test() throws Exception {

		return new ModelAndView("demo4/test");
	}

	@RequestMapping(value = "demo4/set")
	public ModelAndView set(HttpServletResponse resp) throws Exception {

		Cookie ck = new Cookie("menu", "1");
		ck.setPath("/"); // 모든 경로에서 쿠키 접근가능하게

		resp.addCookie(ck);

		return new ModelAndView("demo4/test");
	}

	@RequestMapping(value = "demo4/get")
	public ModelAndView get(
			@CookieValue(value = "menu", defaultValue = "0") String m,
			HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("demo4/get");

		mav.addObject("m", m);

		// 쿠키 지우기
		Cookie ck = new Cookie("menu", null);
		ck.setMaxAge(0);
		resp.addCookie(ck);

		return mav;
	}
}
