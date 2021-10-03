/**
 * 
 */
package com.project.Exception;

import com.project.BuyerService.ResponseStatus;

public class BuyerServiceExpection extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResponseStatus status;
	private String message;

	public BuyerServiceExpection() {
	}

	public BuyerServiceExpection(ResponseStatus status, String message) {

		this.status = status;
		this.message = message;
	}

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
