package com.willy.lc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.willy.lc.api.UserInfoDTO;
import com.willy.lc.service.CalculateLoveImpl;

@Controller
@SessionAttributes("userInfo")
public class LCAppController {
	@Autowired
	CalculateLoveImpl calculate;

	@RequestMapping("/")
	public String showHomePage(Model model) {


		model.addAttribute("userInfo", new UserInfoDTO());
		return "home-page";
	}

	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult result,
			Model model, HttpServletRequest request) {
		
	

		System.out.println(userInfoDTO.isTermAndCondition());
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			return "home-page";
		}
		
		HttpSession session = request.getSession();  //this is to create the session
		session.setAttribute("userName", userInfoDTO.getUserName());    //this is to set the session name from a userInfoDTO
		session.setMaxInactiveInterval(120);//this will close the session after 120 minutes

		String finalResult = calculate.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());

		model.addAttribute("finalResult", finalResult);

		// write a service which will calculate the love % between the user and the
		// crushName

		return "result-page";
	}

}
