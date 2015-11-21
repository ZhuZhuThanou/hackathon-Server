package com.wasiwasi.health.dto;

public class RestDTO {

	private static final int OK = 200;
	private static final int FAILED = 400;
	
	private int statusCode;
	private String message;
	private Object data;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public static RestDTO createSuccess() {
		RestDTO dto = new RestDTO();
		dto.setStatusCode(OK); // OK
		return dto;
	}
	public static RestDTO createFailure() {
		RestDTO dto = new RestDTO();
		dto.setStatusCode(FAILED); // OK
		return dto;
	}
}
