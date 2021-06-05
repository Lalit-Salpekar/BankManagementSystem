package com.bms.registrationservice.model;

import java.util.List;

public class ResponseMessage {
	
	private boolean success;
	
	private List<Object> data;
	
	private String error;
	
	
	

	public ResponseMessage(boolean success, List<Object> data, String error) {
		super();
		this.success = success;
		this.data = data;
		this.error = error;
	}

	public ResponseMessage() {
		super();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	
	
	
}
