package com.project.Response;

import org.springframework.web.bind.annotation.ResponseStatus;

public class Response {

	private ResponseStatus status;
	private String message;

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
