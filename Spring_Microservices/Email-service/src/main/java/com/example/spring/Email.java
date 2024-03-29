package com.example.spring;

public class Email {
	private int id;

	private String to;

	private String subject;

	private String text;
	public Email() {
		super();
	}
	public Email(String to, String subject, String text) {
		super();
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Email [id=" + id + ", to=" + to + ", subject=" + subject + ", text=" + text + "]";
	}
	
	
}
