package com.willy.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendFeedBackImpl implements SendFeedBack {

	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public void sendFeedback(String userName, String userEmail, String userFeedBack) {

		SimpleMailMessage userReplyEmail = new SimpleMailMessage();
		SimpleMailMessage adminEmail = new SimpleMailMessage();
		
		userReplyEmail.setSubject("Feedback Recieved");
		userReplyEmail.setTo(userEmail);
		userReplyEmail.setText("Thank You " + userName + " your feedback is appreciated");
		
		javaMailSender.send(userReplyEmail);  
		
		adminEmail.setSubject("FeedBack for review");
		adminEmail.setTo("wyao919@gmail.com");
		adminEmail.setText("A user have left you feedback. Please see below " + userFeedBack);
		
		javaMailSender.send(adminEmail);
		
		
	}

}
