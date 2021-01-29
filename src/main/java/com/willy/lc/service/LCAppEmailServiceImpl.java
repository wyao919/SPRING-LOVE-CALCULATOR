package com.willy.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCappEmailService {

	@Autowired
	private JavaMailSender javaMailSenderImpl;
	
	@Override
	public void sendEmail(String userName, String userEmail, String result) {

		SimpleMailMessage newEMail = new SimpleMailMessage();
		newEMail.setTo(userEmail);
		newEMail.setSubject("Love Calculator Application Result");
		newEMail.setText("hi " + userName + "the result predicted by the LC app is " + result); // body of text
		
		javaMailSenderImpl.send(newEMail);
		
		
		
	}

}
