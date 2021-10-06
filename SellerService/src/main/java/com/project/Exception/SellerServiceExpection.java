/**
 * 
 */
package com.project.Exception;

import com.project.SellerService.ResponseStatus;

public class SellerServiceExpection extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResponseStatus status;
	private String message;

	public SellerServiceExpection() {
	}

	public SellerServiceExpection(ResponseStatus status, String message) {

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
