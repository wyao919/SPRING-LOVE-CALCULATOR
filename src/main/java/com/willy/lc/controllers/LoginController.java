package com.willy.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/customLogin")
	public String showLogin() {

		return "login-page";

	}
	
	@RequestMapping("/accessdenied")
	public String showDenied() {

		return "access-denied-page";

	}

}
