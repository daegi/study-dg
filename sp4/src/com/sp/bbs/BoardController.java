package com.sp.bbs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("bbs.boardController")
public class BoardController {

	@Autowired
	private BoardService service;

	@RequestMapping(value = "bbs/list")
	public ModelAndView list() throws Exception {

		ModelAndView mav = new ModelAndView("bbs/list");

		return mav;
	}

	@RequestMapping(value = "bbs/created", method = RequestMethod.GET)
	public ModelAndView createdForm() throws Exception {

		ModelAndView mav = new ModelAndView("bbs/created");

		return mav;
	}

	@RequestMapping(value = "bbs/created", method = RequestMethod.POST)
	public String createdSubmit(Board dto, HttpServletRequest req)
			throws Exception {

		dto.setIpAddr(req.getRemoteAddr());

		service.insertBoard(dto);

		return "redirect:/bbs/list.action";
	}

}
