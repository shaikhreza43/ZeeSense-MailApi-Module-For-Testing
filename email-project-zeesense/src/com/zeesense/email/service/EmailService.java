package com.zeesense.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeesense.email.dto.EmailDTO;
import com.zeesense.email.repository.EmailRepository;

@Service
public class EmailService {
	
	
	@Autowired
	public EmailRepository  emailRepository;
	
	public Integer saveEmail(EmailDTO emailDTO) {
		return emailRepository.saveEmail(emailDTO);
		
	}
	
	
	
}
