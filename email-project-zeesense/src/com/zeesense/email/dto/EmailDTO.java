package com.zeesense.email.dto;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "email_table")
public class EmailDTO implements Serializable {
	
	
	@Id
	@GenericGenerator(name = "email", strategy = "increment")
	@GeneratedValue(generator="email")
	@Column(name="Si_No")
	private int id;
	@Column(name="toAddr")
	private String toAddress;
	@Column(name="fromAddr")
	private String fromAddress;
	@Column(name="ccAddr")
	private String ccAddress;
	@Column(name="bccAddr")
	private String bccAddress;
	@Column(name="subject")
	private String subject;
	@Column(name="email_body")
	private String msgBody;
	@Column(name="attachment")
	private String attachment;

	public EmailDTO() {
		System.out.println(this.getClass().getSimpleName() + " Constructor invoked");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String getBccAddress() {
		return bccAddress;
	}

	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "EmailDTO [toAddress=" + toAddress + ", fromAddress=" + fromAddress + ", ccAddress=" + ccAddress
				+ ", bccAddress=" + bccAddress + ", subject=" + subject + ", msgBody=" + msgBody + ", attachment="
				+ attachment + "]";
	}

}
