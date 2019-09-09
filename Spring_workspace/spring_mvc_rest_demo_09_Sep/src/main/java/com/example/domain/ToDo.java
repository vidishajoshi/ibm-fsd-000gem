package com.example.domain;

import java.util.Date;
import java.util.UUID;

public class ToDo {

	private String id;
	private String Description;
	private Date scheduleTime;
	public ToDo() {
		super();
	}
	public ToDo(String description, Date scheduleTime) {
		super();
		
		this.id=UUID.randomUUID().toString();
		Description = description;
		this.scheduleTime = scheduleTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	
}
