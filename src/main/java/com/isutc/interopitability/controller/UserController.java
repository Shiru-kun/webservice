package com.isutc.interopitability.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@GetMapping("")
	public ModelAndView create(ModelAndView model) {
		model = new ModelAndView("user/create");
		return model;
	}
}
