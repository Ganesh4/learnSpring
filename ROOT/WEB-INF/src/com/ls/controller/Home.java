package com.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

	@RequestMapping("/home")
	public ModelAndView home()
	{
	    return new ModelAndView("home","message","Ganesh");
	}

	

}
