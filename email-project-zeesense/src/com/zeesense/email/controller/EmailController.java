package com.zeesense.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.zeesense.email.dto.EmailDTO;
import com.zeesense.email.repository.EmailRepository;
import com.zeesense.email.service.EmailService;
import com.zeesense.email.service.SendMailService;

@Controller
@RequestMapping("*")
public class EmailController {

	@Autowired
	public EmailService emailService;

	@Autowired
	public SendMailService sendMailService;

	@RequestMapping(value = "saveAndSendMail.do", method = RequestMethod.POST)
	public ModelAndView saveAndSendEmail(@ModelAttribute EmailDTO emailDTO) {

		System.out.println(emailDTO);
		System.out.println("into saveAndSend email method");
		if (emailDTO != null) {
			Integer identifier = emailService.saveEmail(emailDTO);

			JsonNode jsonNode = null;
			Object obj=null;
			System.out.println("JsonNOde == null");
			try {
				
				System.out.println("into try block");
//				jsonNode = sendMailService.sendMailToUser(emailDTO);
				obj=sendMailService.sendMailToUser(emailDTO);
			} catch (UnirestException | MessagingException e) {
				e.printStackTrace();
			}
			System.out.println(obj);
			
			if (obj!=null)
				return new ModelAndView("sent-success.html");
			else
				return new  ModelAndView("error.html");
		}

		else
			return new ModelAndView("error.html");

	}

	@RequestMapping(value = "saveEmailAsDraft.do", method = RequestMethod.POST)
	public ModelAndView saveEmail(@ModelAttribute EmailDTO emailDTO) {

		System.out.println(emailDTO);
		Integer id = emailService.saveEmail(emailDTO);

		if (id == null || id == 0) {
			return new ModelAndView((View) new Error("Unexpected Error Occured"));
		} else
			return new ModelAndView("save-success.html");

	}

}
