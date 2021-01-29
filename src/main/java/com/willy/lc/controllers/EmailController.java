package com.willy.lc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.willy.lc.api.EmailDTO;
import com.willy.lc.api.UserInfoDTO;
import com.willy.lc.service.LCAppEmailServiceImpl;
import com.willy.lc.service.LCappEmailService;

@Controller
public class EmailController {
	
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailService;

	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) {
		
		model.addAttribute("emailDTO", new EmailDTO());
//		model.addAttribute("userName", userName.toUpperCase());
		
		return "send-email-page";
	}

	@RequestMapping("processEmail")
	public String processEmail(@SessionAttribute("userInfo") UserInfoDTO userInfoDTO,
			@ModelAttribute("emailDTO") EmailDTO emailDto, BindingResult result) {
		
		lcAppEmailService.sendEmail(userInfoDTO.getUserName(), emailDto.getUserEmail(), "FRIEND");
		
		System.out.println("in process email method");
		return "process-email-page";
		
	}

}
