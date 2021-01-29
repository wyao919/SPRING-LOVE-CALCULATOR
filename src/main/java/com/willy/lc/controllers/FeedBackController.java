package com.willy.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.willy.lc.api.FeedBackDTO;
import com.willy.lc.service.SendFeedBackImpl;

@Controller
public class FeedBackController {
	
	@Autowired
	SendFeedBackImpl sendFeedBackImpl;
	
	@RequestMapping("/feedback")
	public String leaveFeedBack(@ModelAttribute("feedBackDTO") FeedBackDTO feedBackDTO)
	{
		System.out.println("in feedback controller");
		
		
		
		return "feedback-page";
	}
	
	@RequestMapping("/processFeedBack")
	public String processFeedback(@Valid @ModelAttribute("feedBackDTO") FeedBackDTO feedBackDTO, BindingResult result)
	{
		System.out.println("in process feedback controller");

		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			return "feedback-page";
		}
		
		sendFeedBackImpl.sendFeedback(feedBackDTO.getUserName(), feedBackDTO.getUserEmail(), feedBackDTO.getFeedBack());
		
		return "feedbackprocess-page";
		
	}
	

}
