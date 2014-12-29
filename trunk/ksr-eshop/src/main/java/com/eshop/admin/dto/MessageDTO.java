package com.eshop.admin.dto;

public class MessageDTO {
	
	String sendFrom;
	String sendTo;
	String sendToCC;
	String sendToBCC;
	String subject;
	String message;
	public String getSendFrom() {
		return sendFrom;
	}
	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSendToCC() {
		return sendToCC;
	}
	public void setSendToCC(String sendToCC) {
		this.sendToCC = sendToCC;
	}
	public String getSendToBCC() {
		return sendToBCC;
	}
	public void setSendToBCC(String sendToBCC) {
		this.sendToBCC = sendToBCC;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
