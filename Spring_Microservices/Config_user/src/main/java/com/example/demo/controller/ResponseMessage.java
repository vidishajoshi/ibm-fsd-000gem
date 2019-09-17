package com.example.demo.controller;

import org.springframework.stereotype.Service;

import lombok.Getter;


public class ResponseMessage {

	
	
	
	private String message;
	private long status;
	public ResponseMessage(String message, long status) {
		super();
		this.message = message;
		this.status = status;
	}
	public ResponseMessage() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	
	
	
}
