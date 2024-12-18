package edu.jspiders.employeeapp.exceptionHandler;

import java.time.LocalDateTime;

public class ApiError 
{
	private LocalDateTime dateTime;
	private Class exceptionClass;
	private String message;
	
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Class getExceptionClass() {
		return exceptionClass;
	}
	public void setExceptionClass(Class exceptionClass) {
		this.exceptionClass = exceptionClass;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
