package com.shop.chae;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/*")
public class AboutController {

	@RequestMapping(value = "/aboutUs" , method = RequestMethod.GET)
	public String aboutUs(Model model) throws Exception{
		return "about/aboutUs";
	}
	
	@RequestMapping(value = "/contactUs" , method = RequestMethod.GET)
	public String contactUs(Model model) throws Exception{
		return "contact/contactUs";
	}
}
