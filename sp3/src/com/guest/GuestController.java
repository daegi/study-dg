package com.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {

	@RequestMapping(value = "/guest/guest", method = { RequestMethod.GET})
	public ModelAndView writeForm() throws Exception {

		return new ModelAndView("guest/guest");
	}

	@RequestMapping(value = "/guest/guest", method = { RequestMethod.POST })
	public ModelAndView writeSubmit(Guest g) throws Exception {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("guest/result");
		mav.addObject("g", g);

		return mav;
	}

}
