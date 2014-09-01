package com.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageCtrl {

	@RequestMapping("/welcome")
	public String index()
	{
		return "welcome";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/gallery")
	public String gallery()
	{
		return "gallery";
	}
	
	@RequestMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	
	@RequestMapping("/product")
	public String product()
	{
		return "product";
	}
}
