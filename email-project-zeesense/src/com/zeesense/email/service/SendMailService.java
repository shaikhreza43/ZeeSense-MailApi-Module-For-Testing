package com.zeesense.email.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.mail.smtp.SMTPTransport;
import com.zeesense.email.dto.EmailDTO;

@Service
public class SendMailService {

	public Object sendMailToUser(EmailDTO emailDTO) throws UnirestException, AddressException, MessagingException {

		System.out.println("in send mail to user serice method");
		System.out.println(emailDTO);
//		HttpResponse<JsonNode> request = Unirest
//				.post("https://api.mailgun.net/v3/sandbox210c7c5e74be41ad896208621e36c7fb.mailgun.org/messages")
//				.header("accept", "application/json").header("Content-Type", "application/json")
//				.basicAuth("api", "cfce22c253e1aca1843dcbec61e95b38-9b463597-ed6b89da")
//				.queryString("from", emailDTO.getFromAddress()).queryString("to", emailDTO.getToAddress())
//				.queryString("cc", emailDTO.getCcAddress()).queryString("bcc", emailDTO.getBccAddress())
//				.queryString("subject", emailDTO.getSubject()).queryString("text", emailDTO.getMsgBody())
//				.queryString("html",
//						"<html><head><title>Success</title></head><body><h4>Email Sent Successfully</h4><body></html>")
//				.field("attachment", emailDTO.getAttachment()).asJson();
//
//		return request.getBody();
		//--------------------------------------------------------------------------------------------------------------------------//
		Properties props = System.getProperties();
		props.put("mail.smtps.host", "smtp.mailgun.org");
		props.put("mail.smtps.auth", "true");

		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(emailDTO.getFromAddress()));
		/*msg.setRecipients(, );*/

		InternetAddress[] addrs = InternetAddress.parse(emailDTO.getToAddress(), false);
		msg.setRecipients(Message.RecipientType.TO, addrs);
		
		InternetAddress[] addrs1 = InternetAddress.parse(emailDTO.getCcAddress(), false);
		msg.setRecipients(Message.RecipientType.CC, addrs1);
		
		InternetAddress[] addrs2 = InternetAddress.parse(emailDTO.getBccAddress(), false);
		msg.setRecipients(Message.RecipientType.BCC, addrs2);
		
		
		
//		InternetAddress[] addrs1 = InternetAddress.parse("ahmedreza@zeesense.com", false);
//		msg.setRecipients(Message.RecipientType.TO, addrs);
//		InternetAddress[] addrs2 = InternetAddress.parse("shaikhreza43@gmail.com", false);
//		msg.setRecipients(Message.RecipientType.TO, addrs);

		msg.setSubject(emailDTO.getSubject());
		msg.setText(emailDTO.getMsgBody());
		msg.setFileName(emailDTO.getAttachment());
		msg.setSentDate(new Date());

		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
		t.connect("smtp.mailgun.com", "postmaster@sandbox210c7c5e74be41ad896208621e36c7fb.mailgun.org",
				"e61ce5eaeb33f74889ef75213b190c5c-9b463597-bb924f6f");
		t.sendMessage(msg, msg.getAllRecipients());

		System.out.println("Response: " + t.getLastServerResponse());
		
		t.close();

		
		return t.getLastServerResponse();
	}

}
