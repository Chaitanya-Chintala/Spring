package com.journaldev.spring.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.model.User;

@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("Home Page Requested");
		return new ModelAndView("home", "fruit", new User());
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public  @ResponseBody ModelAndView user(HttpServletRequest request) {
		System.out.println("User Page Requested");
		return new ModelAndView("user", "fruit", request.getParameter("ff"));

	}
}
