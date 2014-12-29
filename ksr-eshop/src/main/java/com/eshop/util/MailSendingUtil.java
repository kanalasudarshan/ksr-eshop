package com.eshop.util;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.eshop.admin.dto.MessageDTO;

@Component("mailSendingUtil")
public class MailSendingUtil {
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	private static final Logger logger = Logger.getLogger(MailSendingUtil.class);
	public String sendMail(MessageDTO messageDTO){
		String status=null;
		try{		
			
			SimpleMailMessage email = new SimpleMailMessage();
			//email.setFrom(messageDTO.getSendTo());
	        email.setTo(messageDTO.getSendTo());
	        email.setSubject(messageDTO.getSubject());
	        email.setText(messageDTO.getMessage());         
	        
	        mailSender.send(email);
	        status="Mail sent successfully";
		}catch(Exception exception){
			status="Mail sending failure";
			logger.error(exception.getMessage());
		}
        return status;
	}
}
