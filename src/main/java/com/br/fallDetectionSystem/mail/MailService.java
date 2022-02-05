package com.br.fallDetectionSystem.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService{
	
	@Autowired
	private JavaMailSender emailSender;

	public Boolean sendMail(String to, String subject, String text) {
		Boolean result = false;
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sistemadealertadequedas@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		try {
			emailSender.send(message);
			result = true;
		} catch (Exception ex) {
			result = false;
		}
		return result;
	}
	
}