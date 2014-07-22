package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * Controller는 AbstractController 등을 상속 받고
 * 환경설정파일에서 bean 태그로 등록했지만
 * 이 모든것을 @Controller 해결
 */

/*
 * @RequestMapping : 하나의 컨트롤러에서  
 * 여러 액션을 처리하는 어노테이션
 */

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/user/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String list() throws Exception {
		return "user/list";
	}

	@RequestMapping(value = "/user/write", method = { RequestMethod.GET })
	public ModelAndView writeForm() throws Exception {

		return new ModelAndView("user/write");
	}

	@RequestMapping(value = "/user/write", method = { RequestMethod.POST })
	public ModelAndView writeSubmit(User u) throws Exception {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("user/result");
		mav.addObject("u", u);
		mav.addObject("msg", service.result(u));
		
		return mav;
	}

}
